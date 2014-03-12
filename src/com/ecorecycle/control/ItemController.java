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
import com.ecorecycle.vo.ItemVO;

public class ItemController {
	
	private RecycleManagementDAO itemDao = new RecycleManagementDaoImpl();
	private ItemView _view;
	private ItemViewModel _viewModel;
	
	public ItemController(ItemView view){
		this._view = view;
		_viewModel = _view.getViewModel();
	}
	
	public void controlAddItem(){
		_view.createAddItemGUI();
		
		int retValue = performAddItemAction();
		if(retValue == 1){
			_view.createSuccessEvent();
		}
		else if(retValue == -1){
			_view.createFailureEvent();
		}
	}
	
	public void controlUpdateItem(){
		try {
			List<ItemVO> itemVOs = itemDao.getAllItems();
			for(int i=0; i<itemVOs.size(); i++){
				ItemViewModel viewModel = new ItemViewModel();
				viewModel.setItemId(itemVOs.get(i).getItemId());
				viewModel.setItemName(itemVOs.get(i).getItemName());
				viewModel.setPrice(itemVOs.get(i).getPrice());
				viewModel.setType(itemVOs.get(i).getType());
				viewModel.setWeight(itemVOs.get(i).getWeight());
				_view.getUpdateComboBox().addItem(viewModel);
			}
			
			_view.getUpdateComboBox().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox cb = (JComboBox)e.getSource();
					ItemViewModel itemModel = (ItemViewModel) cb.getSelectedItem();
					_view.setUpdateFields(itemModel);
					
				}
			});
			_view.createUpdateItemGUI();
			
			int retValue = performUpdateItemAction();
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
	
	public int performAddItemAction() {
		if(_viewModel.getOptionSelected() == 1){
			ItemVO itemVO = new ItemVO();
			itemVO.setItemName(_viewModel.getItemName());
			itemVO.setPrice(_viewModel.getPrice());
			itemVO.setType(_viewModel.getType());
			itemVO.setWeight(_viewModel.getWeight());
			try {
				itemDao.insertItem(itemVO);
			} catch (DAOException e) {
				System.out.println("Unable to add an item");
				return -1;
			}
			return 1;
		}
		return 0;
	}
	
	public int performUpdateItemAction() {
		if(_viewModel.getOptionSelected() == 1){
			ItemVO itemVO = new ItemVO();
			itemVO.setItemId(_viewModel.getItemId());
			itemVO.setItemName(_viewModel.getItemName());
			itemVO.setPrice(_viewModel.getPrice());
			itemVO.setType(_viewModel.getType());
			itemVO.setWeight(_viewModel.getWeight());
			try {
				itemDao.updateItem(itemVO);
			} catch (DAOException e) {
				System.out.println("Unable to add an item");
				return -1;
			}
			return 1;
		}
		return 0;
	}
}
