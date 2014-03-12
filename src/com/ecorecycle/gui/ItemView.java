package com.ecorecycle.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ecorecycle.gui.viewmodels.ItemViewModel;

public class ItemView {
	
	private JComboBox updateComboBox = new JComboBox();
	private JTextField id = new JTextField(10);
	private JTextField name = new JTextField(10);
	private JTextField price = new JTextField(10);
	private JTextField weight = new JTextField(10);
	private JTextField type = new JTextField(10);
	
	private String title;
	private ItemViewModel viewModel = new ItemViewModel();
	
	private JCheckBox itemName;
	
	public ItemView(){
		
	}
	
	public ItemView(String text){
		this.title = text;
	}

	public void createAddItemGUI() {
		JPanel popupPanel = new JPanel(new GridLayout(0,1)); 
		popupPanel.add(new JLabel("Item Name ::")); 
	    popupPanel.add(name);
	    popupPanel.add(new JLabel("Price ::")); 
	    popupPanel.add(price);
        popupPanel.add(new JLabel("Weight ::")); 
        popupPanel.add(weight);
        popupPanel.add(new JLabel("Type ::")); 
        popupPanel.add(type);
        Object[] options = {"Cancel", "Submit"};
        int optionSelected = JOptionPane.showOptionDialog(null, popupPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if(optionSelected == 1){
	        viewModel.setItemName(name.getText());
	        viewModel.setPrice(Double.parseDouble(price.getText()));
	        viewModel.setWeight(Double.parseDouble(weight.getText()));
	        viewModel.setType(type.getText());
        }
        viewModel.setOptionSelected(optionSelected);
	}

	public void createUpdateItemGUI() {
		JPanel popupPanel = new JPanel(new GridLayout(0,1)); 
		popupPanel.add(new JLabel("Item Names ::")); 
		popupPanel.add(updateComboBox);
		ItemViewModel item = (ItemViewModel)updateComboBox.getSelectedItem();
		setUpdateFields(item);
		popupPanel.add(new JLabel("Name ::")); 
	    popupPanel.add(name);
	    popupPanel.add(new JLabel("Price ::")); 
	    popupPanel.add(price);
        popupPanel.add(new JLabel("Weight ::")); 
        popupPanel.add(weight);
        popupPanel.add(new JLabel("Type ::")); 
        popupPanel.add(type);
       
        Object[] options = {"Cancel", "Submit"};
        int optionSelected = JOptionPane.showOptionDialog(null, popupPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if(optionSelected == 1){
        	viewModel.setItemId(((ItemViewModel)updateComboBox.getSelectedItem()).getItemId());
	        viewModel.setItemName(name.getText());
        	viewModel.setPrice(Double.parseDouble(price.getText()));
	        viewModel.setWeight(Double.parseDouble(weight.getText()));
	        viewModel.setType(type.getText());
        }
        viewModel.setOptionSelected(optionSelected);
	}

	
	public void createItemRCM(){
	
		JPanel popupPanel = new JPanel(new GridLayout(0,1)); 
		
		popupPanel.add(new JLabel("Item Id ::")); 
	    popupPanel.add(id);
	    id.setEditable(false);
		popupPanel.add(new JLabel("Item Names ::")); 
		popupPanel.add(updateComboBox);
		ItemViewModel item = (ItemViewModel)updateComboBox.getSelectedItem();
		setUpdateFields(item);
		
	    popupPanel.add(new JLabel("Price ::")); 
	    popupPanel.add(price);
	    price.setEditable(false);
        popupPanel.add(new JLabel("Weight ::")); 
        popupPanel.add(weight);
        weight.setEditable(false);
        popupPanel.add(new JLabel("Type ::")); 
        popupPanel.add(type);
        type.setEditable(false);
        Object[] options = {"Cancel", "OK"};
        int optionSelected = JOptionPane.showOptionDialog(null, popupPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if(optionSelected == 1){
        	viewModel.setItemId(Integer.parseInt(id.getText()));
	        viewModel.setItemName(((ItemViewModel)updateComboBox.getSelectedItem()).getItemName());
        	viewModel.setPrice(Double.parseDouble(price.getText()));
	        viewModel.setWeight(Double.parseDouble(weight.getText()));
	        viewModel.setType(type.getText());
        }
        viewModel.setOptionSelected(optionSelected);
	}

	public void createSearchAllItemGUI() {
		JPanel popupPanel = new JPanel(new GridLayout(0,1)); 
		popupPanel.add(new JLabel("Item Names ::")); 
		popupPanel.add(updateComboBox);
		ItemViewModel item = (ItemViewModel)updateComboBox.getSelectedItem();
		setUpdateFields(item);
		popupPanel.add(new JLabel("Name ::")); 
	    popupPanel.add(name);
	    name.setEditable(false);
	    popupPanel.add(new JLabel("Price ::")); 
	    popupPanel.add(price);
	    price.setEditable(false);
        popupPanel.add(new JLabel("Weight ::")); 
        popupPanel.add(weight);
        weight.setEditable(false);
        popupPanel.add(new JLabel("Type ::")); 
        popupPanel.add(type);
        type.setEditable(false);
       
        Object[] options = {"Cancel", "Submit"};
        int optionSelected = JOptionPane.showOptionDialog(null, popupPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if(optionSelected == 1){
        	viewModel.setItemId(((ItemViewModel)updateComboBox.getSelectedItem()).getItemId());
	        viewModel.setItemName(name.getText());
        	viewModel.setPrice(Double.parseDouble(price.getText()));
	        viewModel.setWeight(Double.parseDouble(weight.getText()));
	        viewModel.setType(type.getText());
        }
        viewModel.setOptionSelected(optionSelected);
	}

	
	public ItemViewModel getViewModel() {
		return viewModel;
	}

	public void createSuccessEvent(){
		JOptionPane.showMessageDialog(null, "Successfully added/updated an item", "Add/Update Item Success", JOptionPane.DEFAULT_OPTION);
	}
	
	public void createFailureEvent(){
		JOptionPane.showMessageDialog(null, "Failure in adding/updating an item", "Add/Update Item Failure", JOptionPane.ERROR_MESSAGE);
	}

	public JComboBox getUpdateComboBox() {
		return updateComboBox;
	}

	

	public void setUpdateFields(ItemViewModel item) {
		name.setText(item.getItemName());
		price.setText(Double.toString(item.getPrice()));
		weight.setText(Double.toString(item.getWeight()));
		type.setText(item.getType());
		
	}
	
	

	
}

	
