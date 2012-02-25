package com.jbittorrent.client.mainGui;
import com.jbittorrent.client.controller.DownloadManagerPanel;
import com.jbittorrent.client.controller.Downloader;
import com.jbittorrent.client.jtabbedpanels.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class MainGui {

	private JFrame frmJtorrent;
	private static JButton resumeTorrent;
	private static JButton pauseTorrent ;
	private static JButton stopTorrent ;
	private DownloadManagerPanel downloadManagerPanelContainer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frmJtorrent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJtorrent = new JFrame();
		frmJtorrent.setIconImage(Toolkit.getDefaultToolkit().getImage(MainGui.class.getResource("/images/icon.png")));
		frmJtorrent.setTitle("j-torrent");
		frmJtorrent.setBounds(100, 100, 1041, 819);
		frmJtorrent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		frmJtorrent.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		mainPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel leftRegion = new JPanel();
		leftRegion.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftRegion.setBackground(new Color(204, 255, 204));
		panel.add(leftRegion, BorderLayout.WEST);
		leftRegion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new TreeClass();
		panel_1.setBackground(Color.WHITE);
		panel_1.setPreferredSize(new Dimension(135, 574));
		panel_1.setSize(new Dimension(200, 500));
		leftRegion.add(panel_1);
		JPanel centerRegion = new JPanel();
		centerRegion.setBackground(new Color(135, 206, 235));
		panel.add(centerRegion, BorderLayout.CENTER);
		centerRegion.setLayout(new BorderLayout(0, 0));
		
		JPanel lowerRegion = new JPanel();
		lowerRegion.setBorder(new LineBorder(SystemColor.activeCaption));
		
		JPanel toolBarContainer = new JPanel();
		toolBarContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
		toolBarContainer.setBackground(new Color(230, 230, 250));
		centerRegion.add(toolBarContainer, BorderLayout.NORTH);
		toolBarContainer.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		toolBarContainer.add(toolBar);
		toolBar.setBorderPainted(false);
		toolBar.setBackground(new Color(230, 230, 250));
		toolBar.setFloatable(false);
		
		JButton addTorFile = new JButton("");
		addTorFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Not working yet:make it to work:rajeev
				//JOptionPane.showInternalMessageDialog(frmJtorrent, "Enter the URL of torrent file");
			}
		});
		addTorFile.setBackground(new Color(230, 230, 250));
		addTorFile.setToolTipText("Add torrent from file");
		addTorFile.setIcon(new ImageIcon(MainGui.class.getResource("/images/toolbarimage/file_add_tor.png")));
		toolBar.add(addTorFile);
		JButton addTorUrl=new JButton("");
		addTorUrl.setBackground(new Color(230, 230, 250));
		addTorUrl.setToolTipText("Add torrent form a url");
		addTorUrl.setIcon(new ImageIcon(MainGui.class.getResource("/images/toolbarimage/add_tor_url.png")));
		toolBar.add(addTorUrl);
		toolBar.addSeparator();
		JButton newTorrent = new JButton("");
		newTorrent.setToolTipText("Create New torrent");
		newTorrent.setBackground(new Color(230, 230, 250));
		newTorrent.setIcon(new ImageIcon(MainGui.class.getResource("/images/toolbarimage/new_torr.png")));
		toolBar.add(newTorrent);
		toolBar.addSeparator();
		
		resumeTorrent = new JButton("");
		resumeTorrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				downloadManagerPanelContainer.actionResume();
			}
		});
		resumeTorrent.setToolTipText("Start Downloading");
		resumeTorrent.setBackground(new Color(230, 230, 250));
		resumeTorrent.setIcon(new ImageIcon(MainGui.class.getResource("/images/toolbarimage/start.png")));
		toolBar.add(resumeTorrent);
		
		pauseTorrent = new JButton("");
		pauseTorrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				downloadManagerPanelContainer.actionPause();
			}
		});
		pauseTorrent.setToolTipText("Pause Downloading");
		pauseTorrent.setIcon(new ImageIcon(MainGui.class.getResource("/images/toolbarimage/pause.png")));
		pauseTorrent.setBackground(new Color(230, 230, 250));
		toolBar.add(pauseTorrent);
		
		stopTorrent = new JButton("");
		stopTorrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				downloadManagerPanelContainer.actionStop();
			}
		});
		stopTorrent.setToolTipText("Stop Downloading");
		stopTorrent.setBackground(new Color(230, 230, 250));
		stopTorrent.setIcon(new ImageIcon(MainGui.class.getResource("/images/toolbarimage/stop.png")));
		toolBar.add(stopTorrent);
		toolBar.addSeparator();
		
		JButton settings = new JButton("");
		settings.setToolTipText("Settings");
		settings.setIcon(new ImageIcon(MainGui.class.getResource("/images/toolbarimage/settings.png")));
		settings.setBackground(new Color(230, 230, 250));
		toolBar.add(settings);
		downloadManagerPanelContainer=new DownloadManagerPanel();
		centerRegion.add(downloadManagerPanelContainer, BorderLayout.CENTER);
		lowerRegion.setBackground(new Color(255, 255, 255));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		//ch
		tabbedPane.setSize(lowerRegion.getSize());
		GenaralPanel gp=new GenaralPanel();
		gp.setPreferredSize(new Dimension(944, 129));
		gp.setBorder(null);
		Toolkit.getDefaultToolkit().getDesktopProperty("Size");
		//gp.setPreferredSize(new Dimension(945, 194));
		Tracker tk=new Tracker();
		FlowLayout flowLayout_1 = (FlowLayout) tk.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		Peers pr=new Peers();
		FlowLayout flowLayout_2 = (FlowLayout) pr.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		Pieces p=new Pieces();
		Files f=new Files();
		Speed s=new Speed();
		Logger lg=new Logger();
		Icon gic=new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGui.class.getResource("/images/infog.png")));
		lowerRegion.setLayout(new BorderLayout(0, 0));
		tabbedPane.addTab("General",gic, gp, "This tab has general information");
		gp.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tabbedPane.addTab("Trackers",new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGui.class.getResource("/images/tracker.png"))),tk);
		tabbedPane.addTab("Peers",new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGui.class.getResource("/images/peers.png"))),pr);
		tabbedPane.addTab("Pieces",new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGui.class.getResource("/images/pieces.png"))),p);
		tabbedPane.addTab("Files",new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGui.class.getResource("/images/files.png"))), f);
		tabbedPane.addTab("Speed",new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGui.class.getResource("/images/speed.png"))),s);
		tabbedPane.addTab("Logger",new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainGui.class.getResource("/images/logger.png"))),lg);
		lowerRegion.add(tabbedPane);
		panel.add(lowerRegion,BorderLayout.SOUTH);
		JMenuBar menuBar = new JMenuBar();
		frmJtorrent.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAddTorrentFile = new JMenuItem("Add Torrent File From Url");
		mnFile.add(mntmAddTorrentFile);
		
		JMenuItem mntmAddNewTorrent = new JMenuItem("Add New Torrent");
		mntmAddNewTorrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser();
				jfc.setDialogTitle("Please select the torrent file to add..");
				jfc.setDialogType(JFileChooser.OPEN_DIALOG);
				jfc.setFileFilter(new FileFilter(){
					public String getDescription(){
						return "Only Torrent files";
					}
					public boolean accept(File f){
						if(f.isDirectory())
							return true;
						else if(f.getName().endsWith(".torrent"))
							return true;
						else return false;
					}
				});
				int result=jfc.showOpenDialog(frmJtorrent);
				if(result==JFileChooser.APPROVE_OPTION){
					//TODO Insert logic to add torrent:rajeev
				}
			}
		});
		mnFile.add(mntmAddNewTorrent);
		
		JMenuItem mntmCreateNewTorrent = new JMenuItem("Create New Torrent");
		mnFile.add(mntmCreateNewTorrent);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAboutJtorrent = new JMenuItem("About j-torrent");
		mnHelp.add(mntmAboutJtorrent);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("j-torrent FAQ");
		mnHelp.add(mntmNewMenuItem);
		
		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		mntmAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutDialog(null);
			}
		});
		mnHelp.add(mntmAboutUs);
	}
	public static void updateToolBarStatus(int STATUSOFBUTTONS){
		switch(STATUSOFBUTTONS){
		case Downloader.DOWNLOADING:
			resumeTorrent.setEnabled(false);
			pauseTorrent.setEnabled(true);
			stopTorrent.setEnabled(true);
			break;
		case Downloader.PAUSED:
			resumeTorrent.setEnabled(true);
			pauseTorrent.setEnabled(false);
			stopTorrent.setEnabled(true);
			break;
		case Downloader.ERROR:
			resumeTorrent.setEnabled(true);
			pauseTorrent.setEnabled(false);
			stopTorrent.setEnabled(true);
			break;
		default://Assume completed or cancelled
			resumeTorrent.setEnabled(false);
			pauseTorrent.setEnabled(false);
			stopTorrent.setEnabled(false);
		}
	}
}
