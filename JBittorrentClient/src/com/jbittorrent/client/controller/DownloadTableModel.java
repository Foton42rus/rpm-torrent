package com.jbittorrent.client.controller;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JProgressBar;
import javax.swing.table.AbstractTableModel;

public class DownloadTableModel extends AbstractTableModel implements Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] colNames={"Name","Size","Status","Progress","Downloaded","ETA","Seeds","Peers","Uploaded","Ratio"};
	private static final Class[] colClasses={String.class,String.class,String.class,JProgressBar.class,String.class,String.class,String.class,String.class,String.class,String.class};
	private ArrayList<Downloader> downloadList=new ArrayList<Downloader>();
	public void addDownload(Downloader d){
		d.addObserver(this);
		downloadList.add(d);
		//Table insertion notification
		fireTableRowsInserted(getRowCount()-1,getRowCount()-1);
	}
	public String getColumnName(int col){
		return colNames[col].toString();
	}
	//Get a downloader object for a specified row
	public Downloader getDownload(int row){
		return downloadList.get(row);
	}
	@Override
	public int getRowCount() {
		return downloadList.size();
	}
	
	@Override
	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Downloader downloader=(Downloader)downloadList.get(rowIndex);
		switch(columnIndex){
		case 0:
			return downloader.getName();
		case 1:
			int size=downloader.getSize();
			return (size==-1)?"":Integer.toString(size);
		case 2:
			return Downloader.STATUS[downloader.getStatus()];
		case 3:
			return (float)downloader.getProgress();
		case 4:
			//TODO add logic for amount of data downloaded:rajeev
		case 5:
			//TODO add logic for estimated time(ETA):rajeev
		case 6:
			//TODO add logic for counting seeders:rajeev
		case 7:
			//TODO add logic for counting peers:rajeev
		case 8:
			//TODO add logic for amount of data uploaded:rajeev
		case 9:
			//TODO add logic for calculating the ratio of up/dwn:rajeev
		}
		return "";
	}
	//Remove download
	public void removeDownload(int row){
		downloadList.remove(row);
		fireTableRowsDeleted(row, row);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getColumnClass(int col){
		return colClasses[col];
		
	}
	public void update(Observable o,Object arg){
		int row=downloadList.indexOf(o);
		fireTableRowsUpdated(row, row);
	}

}
