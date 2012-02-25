package com.jbittorrent.client.controller;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sun.misc.Cleaner;

import com.jbittorrent.client.mainGui.MainGui;

public class DownloadManagerPanel extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private DownloadTableModel tableModel;
	private JTable table;
	//Currently selected download
	private Downloader selectedDownloader;
	private boolean clearing;
	
	public DownloadManagerPanel() {
		super(new GridLayout(1,0));
		tableModel=new DownloadTableModel();
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(500,100));
		table.setFillsViewportHeight(true);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				tableSelectionChanged();
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ProgressBarManager renderer=new ProgressBarManager(0, 100);
		renderer.setStringPainted(true);
		table.setDefaultRenderer(JProgressBar.class, renderer);
		table.setRowHeight((int) renderer.getPreferredSize().getHeight());
		add(scrollPane);
	}
	public void updateToolbar(){
		if(selectedDownloader!=null){
			MainGui.updateToolBarStatus(selectedDownloader.getStatus());
		}else{
			MainGui.updateToolBarStatus(100);
			// fictitious value to indicate no download selected in table
		}
	}
	private void tableSelectionChanged(){
		if(selectedDownloader!=null)
			selectedDownloader.deleteObserver(DownloadManagerPanel.this);
		if(!clearing){
			selectedDownloader=tableModel.getDownload(table.getSelectedRow());
			selectedDownloader.addObserver((DownloadManagerPanel.this));
			updateToolbar();
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		if(selectedDownloader!=null && selectedDownloader.equals(o))
			updateToolbar();
	}
	public void actionPause(){
		selectedDownloader.pause();
		updateToolbar();
	}
	public void actionResume(){
		selectedDownloader.resume();
		updateToolbar();
	}
	public void actionStop(){
		selectedDownloader.stop();
		updateToolbar();
	}
	public void actionAdd(){
		//TODO add logic to add url
		//call verifyUrl method to validate url
	}
	private URL verifyUrl(String url){
		if(!url.toLowerCase().startsWith("http://") || !url.toLowerCase().startsWith("https://"))
			return null;
		
		URL verifiedUrl=null;
		try {
			verifiedUrl=new URL(url);
		} catch (MalformedURLException e) {
			return null;
		}
		if(verifiedUrl.getFile().length()<2 && !verifiedUrl.getFile().endsWith(".torrent"))
			return null;
		
		return verifiedUrl;
	}
}
