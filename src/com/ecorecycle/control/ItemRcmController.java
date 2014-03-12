package com.ecorecycle.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

import com.ecorecycle.db.DAOException;
import com.ecorecycle.db.RecycleManagementDAO;
import com.ecorecycle.db.RecycleManagementDaoImpl;
import com.ecorecycle.gui.ItemView;
import com.ecorecycle.gui.ItemViewModel;
import com.ecorecycle.gui.RCMView;
import com.ecorecycle.gui.RCMViewModel;
import com.ecorecycle.vo.ItemVO;
import com.ecorecycle.vo.RCMVO;

public class ItemRcmController {
	
	private RecycleManagementDAO itemRcmDao = new RecycleManagementDaoImpl();
	private RCMView _rcmView;
	private ItemView _itemView;
	private RCMViewModel _rcmViewModel;
	private ItemViewModel _itemViewModel;
	
	public ItemRcmController(RCMView _Rview, ItemView _Iview){
		this._rcmView = _Rview;
		this._rcmViewModel = _Rview.getViewModel();
		this._itemView = _Iview;
		this._itemViewModel = _Iview.getViewModel();
	}
	
	public void createSearchItemRCMGUI(){
		try {
			List<RCMVO> rcmVOs = itemRcmDao.getAllRCM();
			for(int i=0; i<rcmVOs.size(); i++){
				RCMViewModel viewModel = new RCMViewModel();
				//ItemViewModel IviewModel =new ItemViewModel();
				viewModel.setMachineId(rcmVOs.get(i).getMachineId());
				viewModel.setGroupId(rcmVOs.get(i).getGroupId());
				viewModel.setLocation(rcmVOs.get(i).getLocation());
				viewModel.setOpStatus(rcmVOs.get(i).getOpStatus());
				viewModel.setCashDefaultAmount(rcmVOs.get(i).getCashDefaultAmount());
				viewModel.setMaxCapacity(rcmVOs.get(i).getMaxCapacity());
				viewModel.setTime_last_activated(rcmVOs.get(i).getTime_last_activated());
				viewModel.setCashDefaultAmount(rcmVOs.get(i).getCashDefaultAmount());
				_rcmView.getUpdateComboBox().addItem(viewModel);
			}
			
			_rcmView.getUpdateComboBox().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox cb = (JComboBox)e.getSource();
					RCMViewModel rcmModel = (RCMViewModel) cb.getSelectedItem();
					_rcmView.setUpdateFields(rcmModel);
					
				}
			});
			_rcmView.createSearchItemRCMGUI();
			
			int retValue = performUpdateRCMAction();
			if(retValue == 1){
				_rcmView.createSuccessEvent();
			}
			else if(retValue == -1){
				_rcmView.createFailureEvent();
			}
		} 
		catch (DAOException e) {
			e.printStackTrace();
			_rcmView.createFailureEvent();
		}
	}
	
	public int performUpdateRCMAction() {
		if(_rcmViewModel.getOptionSelected() == 1){
			RCMVO rcmVO = new RCMVO();
			rcmVO.setMachineId(_rcmViewModel.getMachineId());
			rcmVO.setGroupId(_rcmViewModel.getGroupId());
			rcmVO.setLocation(_rcmViewModel.getLocation());
			rcmVO.setOpStatus(_rcmViewModel.getOpStatus());
			rcmVO.setCashDefaultAmount(_rcmViewModel.getCashDefaultAmount());
			rcmVO.setMaxCapacity(_rcmViewModel.getMaxCapacity());
			rcmVO.setTime_last_activated(_rcmViewModel.getTime_last_activated());
			rcmVO.setCashDefaultAmount(_rcmViewModel.getCashDefaultAmount());
			try {
				itemRcmDao.updateRCM(rcmVO);
			} catch (DAOException e) {
				System.out.println("Unable to update an item");
				return -1;
			}
			return 1;
		}
		return 0;
	}
	
//	
//	List<ItemVO> itemVOs = itemDao.getAllItems();
//	for(int i=0; i<itemVOs.size(); i++){
//		ItemViewModel viewModel = new ItemViewModel();
//		viewModel.setItemId(itemVOs.get(i).getItemId());
//		viewModel.setItemName(itemVOs.get(i).getItemName());
//		viewModel.setPrice(itemVOs.get(i).getPrice());
//		viewModel.setType(itemVOs.get(i).getType());
//		viewModel.setWeight(itemVOs.get(i).getWeight());
//		_view.getUpdateComboBox().addItem(viewModel);
//	}
}
