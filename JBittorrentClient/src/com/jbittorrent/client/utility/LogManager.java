package com.jbittorrent.client.utility;

import java.io.*;
import java.util.*;

public class LogManager {

	private String filename;
    private OutputStream os;
    public FileWriter fw;

    public LogManager(String logfile) {
        this.filename = logfile;
    }

    /**
     * Write the given string to the file corresponding to this manager
     * @param s String
     */
    synchronized public void writeLog(String s){
        try{
            this.fw = new FileWriter(this.filename, true);
            Date d = new Date();

            this.fw.write(d+" : "+s+"\r\n");
            this.fw.flush();
            this.fw.close();
        }catch(Exception e){
            System.out.println("Not able to write to log file");
        }
    }

}
