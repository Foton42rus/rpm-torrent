package com.jbittorrent.client.utility;

import java.util.EventListener;
import java.util.BitSet;

public interface DTListener extends EventListener{

	 public void pieceCompleted(String peerID, int pieceNB, boolean complete);
	    public void pieceRequested(int pieceNB, boolean requested);
	    public void taskCompleted(String id, int reason);
	    public void peerAvailability(String id, BitSet hasPiece);
	    public void peerReady(String id);
	    public void peerRequest(String peerID,int piece, int begin, int length);
	    public void addActiveTask(String id, DownloadTask dt);
}
