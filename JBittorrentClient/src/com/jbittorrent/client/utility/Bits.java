package com.jbittorrent.client.utility;

import java.util.BitSet;

public class Bits {

	 private boolean[] bits;

	    public Bits(int length){
	        this.bits = new boolean[length];
	    }
	    public Bits(byte[] b) {
	        this.bits = Utils.byteArray2BitArray(b);
	    }
	    public Bits(){}

	    public Bits and(Bits b){
	        if(this.length() != b.length()){
	            System.err.println("Error during and operation: bits length doesn't match");
	            return null;
	        }
	        Bits temp = new Bits(this.length());
	        for(int i = 0; i < this.length(); i++)
	            temp.set(i, this.get(i) && b.get(i));
	        return temp;
	    }

	    public Bits or(Bits b){
	        if(this.length() != b.length()){
	            System.err.println("Error during and operation: bits length doesn't match");
	            return null;
	        }
	        Bits temp = new Bits(this.length());
	        for(int i = 0; i < this.length(); i++)
	            temp.set(i, this.get(i) || b.get(i));
	        return temp;
	    }




	    public void setBits(boolean[] b){
	        this.bits = b;
	    }

	    public int length(){
	        return this.bits.length;
	    }

	    public boolean[] getBits(){
	        return this.bits;
	    }

	    public boolean get(int i){
	        return this.bits[i];
	    }
	    public void set(int i){
	        this.bits[i] = true;
	    }
	    public void set(int i, boolean val){
	        this.bits[i] = val;
	    }

	    public String toString(){
	        String toString = "";
	        for(int i = 0; i < this.bits.length; i++)
	            toString += this.bits[i] ? 1:0;
	        return toString;
	    }
}
