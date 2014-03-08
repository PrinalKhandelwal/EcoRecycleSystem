package com.ecorecycle.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RmosMainMenu {
	
	private JFrame frame;
	private JPanel panel;
	private JButton addItemButton, addRCMButton;
	private JButton updateItemButton, SearchRCMButton;
	
	public RmosMainMenu(String name){
		createGUI(name);
	}

	private void createGUI(String name) {
		createJFrame(name);
		createPanel();
		frame.add(panel);
		addItemButton = createButton("Add an Item");
		updateItemButton = createButton("Update an Item");
		addRCMButton = createButton("Add an RCM");
		
		panel.add(addItemButton);
		panel.add(updateItemButton);
		panel.add(addRCMButton);
		frame.pack();
		frame.setVisible(true);
	}
	
	private JButton createButton(String text){
		JButton button = new JButton(text);
		button.setSize(new Dimension(25,25));
		return button;
	}
	
	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(new FlowLayout(5,10,10));
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
}
