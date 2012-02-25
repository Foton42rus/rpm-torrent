package com.jbittorrent.client.controller;

import java.util.Observable;

// This contains the most of the logic to handle the downloads
public class Downloader extends Observable implements Runnable{
	public static final String STATUS[]={"Downloading","Paused","Completed","Error","Seeding","Stopped"};
	//constants to indicate status code
	public static final int DOWNLOADING=0;
	public static final int PAUSED=1;
	public static final int COMPLETED=2;
	public static final int ERROR=3;
	public static final int SEEDING=4;
	public static final int STOPPED=5;
	
	private String name;
	private int size;//Download size
	private int status;//current status
	private int downloaded;//Amount downloaded
	
	public Downloader(){
		size=-1;
		downloaded=0;
		status=DOWNLOADING;
		//TODO Add some more logic to download and call download function which must be created
	}
	//Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDownloaded() {
		return downloaded;
	}
	public void setDownloaded(int downloaded) {
		this.downloaded = downloaded;
	}
	public float getProgress(){
		return((float)downloaded/size)*100;
	}
	//Methods to handle status
	public void resume(){
		status=DOWNLOADING;
		stateChanged();
		//TODO call method to download again inside resume:rajeev
	}
	public void stop(){
		status=STOPPED;
		stateChanged();
	}
	public void error(){
		status=ERROR;
		stateChanged();
	}
	public void pause(){
		status=PAUSED;
		stateChanged();
	}
	public void seeding(){
		status=SEEDING;
		stateChanged();
	}
	public void download(){
		//TODO may a thread be started here to start:rajeev
	}
	@Override
	public void run() {
		// TODO Must implement:rajeev
		
	}
	//To handle the updates 
	public void stateChanged(){
		//Methods of Observable to handle changes
		setChanged();
		notifyObservers();
	}
}
