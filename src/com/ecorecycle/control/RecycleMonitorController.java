package com.ecorecycle.control;

//Pass control to RecycleMonitorService
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ecorecycle.gui.ItemView;
import com.ecorecycle.gui.RCMView;
import com.ecorecycle.gui.RmosMainMenu;
import com.ecorecycle.gui.itemRCMView;

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
					RCMView rcmView = new RCMView("Add an RCM");
					RcmController rcmController = new RcmController(rcmView);
					rcmController.controlAddRCM();
				}
			});
			
			_view.getDeleteRCMButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					RCMView rcmView = new RCMView("Delete an RCM");
					RcmController rcmController = new RcmController(rcmView);
					rcmController.controlDeleteRCM();
				}
			});
			
			_view.getUpdateRCMButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					RCMView rcmView = new RCMView("Update an RCM");
					RcmController rcmController = new RcmController(rcmView);
					rcmController.createUpdateRCMGUI();
				}
			});
			
			_view.getItemRCMButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					itemRCMView itemRcmView = new itemRCMView("Map Machine-Item");
				//	ItemRcmController itemRcmController = new ItemRcmController(itemRcmView, itemView);
					//itemRcmController.createSearchItemRCMGUI();
				}
			});
			
		}
	}


