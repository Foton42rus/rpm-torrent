package com.jbittorrent.client.jtabbedpanels;

import javax.swing.JPanel;
import java.util.*;


public class Peer extends JPanel {

	/**
	 * Class representing a bittorrent peer
	 */
	 private String id;
    private String ip;
    private int port;
    private boolean interested = false;
    private boolean choked = true;
    private boolean interesting = false;
    private boolean choking = true;
    private BitSet hasPiece;
    private int downloaded = 0;
    private float dlrate = 0;
    private long lastDL = 0;
    private float ulrate = 0;
    private long lastUL = 0;
    private int uploaded = 0;
    
    
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	
	 public Peer() {
        this.hasPiece = new BitSet();
    }

    public Peer(String id, String ip, int port) {
        this.lastDL = System.currentTimeMillis();
        this.lastUL = System.currentTimeMillis();
        this.id = id;
        this.ip = ip;
        this.port = port;
        this.hasPiece = new BitSet();
    }
    
    public void resetDL() {
        this.dlrate = 0;
        this.lastDL = System.currentTimeMillis();
    }

    public void resetUL() {
        this.ulrate = 0;
        this.lastUL = System.currentTimeMillis();
    }

    /**
     * Returns the number of bytes downloaded and uploaded since the last reset
   */
    
    public float getULRate(boolean reset) {
        if (reset) {
            float tmp = this.ulrate;
            this.ulrate = 0;
            return tmp;
        } else {
            return this.ulrate;
        }
    }

    /**
     * Returns the total number of bytes downloaded from this peer
     */
     
    public int getDL() {
        return this.downloaded;
    }

    /**
     * Returns the total number of bytes uploaded to this peer     
     */
    public int getUL() {
        return this.uploaded;
    }

    /**
     * Updates the downloaded values
    
     */
    public void setDLRate(int dl) {
        this.dlrate += dl;
        this.downloaded += dl;
    }

    /**
     * Updates the uploaded values
    
     */
    public void setULRate(int ul) {
        this.ulrate += ul;
        this.uploaded += ul;
    }

    /**
     * Returns the id of this peer
     
     */
    public String getID() {
        return this.id;
    }

    /**
     * Returns the IP address of this peer
     
     */
    public String getIP() {
        return this.ip;
    }

    /**
     * Returns the listening port of this peer
     
     */
    public int getPort() {
        return this.port;
    }

    /**
     * Returns the pieces availability of this peer
     
     */
    public BitSet getHasPiece() {
        return this.hasPiece;
    }

    /**
     * Sets the id of this peer
     
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * Sets the IP address of this peer
     
     */
    public void setIP(String ip) {
        this.ip = ip;
    }

    /**
     * Sets the listening port of this peer
     
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Returns if this peer is interested or not
     
     */
    public boolean isInterested() {
        return this.interested;
    }

    /**
     * Returns if this peer is choked or not
     
     */
    public boolean isChoked() {
        return this.choked;
    }

    /**
     * Returns if this peer is interesting or not
     
     */
    public boolean isInteresting() {
        return this.interesting;
    }

    /**
     * Returns if this peer is choking or not
     
     */
    public boolean isChoking() {
        return this.choking;
    }

    /**
     * Sets if this peer is intereseted or not
     
     */
    public void setInterested(boolean i) {
        this.interested = i;
    }

    /**
     * Sets if this peer is choked or not
     
     */
    public void setChoked(boolean c) {
        this.choked = c;
    }

    /**
     * Sets if this peer is interesting or not
     
     */
    public void setInteresting(boolean i) {
        this.interesting = i;
    }

    /**
     * Sets if this peer is choking or not
     
     */
    public void setChoking(boolean c) {
        this.choking = c;
    }

    /**
     * Updates this peer availability according to the received bitfield
     
     */
    public void setHasPiece(byte[] bitfield) {
        boolean[] b = Utils.byteArray2BitArray(bitfield);
        for (int i = 0; i < b.length; i++) {
            this.hasPiece.set(i, b[i]);
        }
    }

    /**
     * Updates the availability of the piece in parameter
          */
    public void setHasPiece(int piece, boolean has) {
        this.hasPiece.set(piece, has);
    }

    /**
     * Compares if this peer is equal to the peer in parameter
    
     */
    public boolean equals(Peer p) {
        if (this.id == p.getID() && this.ip == p.getIP() && this.port == p.getPort()) {
            return true;
        }
        return false;
    }

    /**
     * Returns this peer characteristics in the form <ip address>:<port>
     
     */
    public String toString() {
        return (this.ip + ":" + this.port);
    }
    

}
