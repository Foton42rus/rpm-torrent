package com.jbittorrent.client.controller;

import java.awt.Component;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ProgressBarManager extends JProgressBar implements TableCellRenderer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProgressBarManager(int min,int max){
		super(min,max);
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		setValue((Integer) value);
		return this;
	}
	
}
