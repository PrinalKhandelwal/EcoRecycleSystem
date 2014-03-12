package com.ecorecycle.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ecorecycle.gui.viewmodels.RcmViewModel;

public class RcmView {
	private JComboBox updateComboBox = new JComboBox();
	JTextField opStatus = new JTextField(2);
	JTextField location = new JTextField(10);
	JTextField maxCapacity = new JTextField(5);
	JTextField cashAmount = new JTextField(5);
	List<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
	
	private String title;
	private RcmViewModel viewModel = new RcmViewModel();
	
	public RcmView(String text){
		this.title = text;
	}

	public void createAddRCMGUI() {
		JPanel popupPanel = new JPanel(new GridLayout(0,1)); 
		popupPanel.add(new JLabel("maxCapacity ::")); 
        popupPanel.add(maxCapacity);
        popupPanel.add(new JLabel("cashAmount ::")); 
        popupPanel.add(cashAmount);
        popupPanel.add(new JLabel("location ::")); 
        popupPanel.add(location);
        popupPanel.add(new JLabel("opStatus::")); 
	    popupPanel.add(opStatus);
	    
	    
        Object[] options = {"Cancel", "Submit"};
        int optionSelected = JOptionPane.showOptionDialog(null, popupPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if(optionSelected == 1){
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
		RcmViewModel rcm = (RcmViewModel)updateComboBox.getSelectedItem();
		setdeleteFields(rcm);
        Object[] options = {"Cancel", "Submit"};
        int optionSelected = JOptionPane.showOptionDialog(null, popupPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if(optionSelected == 1){
        	viewModel.setLocation(((RcmViewModel)updateComboBox.getSelectedItem()).getLocation());
        }
        viewModel.setOptionSelected(optionSelected);
	}
	
	public void createUpdateRCMGUI() {
		JPanel popupPanel = new JPanel(new GridLayout(0,1)); 
		popupPanel.add(new JLabel("MachineId::Location")); 
		popupPanel.add(updateComboBox);
		RcmViewModel rcm = (RcmViewModel)updateComboBox.getSelectedItem();
		setUpdateFields(rcm);
        popupPanel.add(new JLabel("Operational Status ::")); 
        popupPanel.add(opStatus);
       
        popupPanel.add(new JLabel("Configure Item Types ::"));
	    JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new GridLayout(0, 2));
        for(JCheckBox checkBox : checkBoxes){
        	checkBoxPanel.add(checkBox);
        }
        popupPanel.add(checkBoxPanel);
        
        Object[] options = {"Cancel", "Submit"};
        int optionSelected = JOptionPane.showOptionDialog(null, popupPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if(optionSelected == 1){
        	viewModel.setLocation(((RcmViewModel)updateComboBox.getSelectedItem()).getLocation());
	        viewModel.setOpStatus(Integer.parseInt(opStatus.getText()));
	        viewModel.setSelectedItems(new ArrayList<String>());
	        viewModel.setMachineId(((RcmViewModel)updateComboBox.getSelectedItem()).getMachineId());
	        for(JCheckBox checkBox : checkBoxes){
	        	if(checkBox.isSelected()){
	        		viewModel.getSelectedItems().add(checkBox.getText());
	        	}
	        }
        }
        viewModel.setOptionSelected(optionSelected);
	}
	
	
	public void createSearchItemRCMGUI(){
		JPanel popupPanel = new JPanel(new GridLayout(0,1)); 
		popupPanel.add(new JLabel("MachineId::Location")); 
		popupPanel.add(updateComboBox);
		RcmViewModel rcm = (RcmViewModel)updateComboBox.getSelectedItem();
		setAllFields(rcm);

		popupPanel.add(new JLabel("groupId::")); 
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
        viewModel.setOpStatus(Integer.parseInt(opStatus.getText()));
        viewModel.setMaxCapacity(maxCapacity.getText());
        viewModel.setCashDefaultAmount(cashAmount.getText());
        viewModel.setLocation(location.getText());
        }
        viewModel.setOptionSelected(optionSelected);
	}
	
	
	public JCheckBox createCheckBox(String type,boolean selected) {
		return new JCheckBox(type,selected);
	}
 
    public void setAllFields(RcmViewModel rcm) {
    	
		opStatus.setText(Integer.toString(rcm.getOpStatus()));
    	maxCapacity.setText(rcm.getMaxCapacity());
    	cashAmount.setText(rcm.getCashDefaultAmount());
		
	}
	
    
	public RcmViewModel getViewModel() {
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

	public void setUpdateFields(RcmViewModel rcm) {
		location.setText(rcm.getLocation());
		opStatus.setText(Integer.toString(rcm.getOpStatus()));
		for(JCheckBox checkBox : getCheckBoxes()){
			if(rcm.getSelectedItems().contains(checkBox.getText())){
				checkBox.setSelected(true);
			}
		}
	}		
	
	public void unselectAllCheckBoxes(){
		for(JCheckBox checkBox : getCheckBoxes()){
				checkBox.setSelected(false);
		}
	}
	
	public void setdeleteFields(RcmViewModel rcm) {
		location.setText(rcm.getLocation());
	}

	public List<JCheckBox> getCheckBoxes() {
		return checkBoxes;
	}

	public void setCheckBoxes(List<JCheckBox> checkBoxes) {
		this.checkBoxes = checkBoxes;
	}

	
	
	
}

	
