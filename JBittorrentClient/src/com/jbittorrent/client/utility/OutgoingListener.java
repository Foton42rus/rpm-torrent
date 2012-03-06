package com.jbittorrent.client.utility;

import java.util.EventListener;

public interface OutgoingListener extends EventListener{

	/**
     * Fired when the connection to the remote peer has been closed
     */
    public void connectionClosed();

    /**
     * Fired when a keep-alive message has been sent
     */
    public void keepAliveSent();
}
