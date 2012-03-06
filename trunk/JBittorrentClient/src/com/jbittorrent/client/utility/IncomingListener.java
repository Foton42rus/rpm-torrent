package com.jbittorrent.client.utility;

import java.util.EventListener;

public interface IncomingListener extends EventListener{

	/**
     * Fired when a new message has been received
     * @param m Message
     */
    public void messageReceived(Message m);
}
