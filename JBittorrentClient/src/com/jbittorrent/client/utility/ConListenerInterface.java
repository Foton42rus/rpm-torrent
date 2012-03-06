package com.jbittorrent.client.utility;

import java.util.EventListener;
import java.net.Socket;

public interface ConListenerInterface extends EventListener{

	public void connectionAccepted(Socket s);
}
