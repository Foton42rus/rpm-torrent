package com.jbittorrent.client.mainGui;
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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGui {

	private JFrame frmJtorrent;
	private JTable table;

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
		frmJtorrent.setBounds(100, 100, 976, 767);
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
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBorderPainted(false);
		toolBar.setBackground(new Color(230, 230, 250));
		toolBar.setFloatable(false);
		centerRegion.add(toolBar,BorderLayout.NORTH);
		
		JPanel lowerRegion = new JPanel();
		lowerRegion.setBorder(new LineBorder(SystemColor.activeCaption));
		
		JButton addTorFile = new JButton("");
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
		newTorrent.setBackground(new Color(230, 230, 250));
		newTorrent.setIcon(new ImageIcon(MainGui.class.getResource("/images/toolbarimage/new_torr.png")));
		toolBar.add(newTorrent);
		toolBar.addSeparator();
		
		JButton torrentStart = new JButton("");
		torrentStart.setBackground(new Color(230, 230, 250));
		torrentStart.setIcon(new ImageIcon(MainGui.class.getResource("/images/toolbarimage/start.png")));
		toolBar.add(torrentStart);
		
		JButton pauseTorrent = new JButton("");
		pauseTorrent.setIcon(new ImageIcon(MainGui.class.getResource("/images/toolbarimage/pause.png")));
		pauseTorrent.setBackground(new Color(230, 230, 250));
		toolBar.add(pauseTorrent);
		
		JButton stopTorrent = new JButton("");
		stopTorrent.setBackground(new Color(230, 230, 250));
		stopTorrent.setIcon(new ImageIcon(MainGui.class.getResource("/images/toolbarimage/stop.png")));
		toolBar.add(stopTorrent);
		toolBar.addSeparator();
		
		JButton settings = new JButton("");
		settings.setIcon(new ImageIcon(MainGui.class.getResource("/images/toolbarimage/settings.png")));
		settings.setBackground(new Color(230, 230, 250));
		toolBar.add(settings);
		
		table = new JTable();
		centerRegion.add(table, BorderLayout.CENTER);
		lowerRegion.setBackground(new Color(255, 255, 255));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		//ch
		tabbedPane.setSize(lowerRegion.getSize());
		GenaralPanel gp=new GenaralPanel();
		gp.setPreferredSize(new Dimension(944, 76));
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
		mnFile.add(mntmAddNewTorrent);
		
		JMenuItem mntmCreateNewTorrent = new JMenuItem("Create New Torrent");
		mnFile.add(mntmCreateNewTorrent);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
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
}
