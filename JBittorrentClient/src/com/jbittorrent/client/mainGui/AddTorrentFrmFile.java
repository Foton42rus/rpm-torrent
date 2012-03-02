package com.jbittorrent.client.mainGui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.UIManager;
import java.awt.Color;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class AddTorrentFrmFile  extends JDialog {
	private static final long serialVersionUID = 1L;
	public static JFileChooser jfc;
	public static String fileName;
	public static int result;
	
	public AddTorrentFrmFile() {
		jfc=new JFileChooser();
		jfc.setDialogTitle("Please select the torrent file to add..");
		jfc.setDialogType(JFileChooser.OPEN_DIALOG);
		jfc.setFileFilter(new FileFilter () {
			
			public String getDescription() {
				return "Only Torrent files";
			}
			public boolean accept(File f) {
				fileName = f.getName();
				if(f.isDirectory())
					return true;
				else if(f.getName().endsWith(".torrent"))
					return true;
				else return false;
			}
		});
		
		 result=jfc.showOpenDialog(MainGui.frmJtorrent);
	
	}
		
}


