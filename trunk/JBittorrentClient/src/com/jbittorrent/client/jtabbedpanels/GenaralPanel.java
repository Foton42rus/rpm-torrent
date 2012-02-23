package com.jbittorrent.client.jtabbedpanels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class GenaralPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public GenaralPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblWeAreTestng = new JLabel("We are testng this tabbed panel <br/>\r\n<br/>");
		add(lblWeAreTestng);
	
		
	}

}
