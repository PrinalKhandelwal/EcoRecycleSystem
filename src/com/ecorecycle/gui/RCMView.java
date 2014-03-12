package com.ecorecycle.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

	public class RCMView {
		private JComboBox updateComboBox = new JComboBox();
		JTextField groupId = new JTextField(10);
		JTextField opStatus = new JTextField(10);
		JTextField location = new JTextField(10);
		JTextField maxCapacity = new JTextField(10);
		JTextField cashAmount = new JTextField(10);
		
		private String title;
		private RCMViewModel viewModel = new RCMViewModel();
		
		public RCMView(String text){
			this.title = text;
		}

		public void createAddRCMGUI() {
			JPanel popupPanel = new JPanel(new GridLayout(0,1)); 
			popupPanel.add(new JLabel("groupId::")); 
		    popupPanel.add(groupId);
		    popupPanel.add(new JLabel("opStatus::")); 
		    popupPanel.add(opStatus);
	        popupPanel.add(new JLabel("maxCapacity ::")); 
	        popupPanel.add(maxCapacity);
	        popupPanel.add(new JLabel("cashAmount ::")); 
	        popupPanel.add(cashAmount);
	        popupPanel.add(new JLabel("location ::")); 
	        popupPanel.add(location);
	        Object[] options = {"Cancel", "Submit"};
	        int optionSelected = JOptionPane.showOptionDialog(null, popupPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	        if(optionSelected == 1){
	        viewModel.setGroupId(Integer.parseInt(groupId.getText()));
	        viewModel.setOpStatus(Integer.parseInt(opStatus.getText()));
	        viewModel.setMaxCapacity(maxCapacity.getText());
	        viewModel.setCashDefaultAmount(cashAmount.getText());
	        viewModel.setLocation(location.getText());
	        }
	        viewModel.setOptionSelected(optionSelected);
		}

		public void createDeleteRCMGUI() {
			JPanel popupPanel = new JPanel(new GridLayout(0,1)); 
			popupPanel.add(new JLabel("MachineId::Location")); 
			popupPanel.add(updateComboBox);
			RCMViewModel rcm = (RCMViewModel)updateComboBox.getSelectedItem();
			setdeleteFields(rcm);
	        Object[] options = {"Cancel", "Submit"};
	        int optionSelected = JOptionPane.showOptionDialog(null, popupPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	        if(optionSelected == 1){
	        	viewModel.setLocation(((RCMViewModel)updateComboBox.getSelectedItem()).getLocation());
	        }
	        viewModel.setOptionSelected(optionSelected);
		}
		
		public void createUpdateRCMGUI() {
			JPanel popupPanel = new JPanel(new GridLayout(0,1)); 
			popupPanel.add(new JLabel("MachineId::Location")); 
			popupPanel.add(updateComboBox);
			RCMViewModel rcm = (RCMViewModel)updateComboBox.getSelectedItem();
			setAllFields(rcm);
	        popupPanel.add(new JLabel("Operational Status ::")); 
	        popupPanel.add(opStatus);
	       
	        Object[] options = {"Cancel", "Submit"};
	        int optionSelected = JOptionPane.showOptionDialog(null, popupPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	        if(optionSelected == 1){
	        	viewModel.setLocation(((RCMViewModel)updateComboBox.getSelectedItem()).getLocation());
		        viewModel.setOpStatus(Integer.parseInt(opStatus.getText()));
	        }
	        viewModel.setOptionSelected(optionSelected);
		}
		
		
		public void createSearchItemRCMGUI(){
			JPanel popupPanel = new JPanel(new GridLayout(0,1)); 
			popupPanel.add(new JLabel("MachineId::Location")); 
			popupPanel.add(updateComboBox);
			RCMViewModel rcm = (RCMViewModel)updateComboBox.getSelectedItem();
			setAllFields(rcm);
	
			popupPanel.add(new JLabel("groupId::")); 
		    popupPanel.add(groupId);
		    groupId.setEditable(false);
		    popupPanel.add(new JLabel("opStatus::")); 
		    popupPanel.add(opStatus);
		    opStatus.setEditable(false);
	        popupPanel.add(new JLabel("maxCapacity ::")); 
	        popupPanel.add(maxCapacity);
	        maxCapacity.setEditable(false);
	        popupPanel.add(new JLabel("cashAmount ::")); 
	        popupPanel.add(cashAmount);
	        cashAmount.setEditable(false);
	        Object[] options = {"Cancel", "OK"};
	        int optionSelected = JOptionPane.showOptionDialog(null, popupPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	        if(optionSelected == 1){
	        viewModel.setGroupId(Integer.parseInt(groupId.getText()));
	        viewModel.setOpStatus(Integer.parseInt(opStatus.getText()));
	        viewModel.setMaxCapacity(maxCapacity.getText());
	        viewModel.setCashDefaultAmount(cashAmount.getText());
	        viewModel.setLocation(location.getText());
	        }
	        viewModel.setOptionSelected(optionSelected);
		}
		
	 
        public void setAllFields(RCMViewModel rcm) {
       
        	groupId.setText(Integer.toString(rcm.getGroupId()));
			opStatus.setText(Integer.toString(rcm.getOpStatus()));
        	maxCapacity.setText(rcm.getMaxCapacity());
        	cashAmount.setText(rcm.getCashDefaultAmount());
			
		}
		
        
		public RCMViewModel getViewModel() {
			return viewModel;
		}

		public void createSuccessEvent(){
			JOptionPane.showMessageDialog(null, "Successfully added/updated/deleted an RCM", "Add/Update RCM Success", JOptionPane.DEFAULT_OPTION);
		}
		
		public void createFailureEvent(){
			JOptionPane.showMessageDialog(null, "Failure in adding/updating/deleted an RCM", "Add/Update RCM Failure", JOptionPane.ERROR_MESSAGE);
		}
		public JComboBox getUpdateComboBox() {
			return updateComboBox;
		}

		public void setUpdateFields(RCMViewModel rcm) {
			location.setText(rcm.getLocation());
			opStatus.setText(Integer.toString(rcm.getOpStatus()));
		}		
		
		public void setdeleteFields(RCMViewModel rcm) {
			location.setText(rcm.getLocation());
			groupId.setText(Integer.toString(rcm.getGroupId()));

		}	
	}

	
