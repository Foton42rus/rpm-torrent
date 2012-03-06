package com.jbittorrent.client.utility;

import java.util.LinkedHashMap;
import java.util.EventListener;
public interface PeerUpdateListener extends EventListener {

	 public void updatePeerList(LinkedHashMap list);
	    public void updateFailed(int error, String message);
}
