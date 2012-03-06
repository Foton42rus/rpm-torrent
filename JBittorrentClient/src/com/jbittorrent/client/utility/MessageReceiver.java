package com.jbittorrent.client.utility;

import java.io.*;
import javax.swing.event.EventListenerList;

public class MessageReceiver extends Thread{

	private boolean run = true;
    private InputStream is = null;
    private DataInputStream dis = null;
    private boolean hsOK = false;
    private final EventListenerList listeners = new EventListenerList();

    /**
     * Create a new Message receiver for a given peer
     * @param id The id of the peer that has been assigned this receiver
     * @param is InputStream
     * @throws IOException
     */
    public MessageReceiver(String id, InputStream is) throws IOException {
        //this.setName("MR_" + id);
        this.is = is;
        this.dis = new DataInputStream(is);
    }

    /**
     * Reads bytes from the DataInputStream
     * @param data byte[]
     * @return int
     *
     */
    private int read(byte[] data){
        try{
            this.dis.readFully(data);
        }catch(IOException ioe){
            return -1;
        }
        return data.length;
    }

    /**
     * Reads bytes from theInputStream
     * @param data byte[]
     * @return int
     * @throws IOException
     * @throws InterruptedException
     * @deprecated
     */
    private int read2(byte[] data)throws IOException, InterruptedException{
        int totalread = 0;
        int read = 0;
        while(totalread != data.length){
            if((read = this.is.read(data, totalread, data.length - totalread)) == -1)
                return -1;
            totalread += read;
            this.sleep(50);
        }
        return totalread;
    }

    /**
     * Reads bytes from the input stream. This read method read exactly the number of
     * bytes corresponding to the length of the byte array given in parameter
     * @param data byte[]
     * @return int
     * @throws IOException
     * @throws InterruptedException
     * @throws Exception
     * @todo Optimize this method which seems to take too much time...
     */
    private int read1(byte[] data) throws IOException, InterruptedException, Exception {
        int l = data.length;
        byte[] payload = new byte[0];
        int loop = 0;
        for (int i = 0; i < l; ) {
            loop++;
            int available = is.available();

            if (available < l - i) {
                loop++;
                byte[] temp = new byte[available];
                if (is.read(temp) == -1){
                    return -1;
                }
                payload = Utils.concat(payload, temp);
                i += available;
                this.sleep(10);
            } else {
                byte[] temp = new byte[l - i];
                if (is.read(temp) == -1){
                    return -1;
                }
                payload = Utils.concat(payload, temp);
                Utils.copy(payload, data);
                return payload.length;
            }
        }
        return -1;
    }

    /**
     * Reads data from the inputstream, creates new messages according to the
     * received data and fires MessageReceived method of the listeners with the
     * new message in parameter. Loops as long as the 'run' variable is true
     */
    public void run() {
        //Message m = null;
        int read = 0;
        byte[] lengthHS = new byte[1];
        byte[] protocol = new byte[19];
        byte[] reserved = new byte[8];
        byte[] fileID = new byte[20];
        byte[] peerID = new byte[20];
        byte[] length = new byte[4];
        Message_HS hs = new Message_HS();
        Message_PP mess = new Message_PP();

        while (this.run) {
            int l = 1664;
            try {
                if (!hsOK) {
                    //System.out.println("Wait for hs");

                    if ((read = this.read(lengthHS)) > 0) {
                        for (int i = 0; i < 19; i++)
                            protocol[i] = (byte) is.read();
                        for (int i = 0; i < 8; i++)
                            reserved[i] = (byte) is.read();
                        for (int i = 0; i < 20; i++)
                            fileID[i] = (byte) is.read();
                        for (int i = 0; i < 20; i++)
                            peerID[i] = (byte) is.read();

                        hs.setData(lengthHS, protocol, reserved,
                                           fileID, peerID);
                        //this.hsOK = true;
                    } else {
                        hs = null;
                    }
                } else {
                    int id;
                    if ((read = this.read(length)) > 0) {
                        l = Utils.byteArrayToInt(length);
                        if (l == 0) {
                            mess.setData(PeerProtocol.KEEP_ALIVE);
                        } else {
                            id = is.read();
                            if(id == -1){
                                System.err.println("id");
                                mess = null;
                            }else{
                                if (l == 1)
                                    mess.setData(id + 1);
                                else {
                                    l = l - 1;
                                    byte[] payload = new byte[l];
                                    if (this.read(payload) > 0)
                                        mess.setData(id + 1, payload);
                                    payload = null;
                                }
                            }
                        }
                    } else {
                        mess = null;
                    }
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
                this.fireMessageReceived(null);
                return;
                // m = null;
            } /*catch (InterruptedException ie) {
                this.fireMessageReceived(null);
                return;
                // m = null;
            } */catch (Exception e) {
                System.err.println(l+"Error in MessageReceiver..."+e.getMessage()
                        +" " + e.toString());
                this.fireMessageReceived(null);
                return;
                // m = null;
            }

            if(!this.hsOK){
                this.fireMessageReceived(hs);
                this.hsOK = true;
            }else{
                this.fireMessageReceived(mess);
            }
            // m = null;
        }
        try{
            this.dis.close();
            this.dis = null;
        }catch(Exception e){}

    }

    public void addIncomingListener(IncomingListener listener) {
        listeners.add(IncomingListener.class, listener);
    }

    public void removeIncomingListener(IncomingListener listener) {
        listeners.remove(IncomingListener.class, listener);
    }

    public IncomingListener[] getIncomingListeners() {
        return listeners.getListeners(IncomingListener.class);
    }

    protected void fireMessageReceived(Message m) {
        for (IncomingListener listener : getIncomingListeners()) {
            listener.messageReceived(m);
        }
    }

    /**
     * Stops the current thread by completing the run() method
     */
    public void stopThread(){
        this.run = false;
    }
}
