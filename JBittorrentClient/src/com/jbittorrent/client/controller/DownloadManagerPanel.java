package com.jbittorrent.client.controller;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DownloadManagerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private DownloadTableModel tableModel;
	private JTable table;
	
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
				// TODO Method for valuechanged in table:rajeev
				
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//TODO Download progress logic using progressbar:rajeev
		
		add(scrollPane);
	}

}
