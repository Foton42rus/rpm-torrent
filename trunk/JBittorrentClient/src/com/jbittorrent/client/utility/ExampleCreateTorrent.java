package com.jbittorrent.client.utility;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class ExampleCreateTorrent {
	
	 public static void main(String[] args){
	        if(args.length < 5){
	            System.err.println("Wrong parameter number\r\n\r\nUse:\r\n" +
	                               "ExampleCreateTorrent <torrentPath> <announce url> <pieceLength> " +
	                               "<filePath1> <filePath2> ... <..> <creator> <..> <comment>");
	            System.exit(0);
	        }
	        TorrentProcessor tp = new TorrentProcessor();
	        tp.setAnnounceURL(args[1]);
	        try{
	            tp.setPieceLength(Integer.parseInt(args[2]));
	        }catch(Exception e){
	            System.err.println("Piece length must be an integer");
	            System.exit(0);
	        }
	        int i = 3;
	        ArrayList<String> files = new ArrayList<String>();
	        if(!args[i+1].equalsIgnoreCase("..")){
	            tp.setName(args[3]);
	            i++;
	        }
	        while(i < args.length){
	            if(args[i].equalsIgnoreCase(".."))
	                break;
	            files.add(args[i]);
	            i++;
	        }
	        try{
	            tp.addFiles(files);
	        }catch(Exception e){
	            System.err.println(
	                    "Problem when adding files to torrent. Check your data");
	            System.exit(0);
	        }
	        i++;
	        String creator = "";
	        while(i < args.length){
	            if(args[i].equalsIgnoreCase(".."))
	                break;
	            creator += args[i];
	            i++;
	        }
	        tp.setCreator(creator);
	        i++;
	        String comment = "";
	        while(i < args.length){
	            if(args[i].equalsIgnoreCase(".."))
	                break;
	            comment += args[i];
	            i++;
	        }
	        tp.setComment(comment);
	        try{
	            System.out.println("Hashing the files...");
	            System.out.flush();
	            tp.generatePieceHashes();
	            System.out.println("Hash complete... Saving...");
	            FileOutputStream fos = new FileOutputStream(args[0]);
	            fos.write(tp.generateTorrent());
	            System.out.println("Torrent created successfully!!!");
	        }catch(Exception e){
	            System.err.println("Error when writing to the torrent file...");
	            System.exit(1);
	        }
	    }

}
