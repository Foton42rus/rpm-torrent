package com.jbittorrent.client.mainGui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class TreeClass extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TreeClass() throws HeadlessException {
		initializeUI();
	}

	private void initializeUI() {
		setSize(300, 500);
		setVisible(true);
		DefaultMutableTreeNode root1 = new DefaultMutableTreeNode(new TreeData("Torrents","top.png"));
		TreeData[] countries1 = new TreeData[] {
				new TreeData("Downloading", "Downloading.png"),
				new TreeData("Completed", "completed.png"),
				new TreeData("Active", "Active.png"),
				new TreeData("Inactive", "inactive.png"), };
		for (TreeData country : countries1) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(country);
			root1.add(node);
		}
		final JTree tree1 = new JTree(root1);
		tree1.setRowHeight(35);
		tree1.setCellRenderer(new CountryTreeCellRenderer());

		JScrollPane panew = new JScrollPane(tree1);
		panew.setPreferredSize(new Dimension(300, 400));

		setLayout(new BorderLayout());
		add(panew, BorderLayout.CENTER);

	}
}

class CountryTreeCellRenderer implements TreeCellRenderer {
	private JLabel label;

	CountryTreeCellRenderer() {
		label = new JLabel();
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		Object ow = ((DefaultMutableTreeNode) value).getUserObject();
		if (ow instanceof TreeData) {
			TreeData data = (TreeData) ow;
			String path="/treeImage/"+data.getImageIcon();
			label.setIcon(new ImageIcon(MainGui.class.getResource(path)));
//			label.setIcon(new ImageIcon(countryw.getImageIcon()));
			label.setText(data.getName());
		} else {
			label.setIcon(null);
			label.setText("" + value);
		}
		return label;
	}
}

class TreeData {
	private String name;
	private String ImageIcon;

	TreeData(String name, String ImageIcon) {
		this.name = name;
		this.ImageIcon = ImageIcon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageIcon() {
		return ImageIcon;
	}

	public void setImageIcon(String ImageIcon) {
		this.ImageIcon = ImageIcon;
	}
}