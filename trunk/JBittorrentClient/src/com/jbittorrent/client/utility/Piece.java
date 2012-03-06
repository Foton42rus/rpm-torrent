package com.jbittorrent.client.utility;

import java.util.*;

public class Piece {

	private TreeMap<Integer, Integer> filesAndoffset;
    /**
     * Index of the piece within the file(s)
     */
    private int index;
    /**
     * Length of the piece. It should be constant, except for the last piece of the file(s)
     */
    private int length;
    /**
     * Map containing the piece data
     */
    private TreeMap<Integer, byte[]> pieceBlock;
    /**
     * SHA1 hash of the piece contained in the torrent file. At the end of the download
     * this value must correspond to the SHA1 hash of the pieceBlock map concatenated
     */
    byte[] sha1;

    public Piece(int index, int length, int blockSize, byte[] sha1){
        this(index, length, blockSize, sha1, null);
    }

    /**
     * Constructor of a Piece
     * @param index Index of the piece
     * @param length Length of the piece
     * @param blockSize Size of a block of data
     * @param sha1 SHA1 hash that must be verified at the end of download
     * @param m HashTable containing the file(s) this piece belongs to and the index in these
     */
    public Piece(int index, int length, int blockSize, byte[] sha1, TreeMap<Integer, Integer> m) {
        this.index = index;
        this.length = length;
        this.pieceBlock = new TreeMap<Integer, byte[]>();
        this.sha1 = sha1;
        if(m != null)
            this.filesAndoffset = m;
        else
            this.filesAndoffset = new TreeMap<Integer, Integer>();
    }

    public void clearData(){
        this.pieceBlock.clear();
    }

    public void setFileAndOffset(int file, int offset){
        this.filesAndoffset.put(file, offset);
    }

    public TreeMap getFileAndOffset(){
        return this.filesAndoffset;
    }

    /**
     * Return the index of the piece
     * @return int
     */
    public synchronized int getIndex(){
        return this.index;
    }

    /**
     * Returns the length of the piece
     * @return int
     */
    public synchronized int getLength(){
        return this.length;
    }

    /**
     * Set a block of data at the corresponding offset
     * @param offset Offset of the data within the current piece
     * @param data Data to be set at the given offset
     */
    public synchronized void setBlock(int offset, byte[] data){
        this.pieceBlock.put(offset, data);
    }

    /**
     * Returns the concatenated value of the pieceBlock map. This represent the piece data
     * @return byte[]
     */
    public synchronized byte[] data(){
        byte[] data = new byte[0];
        for(Iterator it = this.pieceBlock.keySet().iterator(); it.hasNext();)
            data = Utils.concat(data, this.pieceBlock.get(it.next()));
        return data;
    }

    /**
     * Verify if the downloaded data corresponds to the original data contained in the torrent
     * by comparing it to the SHA1 hash in the torrent
     * @return boolean
     */
    public synchronized boolean verify(){
        return Utils.byteArrayToByteString(Utils.hash(this.data())).matches(Utils.byteArrayToByteString(this.sha1));
    }

    /**
     * Print some information about the Piece
     * @return String
     */
    public synchronized String toString(){
        String s = "";
        s += "Piece " + this.index + "[" + this.length + "Bytes], part of file";
        if(this.filesAndoffset.size() > 1)
            s += "s";
        for(Iterator it = this.filesAndoffset.keySet().iterator(); it.hasNext();){
            int key = ((Integer)(it.next())).intValue();
            s += " " + key + " [offset = " + this.filesAndoffset.get(key)+"]";
            if(it.hasNext())
                s += " and";
        }
        return s;
    }
}
