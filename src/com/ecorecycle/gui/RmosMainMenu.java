package com.ecorecycle.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;


public class RmosMainMenu {
	
	private JFrame frame;
	private JPanel panel;
	private JButton addItemButton, addRCMButton, deleteRCMButton, updateRCMButton;
	private JButton updateItemButton, itemRCMButton;
	
	public RmosMainMenu(String name){
	
		createGUI(name);
	}

	public void createGUI(String name) {
		createJFrame(name);		
		 JMenuBar menubar = new JMenuBar();
	     JMenu home = new JMenu("HELP");
	     JMenu logout = new JMenu("LOGOUT");
	     logout.setToolTipText("Exit application");
	     logout.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent event) {
	             System.exit(0);
	         }
	     });
	  
	     menubar.add(Box.createHorizontalGlue());
	     menubar.add(home);
	     menubar.add(logout);
	     
	     frame.setJMenuBar(menubar);
		
		createPanel();
		frame.add(panel);
		
		addItemButton = createButton("Add an Item");
		updateItemButton = createButton("Update an Item");
		addRCMButton = createButton("Add an RCM");
		updateRCMButton = createButton("Update an RCM");
		deleteRCMButton = createButton("Delete an RCM");
		itemRCMButton = createButton("Map Machine-Item");

		panel.add(addItemButton);
		panel.add(updateItemButton);
		panel.add(addRCMButton);
		panel.add(updateRCMButton);
		panel.add(deleteRCMButton);
		panel.add(itemRCMButton);


		frame.pack();
		frame.setVisible(true);
	}
	
	
	private JButton createButton(String text){
		JButton button = new JButton(text);
		button.setSize(new Dimension(30,25));
		return button;
	}
	
	private void createPanel() {
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(5,10,10));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(Box.createRigidArea(new Dimension(0,30)));
	
			  }


	private void createJFrame(String name) {
		frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(name);
		frame.setMinimumSize(new Dimension(700, 700)); 
		frame.setLocationRelativeTo(null);
	}

	public JButton getAddItemButton() {
		return addItemButton;
	}


	public JButton getUpdateItemButton() {
		return updateItemButton;
	}

	public JButton getAddRCMButton() {
		return addRCMButton;
	}
	
	public JButton getDeleteRCMButton() {
		return deleteRCMButton;
	}
	public JButton getUpdateRCMButton() {
		return updateRCMButton;
	}
	public JButton getItemRCMButton() {
		return itemRCMButton;
	}
	
//	public JButton getSearchItemRCMButton() {
//		return searchItemRCMButton;
//	}
}
