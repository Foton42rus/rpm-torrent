package com.jbittorrent.client.controller;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JProgressBar;
import javax.swing.table.AbstractTableModel;

public class DownloadTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] colNames={"Name","Size","Status","Progress","Downloaded","ETA","Seeds","Peers","Uploaded","Ratio"};
	private static final Class[] colClasses={String.class,String.class,String.class,JProgressBar.class,String.class,String.class,String.class,String.class,String.class,String.class};
	private ArrayList<String> downloadList=new ArrayList<String>();
	public void addDownload(){
		// TODO Complete the download logic:Create a class runnable and observable

	}
	public String getColumnName(int col){
		return colNames[col].toString();
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
		// TODO Auto-generated method stub
		return null;
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
