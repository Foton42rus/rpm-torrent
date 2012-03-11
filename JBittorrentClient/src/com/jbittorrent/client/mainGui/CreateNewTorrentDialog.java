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

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class CreateNewTorrentDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNull;
	private JTextField textField_1;
	private File file; // Representative for file or directory selected
	private JTextField textField_2;

	/**
	 * Create the dialog.
	 */
	public CreateNewTorrentDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				CreateNewTorrentDialog.class.getResource("/images/icon.png")));
		setTitle("Create New Torrent");
		setBounds(100, 100, 496, 523);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 22, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager
					.getBorder("TitledBorder.border"), "Select Source",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,
							0, 0)));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 68, 9, 0, 0, 105, 0, 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0,
					0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				txtNull = new JTextField();
				GridBagConstraints gbc_txtNull = new GridBagConstraints();
				gbc_txtNull.gridwidth = 8;
				gbc_txtNull.fill = GridBagConstraints.BOTH;
				gbc_txtNull.insets = new Insets(0, 0, 5, 0);
				gbc_txtNull.gridx = 0;
				gbc_txtNull.gridy = 0;
				panel.add(txtNull, gbc_txtNull);
				txtNull.setColumns(10);
			}
			{
				JButton btnNewButton = new JButton("Add file");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser jfc = new JFileChooser();
						jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
						jfc.setApproveButtonText("Select File");
						int result = jfc.showOpenDialog(contentPanel);
						if (result == JFileChooser.APPROVE_OPTION) {
							file = jfc.getSelectedFile();
							txtNull.setText(file.getAbsolutePath());

							// TODO Logic to add file to torrent file:rajeev
						}
					}
				});
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
				gbc_btnNewButton.gridx = 4;
				gbc_btnNewButton.gridy = 1;
				panel.add(btnNewButton, gbc_btnNewButton);
			}
			{
				JButton btnNewButton_1 = new JButton("Add Directory");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser jfc = new JFileChooser();
						jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						jfc.setApproveButtonText("Select Directory");
						int res = jfc.showOpenDialog(contentPanel);
						if (res == JFileChooser.APPROVE_OPTION) {
							// TODO Logic to add directory to torrent
							// file:rajeev
						}

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
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager
					.getBorder("TitledBorder.border"), "Torrent Attributes",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,
							0, 0)));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.HORIZONTAL;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 22, 22, 1, 278, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0,
					Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JLabel lblTrackers = new JLabel("Trackers:");
				GridBagConstraints gbc_lblTrackers = new GridBagConstraints();
				gbc_lblTrackers.insets = new Insets(0, 0, 5, 5);
				gbc_lblTrackers.gridx = 0;
				gbc_lblTrackers.gridy = 0;
				panel.add(lblTrackers, gbc_lblTrackers);
			}
			{
				JTextArea textArea = new JTextArea();
				GridBagConstraints gbc_textArea = new GridBagConstraints();
				gbc_textArea.gridwidth = 2;
				gbc_textArea.anchor = GridBagConstraints.SOUTH;
				gbc_textArea.fill = GridBagConstraints.HORIZONTAL;
				gbc_textArea.insets = new Insets(0, 0, 5, 5);
				gbc_textArea.gridx = 2;
				gbc_textArea.gridy = 0;
				panel.add(textArea, gbc_textArea);
				textArea.setRows(6);
			}
			{
				JLabel lblCreator = new JLabel("Creator:");
				GridBagConstraints gbc_lblCreator = new GridBagConstraints();
				gbc_lblCreator.insets = new Insets(0, 0, 5, 5);
				gbc_lblCreator.gridx = 0;
				gbc_lblCreator.gridy = 1;
				panel.add(lblCreator, gbc_lblCreator);
			}
			{
				textField_2 = new JTextField();
				GridBagConstraints gbc_textField_2 = new GridBagConstraints();
				gbc_textField_2.gridwidth = 2;
				gbc_textField_2.insets = new Insets(0, 0, 5, 5);
				gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_2.gridx = 2;
				gbc_textField_2.gridy = 1;
				panel.add(textField_2, gbc_textField_2);
				textField_2.setColumns(10);
			}
			{
				Component rigidArea = Box
						.createRigidArea(new Dimension(20, 20));
				GridBagConstraints gbc_rigidArea = new GridBagConstraints();
				gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
				gbc_rigidArea.gridx = 3;
				gbc_rigidArea.gridy = 2;
				panel.add(rigidArea, gbc_rigidArea);
			}
			{
				JLabel lblComment = new JLabel("Comment:");
				GridBagConstraints gbc_lblComment = new GridBagConstraints();
				gbc_lblComment.insets = new Insets(0, 0, 5, 5);
				gbc_lblComment.gridx = 0;
				gbc_lblComment.gridy = 3;
				panel.add(lblComment, gbc_lblComment);
			}
			{
				textField_1 = new JTextField();
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.gridwidth = 2;
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.insets = new Insets(0, 0, 5, 5);
				gbc_textField_1.gridx = 2;
				gbc_textField_1.gridy = 3;
				panel.add(textField_1, gbc_textField_1);
				textField_1.setColumns(10);
			}
			{
				Component rigidArea = Box
						.createRigidArea(new Dimension(20, 20));
				GridBagConstraints gbc_rigidArea = new GridBagConstraints();
				gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
				gbc_rigidArea.gridx = 3;
				gbc_rigidArea.gridy = 4;
				panel.add(rigidArea, gbc_rigidArea);
			}
			{
				JLabel lblPieces = new JLabel("Piece Size:");
				GridBagConstraints gbc_lblPieces = new GridBagConstraints();
				gbc_lblPieces.insets = new Insets(0, 0, 5, 5);
				gbc_lblPieces.gridx = 0;
				gbc_lblPieces.gridy = 5;
				panel.add(lblPieces, gbc_lblPieces);
			}
			{
				JSpinner spinner = new JSpinner();
				GridBagConstraints gbc_spinner = new GridBagConstraints();
				gbc_spinner.insets = new Insets(0, 0, 5, 5);
				gbc_spinner.gridwidth = 2;
				gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
				gbc_spinner.gridx = 2;
				gbc_spinner.gridy = 5;
				panel.add(spinner, gbc_spinner);
				spinner.setModel(new SpinnerListModel(
						new String[] { "16 KB", "32 KB", "64 KB", "128 KB",
								"256 KB", "512 KB", "1024 KB", "2048 KB",
								"4096 KB", "8192 KB", "16384 KB" }));
			}
			{
				Component rigidArea = Box
						.createRigidArea(new Dimension(20, 20));
				GridBagConstraints gbc_rigidArea = new GridBagConstraints();
				gbc_rigidArea.insets = new Insets(0, 0, 0, 5);
				gbc_rigidArea.gridx = 3;
				gbc_rigidArea.gridy = 6;
				panel.add(rigidArea, gbc_rigidArea);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton createButton = new JButton("Create and Save as");
				createButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtNull.getText().equals("")
								&& textField_1.getText().equals("")
								&& textField_2.getText().equals("")){
							int res=JOptionPane.showConfirmDialog(contentPanel,"you must supply all parameter correctly! Want to continue.", "Some fields are blank!",JOptionPane.YES_NO_OPTION);
						   if(res==JOptionPane.NO_OPTION)
							   CreateNewTorrentDialog.this.dispose();
						}else {
							JFileChooser jfc = new JFileChooser();
							jfc.setDialogTitle("Set the name of torrent file you want to create:");
							int result = jfc.showSaveDialog(contentPanel);
							if (result == JFileChooser.APPROVE_OPTION) {
								
								// TODO logic to call the function form
								// utilityclasses package which will create
								// torrent:rajeev
							}
						}
					}
				});
				createButton.setActionCommand("CREATE");
				buttonPane.add(createButton);
				getRootPane().setDefaultButton(createButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}

}
