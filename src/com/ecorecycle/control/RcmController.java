package com.ecorecycle.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import com.ecorecycle.db.DAOException;
import com.ecorecycle.db.RecycleManagementDAO;
import com.ecorecycle.db.RecycleManagementDaoImpl;
import com.ecorecycle.gui.RCMView;
import com.ecorecycle.gui.RCMViewModel;
import com.ecorecycle.vo.RCMVO;

public class RcmController {
	
	private RecycleManagementDAO rcmDao = new RecycleManagementDaoImpl();
	private RCMView _view;
	private RCMViewModel _viewModel;
	
	public RcmController(RCMView _view){
		this._view = _view;
		this._viewModel = _view.getViewModel();
	}

	public void controlAddRCM(){
		_view.createAddRCMGUI();
		
		int retValue = performAddRCMAction();
		if(retValue == 1){
			_view.createSuccessEvent();
		}
		else if(retValue == -1){
			_view.createFailureEvent();
		}
	}
	
	
	public int performAddRCMAction() {
		if(_viewModel.getOptionSelected() == 1){
			RCMVO rcmVO = new RCMVO();
			rcmVO.setGroupId(_viewModel.getGroupId());
			rcmVO.setOpStatus(_viewModel.getOpStatus());
			rcmVO.setLocation(_viewModel.getLocation());
			rcmVO.setMaxCapacity(_viewModel.getMaxCapacity());
			rcmVO.setCashDefaultAmount(_viewModel.getCashDefaultAmount());
			rcmVO.setMaxCapacity(_viewModel.getMaxCapacity());
			try {
				rcmDao.insertRCM(rcmVO);
			} catch (DAOException e) {
				System.out.println("Unable to add an RCM");
				return -1;
			}
			return 1;
		}
		return 0;
	}

	
	public void controlDeleteRCM(){
		try {
			List<RCMVO> rcmVOs = rcmDao.getAllRCM();
			for(int i=0; i<rcmVOs.size(); i++){
				RCMViewModel viewModel = new RCMViewModel();
				viewModel.setMachineId(rcmVOs.get(i).getMachineId());
				viewModel.setGroupId(rcmVOs.get(i).getGroupId());
				viewModel.setLocation(rcmVOs.get(i).getLocation());
				viewModel.setOpStatus(rcmVOs.get(i).getOpStatus());
				viewModel.setCashDefaultAmount(rcmVOs.get(i).getCashDefaultAmount());
				viewModel.setMaxCapacity(rcmVOs.get(i).getMaxCapacity());
				viewModel.setTime_last_activated(rcmVOs.get(i).getTime_last_activated());
				viewModel.setCashDefaultAmount(rcmVOs.get(i).getCashDefaultAmount());
				_view.getUpdateComboBox().addItem(viewModel);
			}
			
			_view.getUpdateComboBox().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox cb = (JComboBox)e.getSource();
					RCMViewModel rcmModel = (RCMViewModel) cb.getSelectedItem();
					_view.setUpdateFields(rcmModel);
					
				}
			});
			_view.createDeleteRCMGUI();
			
			int retValue = performDeleteRCMAction();
			if(retValue == 1){
				_view.createSuccessEvent();
			}
			else if(retValue == -1){
				_view.createFailureEvent();
			}
		} 
		catch (DAOException e) {
			e.printStackTrace();
			_view.createFailureEvent();
		}
	}
	
	public int performDeleteRCMAction() {
		if(_viewModel.getOptionSelected() == 1){
			RCMVO rcmVO = new RCMVO();
			rcmVO.setGroupId(_viewModel.getGroupId());
			rcmVO.setLocation(_viewModel.getLocation());
			try {
				rcmDao.deleteRCM(rcmVO);
			} catch (DAOException e) {
				System.out.println("Unable to delete an RCM");
				return -1;
			}
			return 1;
		}
		return 0;
	}
	
	
	public void createUpdateRCMGUI(){
		try {
			List<RCMVO> rcmVOs = rcmDao.getAllRCM();
			for(int i=0; i<rcmVOs.size(); i++){
				RCMViewModel viewModel = new RCMViewModel();
				viewModel.setMachineId(rcmVOs.get(i).getMachineId());
				viewModel.setGroupId(rcmVOs.get(i).getGroupId());
				viewModel.setLocation(rcmVOs.get(i).getLocation());
				viewModel.setOpStatus(rcmVOs.get(i).getOpStatus());
				viewModel.setCashDefaultAmount(rcmVOs.get(i).getCashDefaultAmount());
				viewModel.setMaxCapacity(rcmVOs.get(i).getMaxCapacity());
				viewModel.setTime_last_activated(rcmVOs.get(i).getTime_last_activated());
				viewModel.setCashDefaultAmount(rcmVOs.get(i).getCashDefaultAmount());
				_view.getUpdateComboBox().addItem(viewModel);
			}
			
			_view.getUpdateComboBox().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox cb = (JComboBox)e.getSource();
					RCMViewModel rcmModel = (RCMViewModel) cb.getSelectedItem();
					_view.setUpdateFields(rcmModel);
					
				}
			});
			_view.createUpdateRCMGUI();
			
			int retValue = performUpdateRCMAction();
			if(retValue == 1){
				_view.createSuccessEvent();
			}
			else if(retValue == -1){
				_view.createFailureEvent();
			}
		} 
		catch (DAOException e) {
			e.printStackTrace();
			_view.createFailureEvent();
		}
	}
	
	public int performUpdateRCMAction() {
		if(_viewModel.getOptionSelected() == 1){
			RCMVO rcmVO = new RCMVO();
			rcmVO.setMachineId(_viewModel.getMachineId());
			rcmVO.setGroupId(_viewModel.getGroupId());
			rcmVO.setLocation(_viewModel.getLocation());
			rcmVO.setOpStatus(_viewModel.getOpStatus());
			rcmVO.setCashDefaultAmount(_viewModel.getCashDefaultAmount());
			rcmVO.setMaxCapacity(_viewModel.getMaxCapacity());
			rcmVO.setTime_last_activated(_viewModel.getTime_last_activated());
			rcmVO.setCashDefaultAmount(_viewModel.getCashDefaultAmount());
			try {
				rcmDao.updateRCM(rcmVO);
			} catch (DAOException e) {
				System.out.println("Unable to update an item");
				return -1;
			}
			return 1;
		}
		return 0;
	}
	
	public void createSearchItemRCMGUI(){
		try {
			List<RCMVO> rcmVOs = rcmDao.getAllRCM();
			for(int i=0; i<rcmVOs.size(); i++){
				RCMViewModel viewModel = new RCMViewModel();
				viewModel.setMachineId(rcmVOs.get(i).getMachineId());
				viewModel.setGroupId(rcmVOs.get(i).getGroupId());
				viewModel.setLocation(rcmVOs.get(i).getLocation());
				viewModel.setOpStatus(rcmVOs.get(i).getOpStatus());
				viewModel.setCashDefaultAmount(rcmVOs.get(i).getCashDefaultAmount());
				viewModel.setMaxCapacity(rcmVOs.get(i).getMaxCapacity());
				viewModel.setTime_last_activated(rcmVOs.get(i).getTime_last_activated());
				viewModel.setCashDefaultAmount(rcmVOs.get(i).getCashDefaultAmount());
				_view.getUpdateComboBox().addItem(viewModel);
			}
			
			_view.getUpdateComboBox().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox cb = (JComboBox)e.getSource();
					RCMViewModel rcmModel = (RCMViewModel) cb.getSelectedItem();
					_view.setUpdateFields(rcmModel);
					
				}
			});
			_view.createSearchItemRCMGUI();
			
			int retValue = performUpdateRCMAction();
			if(retValue == 1){
				_view.createSuccessEvent();
			}
			else if(retValue == -1){
				_view.createFailureEvent();
			}
		} 
		catch (DAOException e) {
			e.printStackTrace();
			_view.createFailureEvent();
		}
	}
	
}
