package com.jbittorrent.client.utility;

import java.lang.ArrayIndexOutOfBoundsException;
import java.io.InputStream;
import java.io.IOException;

public class PeerProtocol {
	 public static final int HANDSHAKE = -1;
	    public static final int KEEP_ALIVE = 0;
	    public static final int CHOKE = 1;
	    public static final int UNCHOKE = 2;
	    public static final int INTERESTED = 3;
	    public static final int NOT_INTERESTED = 4;
	    public static final int HAVE = 5;
	    public static final int BITFIELD = 6;
	    public static final int REQUEST = 7;
	    public static final int PIECE = 8;
	    public static final int CANCEL = 9;
	    public static final int PORT = 10;
	    public static final String[] TYPE = {"Keep_Alive", "Choke", "Unchoke",
	                                        "Interested", "Not_Interested", "Have",
	                                        "Bitfield", "Request", "Piece",
	                                        "Cancel", "Port"};

	    public static final int BLOCK_SIZE = 16384;
	    public static final byte[] BLOCK_SIZE_BYTES = Utils.intToByteArray(16384);
	
	    public static Message_HS readHS(InputStream is) {
	        try {
	            byte[] length = new byte[1];
	            is.read(length);
	            byte[] protocol = new byte[19];
	            is.read(protocol);
	            byte[] reserved = new byte[8];
	            is.read(reserved);
	            byte[] fileID = new byte[20];
	            is.read(fileID);
	            byte[] peerID = new byte[20];
	            is.read(peerID);

	            return new Message_HS(fileID, peerID);

	        } catch (IOException ioe) {

	        }
	        return null;
	    }

	    public static Message_PP readMessage(InputStream is) {
	        byte[] length = new byte[4];
	        int id;
	        byte[] payload = new byte[0];
	        try {
	            is.read(length);
	            int l = Utils.byteArrayToInt(length);
	            if (l == 0)
	                return new Message_PP(KEEP_ALIVE);

	            long timeout = System.currentTimeMillis();
	            id = is.read();
	            if (l == 1)
	                return new Message_PP(id + 1);
	            l = l - 1;
	            for (int i = 0; i < l; ) {
	                int available = is.available();
	                if (available < l - i) {
	                    byte[] temp = new byte[available];
	                    is.read(temp);
	                    payload = Utils.concat(payload, temp);
	                    i += available;
	                } else {
	                    byte[] temp = new byte[l - i];
	                    is.read(temp);
	                    payload = Utils.concat(payload, temp);
	                    break;
	                }
	            }
	            return new Message_PP(id + 1, payload);
	        } catch (IOException ioe) {
	            System.err.println("Problem when reading message from stream...");
	            ioe.printStackTrace();
	        }
	        return null;
	    }
	
}
