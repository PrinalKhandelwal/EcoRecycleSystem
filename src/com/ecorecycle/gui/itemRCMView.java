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

		public class itemRCMView {
			
			private JComboBox updateComboBox = new JComboBox();
			private JCheckBox itemName;
	
			private String title;
			private ItemViewModel viewModel = new ItemViewModel();
			private RCMViewModel RviewModel = new RCMViewModel();
			
			public itemRCMView(String text){
				this.title = text;
			}

			
			public void createSearchItemRCMGUI(){
				JPanel popupPanel = new JPanel(new GridLayout(0,1)); 
				popupPanel.add(new JLabel("MachineId::Location")); 
				popupPanel.add(updateComboBox);
				RCMViewModel rcm = (RCMViewModel)updateComboBox.getSelectedItem();
		
				JPanel checkBoxPanel = new JPanel();
		        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.PAGE_AXIS));
		        checkBoxPanel.add(Box.createRigidArea(new Dimension(10,0)));

		        itemName = new JCheckBox("Select Items");
		        itemName.setSelected(true);
		     
		        checkBoxPanel.add(itemName);
		      
		        Object[] options = {"Cancel", "OK"};
		        int optionSelected = JOptionPane.showOptionDialog(null, popupPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		        if(optionSelected == 1){
		        viewModel.setItemName(itemName.getText());
		       
		        }
		        viewModel.setOptionSelected(optionSelected);
			}
			
	        
			public RCMViewModel getViewModel() {
				return RviewModel;
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

			
		}

		
