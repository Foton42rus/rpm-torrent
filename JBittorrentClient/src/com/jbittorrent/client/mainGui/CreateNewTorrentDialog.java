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

public class CreateNewTorrentDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the dialog.
	 */
	public CreateNewTorrentDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreateNewTorrentDialog.class.getResource("/images/icon.png")));
		setTitle("Create New Torrent");
		setBounds(100, 100, 496, 523);
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
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Select Source", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
				JButton btnNewButton = new JButton("Add file");
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
				gbc_btnNewButton.gridx = 4;
				gbc_btnNewButton.gridy = 1;
				panel.add(btnNewButton, gbc_btnNewButton);
			}
			{
				JButton btnNewButton_1 = new JButton("Add Directory");
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
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Torrent Attributes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{22, 22, 1, 278, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				JLabel lblPieces = new JLabel("Piece Size:");
				GridBagConstraints gbc_lblPieces = new GridBagConstraints();
				gbc_lblPieces.insets = new Insets(0, 0, 0, 5);
				gbc_lblPieces.gridx = 0;
				gbc_lblPieces.gridy = 5;
				panel.add(lblPieces, gbc_lblPieces);
			}
			{
				JSpinner spinner = new JSpinner();
				GridBagConstraints gbc_spinner = new GridBagConstraints();
				gbc_spinner.insets = new Insets(0, 0, 0, 5);
				gbc_spinner.gridwidth = 2;
				gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
				gbc_spinner.gridx = 2;
				gbc_spinner.gridy = 5;
				panel.add(spinner, gbc_spinner);
				spinner.setModel(new SpinnerListModel(new String[] {"16 KB", "32 KB", "64 KB", "128 KB", "256 KB", "512 KB", "1024 KB", "2048 KB", "4096 KB", "8192 KB", "16384 KB"}));
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton createButton = new JButton("Create and Save as");
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
