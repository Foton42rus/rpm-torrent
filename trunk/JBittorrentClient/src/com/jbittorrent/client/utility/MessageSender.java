package com.jbittorrent.client.utility;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.io.OutputStream;
import javax.swing.event.EventListenerList;

public class MessageSender extends Thread{

	 private OutputStream os = null;
	    private LinkedBlockingQueue<Message> outgoingMessage = null;
	    private long lmst = 0;
	    private boolean run = true;
	    private final EventListenerList listeners = new EventListenerList();


	    public MessageSender(String id, OutputStream os) {
	        //this.setName("MS_"+id);
	        this.os = os;
	        this.outgoingMessage = new LinkedBlockingQueue<Message>();
	    }

	    public void addOutgoingListener(OutgoingListener listener) {
	        listeners.add(OutgoingListener.class, listener);
	    }

	    public void removeOutgoingListener(OutgoingListener listener) {
	       listeners.remove(OutgoingListener.class, listener);
	   }

	    public OutgoingListener[] getOutgoingListeners() {
	        return listeners.getListeners(OutgoingListener.class);
	    }

	    /**
	     * Called when the connection to the peer has been closed. Advertise the
	     * DownloadTask that there is no more connection to the remote peer.
	     */
	    protected void fireConnectionClosed() {
	        for (OutgoingListener listener : getOutgoingListeners()) {
	            listener.connectionClosed();
	        }
	    }

	    /**
	     * Called when a keep-alive message has been sent. This happens about every
	     * 2 minutes if there has not been any other messages sent to avoid the
	     * connection to be closed by the remote peer
	     */
	    protected void fireKeepAliveSent() {
	        for (OutgoingListener listener : getOutgoingListeners()) {
	            listener.keepAliveSent();
	        }
	    }

	    /**
	     * Puts the message in parameter in the queue, waiting to be sent
	     * @param m Message
	     */
	    public synchronized void addMessageToQueue(Message m){
	        this.outgoingMessage.add(m);
	        this.lmst = System.currentTimeMillis();
	        //this.notify();
	    }

	    /**
	     * Sends messages from the queue. While the queue is not empty, polls message
	     * from it and sends it to the remote peer. If the queue is empty for more than
	     * 2 minutes, a keep-alive message is sent and the DownloadTask is advertised
	     */
	    public void run() {
	        Message out = null;
	        byte[] keep = new Message_PP(PeerProtocol.KEEP_ALIVE).generate();
	        try {
	            while (this.run) {
	                if(this.outgoingMessage != null && this.os != null)
	                out = outgoingMessage.poll(120000, TimeUnit.MILLISECONDS);
	                if(out != null){
	                    os.write(out.generate());
	                    this.lmst = System.currentTimeMillis();
	                    out = null;
	                }else if(this.run){
	                    os.write(keep);
	                    this.fireKeepAliveSent();
	                }
	            }
	        } catch (InterruptedException ie) {
	        } catch(IOException ioe){
	            this.fireConnectionClosed();
	        } catch(Exception e){
	            this.fireConnectionClosed();
	        }

	        if(this.outgoingMessage != null)
	            this.outgoingMessage.clear();
	        this.outgoingMessage = null;
	        try{
	            this.os.close();
	            this.os = null;
	            this.notify();
	        }catch(Exception e){}

	    }

	    /**
	     * Sets the 'run' variable to false, causing the thread to stop on its next
	     * loop.
	     */
	    public void stopThread(){
	        this.run = false;
	    }

}
