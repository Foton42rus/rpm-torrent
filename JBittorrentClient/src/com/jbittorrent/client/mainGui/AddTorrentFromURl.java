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
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddTorrentFromURl extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	
	
	/**
	 * Create the dialog.
	 */
	
	public AddTorrentFromURl() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreateNewTorrentDialog.class.getResource("/images/icon.png")));
		setTitle("Add Torrent From URL");
		setBounds(100, 100, 496, 150);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{22, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Please enter the location of .torrent you want to open", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{68, 9, 0, 0, 105, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
		{
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.gridwidth = 8;
			gbc_textField.fill = GridBagConstraints.BOTH;
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.gridx = 0;
			gbc_textField.gridy = 0;
			panel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		
		{
			JButton btnNewButton = new JButton("Ok");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
                  //TODO add logic for adding the file from specific URL:pushpendra
					
				}
			});
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton.gridx = 4;
			gbc_btnNewButton.gridy = 1;
			panel.add(btnNewButton, gbc_btnNewButton);
		}
		
		{
			JButton btnNewButton_1 = new JButton("Cancel");
			btnNewButton_1.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			   dispose();
		    }
			});
			GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
			gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton_1.gridwidth = 2;
			gbc_btnNewButton_1.gridx = 5;
			gbc_btnNewButton_1.gridy = 1;
			panel.add(btnNewButton_1, gbc_btnNewButton_1);
		}
		
	}
		setVisible(true);
}
}
