package com.ecorecycle.control;

//Pass control to RecycleMonitorService
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.ecorecycle.gui.ItemView;
import com.ecorecycle.gui.RmosMainMenu;

	public class RecycleMonitorController{
		
		private RmosMainMenu _view;
		
		public RecycleMonitorController(RmosMainMenu rmosView){
			this._view = rmosView;
		}
		
		
		public void control() {
			_view.getAddItemButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					ItemView itemView = new ItemView("Add an Item");
					ItemController itemController = new ItemController(itemView);
					itemController.controlAddItem();
				}
			});
			
			_view.getUpdateItemButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ItemView itemView = new ItemView("Update an Item");
					ItemController itemController = new ItemController(itemView);
					itemController.controlUpdateItem();
				}
			});
			
			
			_view.getAddRCMButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					ItemView itemView = new ItemView("Add an RCM");
//					itemView.createAddRCMGUI();
//					RecycleMonitorVO viewModel = itemView.getViewModel();
//					RcmController rcmController = new RcmController(itemView,viewModel);
//					if(rcmController.performAddRCMAction()){
//						itemView.createSuccessEvent();
//					}
//					else{
//						itemView.createFailureEvent();
//					}
				}
			});
		}
		
		public static void main(String[] args){
			
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					RmosMainMenu rmosView = new RmosMainMenu("Recycle Monitoring System");
					RecycleMonitorController rmosCntrl = new RecycleMonitorController(rmosView); 
					rmosCntrl.control();
				}
			});
		}
		
	}


