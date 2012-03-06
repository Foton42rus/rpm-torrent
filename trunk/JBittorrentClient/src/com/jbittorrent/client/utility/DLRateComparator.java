package com.jbittorrent.client.utility;

import java.util.*;

public class DLRateComparator implements Comparator {

	 public int compare(Object a, Object b) {
	        if (a instanceof Peer && b instanceof Peer)
	            if (((Peer) a).getDLRate(false) > ((Peer) b).getDLRate(false))
	                return -1;
	            else if (((Peer) a).getDLRate(false) < ((Peer) b).getDLRate(false))
	                return 1;
	        return 0;
	    }
}
