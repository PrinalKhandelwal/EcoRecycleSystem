package com.ecorecycle.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import com.ecorecycle.db.DAOException;
import com.ecorecycle.db.RecycleManagementDAO;
import com.ecorecycle.db.RecycleManagementDaoImpl;
import com.ecorecycle.gui.RcmView;
import com.ecorecycle.gui.viewmodels.RcmViewModel;
import com.ecorecycle.vo.ItemVO;
import com.ecorecycle.vo.RcmVO;

public class RcmController {
	
	private RecycleManagementDAO rcmDao = new RecycleManagementDaoImpl();
	private RcmView _view;
	private RcmViewModel _viewModel;
	
	public RcmController(RcmView _view){
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
			RcmVO rcmVO = new RcmVO();
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
			List<RcmVO> rcmVOs = rcmDao.getAllRCM();
			for(int i=0; i<rcmVOs.size(); i++){
				RcmViewModel viewModel = new RcmViewModel();
				viewModel.setMachineId(rcmVOs.get(i).getMachineId());
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
					RcmViewModel rcmModel = (RcmViewModel) cb.getSelectedItem();
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
			RcmVO rcmVO = new RcmVO();
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
	
	
	public void controlUpdateRCM(){
		try {
			List<RcmVO> rcmVOs = rcmDao.getAllRCM();
			for(int i=0; i<rcmVOs.size(); i++){
				RcmViewModel viewModel = new RcmViewModel();
				viewModel.setMachineId(rcmVOs.get(i).getMachineId());
				viewModel.setLocation(rcmVOs.get(i).getLocation());
				viewModel.setOpStatus(rcmVOs.get(i).getOpStatus());
				viewModel.setCashDefaultAmount(rcmVOs.get(i).getCashDefaultAmount());
				viewModel.setMaxCapacity(rcmVOs.get(i).getMaxCapacity());
				viewModel.setTime_last_activated(rcmVOs.get(i).getTime_last_activated());
				viewModel.setCashDefaultAmount(rcmVOs.get(i).getCashDefaultAmount());
				
				List<ItemVO> mappedItemVOs = rcmDao.getMappedItems(rcmVOs.get(i).getMachineId());
				List<String> mappedItemTypes = new ArrayList<String>();
				if(mappedItemVOs != null){
					for(ItemVO itemVO : mappedItemVOs){
						mappedItemTypes.add(itemVO.getType());
					}
				}
				viewModel.setSelectedItems(mappedItemTypes);
				_view.getUpdateComboBox().addItem(viewModel);
			}
			
			configureCheckBoxesForAllItemTypes();
			
			_view.getUpdateComboBox().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox cb = (JComboBox)e.getSource();
					RcmViewModel rcmModel = (RcmViewModel) cb.getSelectedItem();
					
					_view.unselectAllCheckBoxes();
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
	
	
	private void configureCheckBoxesForAllItemTypes() throws DAOException {
		List<String> itemTypes = new ArrayList<String>();
		List<ItemVO> allItemVOs;
		allItemVOs = rcmDao.getAllItems();

		for(ItemVO itemVO : allItemVOs){
			itemTypes.add(itemVO.getType());
		}
		_view.setCheckBoxes(new ArrayList<JCheckBox>());
		for(String itemType :itemTypes){
			_view.getCheckBoxes().add(_view.createCheckBox(itemType,false));
		}
	}
	
	public int performUpdateRCMAction() {
		if(_viewModel.getOptionSelected() == 1){
			RcmVO rcmVO = new RcmVO();
			rcmVO.setMachineId(_viewModel.getMachineId());
			rcmVO.setLocation(_viewModel.getLocation());
			rcmVO.setOpStatus(_viewModel.getOpStatus());
			rcmVO.setCashDefaultAmount(_viewModel.getCashDefaultAmount());
			rcmVO.setMaxCapacity(_viewModel.getMaxCapacity());
			rcmVO.setTime_last_activated(_viewModel.getTime_last_activated());
			rcmVO.setCashDefaultAmount(_viewModel.getCashDefaultAmount());
			try {
				rcmDao.updateRCM(rcmVO);
				
				List<ItemVO> itemVOs = new ArrayList<ItemVO>();
				for(String itemSelected : _viewModel.getSelectedItems()){
					itemVOs.add(rcmDao.getItem(itemSelected));
				}
				rcmDao.upsertMappedItem(_viewModel.getMachineId(), itemVOs);
				
			} catch (DAOException e) {
				System.out.println("Unable to update an item");
				return -1;
			}
			return 1;
		}
		return 0;
	}
	

	
}
