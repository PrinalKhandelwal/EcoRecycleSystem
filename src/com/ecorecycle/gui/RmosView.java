package com.ecorecycle.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ecorecycle.gui.viewmodels.RmosViewModel;


public class RmosView {
	
	private JFrame frame;
	private JPanel panel;
	private JButton addItemButton, addRCMButton, deleteRCMButton, updateRCMButton,updateItemButton;
	
	private JTextField usernameField = new JTextField(10);
	private JPasswordField passwordField = new JPasswordField(10);
	private RmosViewModel rmosViewModel = new RmosViewModel();
	
	private String name;
	
	public RmosView(String name){
		this.name = name;
	}
	
	
	public void createLoginPanel() {
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new GridLayout(2, 2, 5, 5));
		JLabel nameLabel = new JLabel("Username:: ");
		loginPanel.add(nameLabel);
		loginPanel.add(usernameField);
		JLabel passwordLabel = new JLabel("Password:: ");
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordField);
		int response = JOptionPane.showConfirmDialog(null, loginPanel, "Recycle Monitoring System", 
              JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
     
	     if (response == JOptionPane.OK_OPTION) {
	    	rmosViewModel.setUsername(usernameField.getText());
	        rmosViewModel.setPassword(new String(passwordField.getPassword()));

	     }
	     rmosViewModel.setOptionSelected(response);
	}
	
	public void createGUI() {
		createJFrame(name);		
		 JMenuBar menubar = new JMenuBar();
	     JMenuItem home = new JMenuItem("HELP");
	     JMenuItem logout = new JMenuItem("LOGOUT");
	     menubar.add(home);
	     menubar.add(logout);
	     menubar.add(Box.createHorizontalGlue());
	     logout.setToolTipText("Exit application");
	     logout.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent event) {
	             System.exit(0);
	         }
	     });
	  
	     
	    frame.setJMenuBar(menubar);
		
		createPanel();
		frame.add(panel);
		
		addItemButton = createButton("Add Item");
		updateItemButton = createButton("Update Item");
		addRCMButton = createButton("Add RCM");
		updateRCMButton = createButton("Update RCM");
		deleteRCMButton = createButton("Delete RCM");

		panel.add(addItemButton);
		panel.add(updateItemButton);
		panel.add(addRCMButton);
		panel.add(updateRCMButton);
		panel.add(deleteRCMButton);


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


	public RmosViewModel getRmosViewModel() {
		return rmosViewModel;
	}


	public void setRmosViewModel(RmosViewModel rmosViewModel) {
		this.rmosViewModel = rmosViewModel;
	}
	
	public void createFailureEvent(){
		String msg = "Incorrect name and password. ";
	    JOptionPane.showMessageDialog(null, msg);
	}
	
}
