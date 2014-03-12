package com.ecorecycle.control;

//Pass control to RecycleMonitorService
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.ecorecycle.gui.ItemView;
import com.ecorecycle.gui.RcmView;
import com.ecorecycle.gui.RmosView;
import com.ecorecycle.gui.viewmodels.RmosViewModel;

public class RmosController{
	private RmosView _view;
	private RmosViewModel _viewModel;
	public RmosController(RmosView rmosView){
		this._view = rmosView;
		this._viewModel = _view.getRmosViewModel();
	}
	
	
	public void login(){
		_view.createLoginPanel();
		if(_viewModel.getOptionSelected() == 0){
	        if (_viewModel.getUsername().equals("admin") && _viewModel.getPassword().equals("pass")) {
	        	control();
		    }
		    else {
		       _view.createFailureEvent();
		    }
		}
	}
	
	public void control() {
		_view.createGUI();
		_view.getAddItemButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ItemView itemView = new ItemView("Add Item");
				ItemController itemController = new ItemController(itemView);
				itemController.controlAddItem();
			}
		});
		
		_view.getUpdateItemButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ItemView itemView = new ItemView("Update Item");
				ItemController itemController = new ItemController(itemView);
				itemController.controlUpdateItem();
			}
		});
		
		_view.getAddRCMButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RcmView rcmView = new RcmView("Add RCM");
				RcmController rcmController = new RcmController(rcmView);
				rcmController.controlAddRCM();
			}
		});
		
		_view.getDeleteRCMButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RcmView rcmView = new RcmView("Delete RCM");
				RcmController rcmController = new RcmController(rcmView);
				rcmController.controlDeleteRCM();
			}
		});
		
		_view.getUpdateRCMButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RcmView rcmView = new RcmView("Update RCM");
				RcmController rcmController = new RcmController(rcmView);
				rcmController.controlUpdateRCM();
			}
		});
		
	}
	
	
	
	
	public static void main(String[] args){
		 			
	SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
			RmosController rmosCntrl = new RmosController(new RmosView("Recycle Monitor System")); 
			rmosCntrl.login();
		}
	});
}
}


