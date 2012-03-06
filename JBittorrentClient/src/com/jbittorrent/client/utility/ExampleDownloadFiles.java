package com.jbittorrent.client.utility;


public class ExampleDownloadFiles {

	 public ExampleDownloadFiles(String[] args){
	        try {
	            TorrentProcessor tp = new TorrentProcessor();

	            if(args.length < 1){
	                System.err.println(
	                        "Incorrect use, please provide the path of the torrent file...\r\n" +
	                        "\r\nCorrect use of ExampleDownloadFiles:\r\n"+
	                        "ExampleDownloadFiles torrentPath");

	                System.exit(1);
	            }
	            TorrentFile t = tp.getTorrentFile(tp.parseTorrent(args[0]));
	            if(args.length > 1)
	                Constants.SAVEPATH = args[1];
	            if (t != null) {
	                DownloadManager dm = new DownloadManager(t, Utils.generateID());
	                dm.startListening(6881, 6889);
	                dm.startTrackerUpdate();
	                dm.blockUntilCompletion();
	                dm.stopTrackerUpdate();
	                dm.closeTempFiles();
	            } else {
	                System.err.println(
	                        "Provided file is not a valid torrent file");
	                System.err.flush();
	                System.exit(1);
	            }
	        } catch (Exception e) {

	            System.out.println("Error while processing torrent file. Please restart the client");
	            //e.printStackTrace();
	            System.exit(1);
	        }

	    }
	    public static void main(String[] args) {
	        new ExampleDownloadFiles(args);
	    }
}
