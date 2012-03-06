package com.jbittorrent.client.utility;

import java.io.File;

public class ExamplePublish {

	public static void main(String[] args){
        if(args.length < 4){
            System.out.println(showHelp());
            System.exit(0);
        }
        File f = new File(args[0]);
        String comment = "";
        for(int i = 4; i < args.length; i++)
            comment += args[i];
        try{
            ConnectionManager.publish(args[0], args[1],
                                      args[2], args[3],
                                      f.getName(), "", comment, "7");
        }catch(Exception e){
            System.out.println(showHelp());
            System.exit(0);
        }
    }

    private static String showHelp() {
        return
                "ExamplePublish use:\r\n\tExamplePublish " +
                "torrentPath trackerUploadURL username password comment\r\n\r\n" +
                "If tracker does not need username and password, enter 'none' instead";
    }

}
