package com.jbittorrent.client.utility;

import java.util.*;

public class ULRateComparator implements Comparator{

	/**
     * Compares its two arguments for order.
     *
     * @param a the first object to be compared.
     * @param b the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first
     * argument is less than, equal to, or greater than the second.
     */
    public int compare(Object a, Object b) {
        if (a instanceof Peer && b instanceof Peer)
            if (((Peer) a).getULRate(false) > ((Peer) b).getULRate(false))
                return -1;
            else if (((Peer) a).getULRate(false) < ((Peer) b).getULRate(false))
                return 1;
        return 0;
    }
}
