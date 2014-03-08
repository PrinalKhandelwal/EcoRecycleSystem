package com.ecorecycle.control;

import com.ecorecycle.db.DAOException;
import com.ecorecycle.db.RecycleManagementDAO;
import com.ecorecycle.db.RecycleManagementDaoImpl;
import com.ecorecycle.gui.ItemView;
import com.ecorecycle.vo.RCMVo;
import com.ecorecycle.vo.RecycleMonitorVO;

public class RcmController {
	
	private RecycleManagementDAO itemDao = new RecycleManagementDaoImpl();
	private ItemView _view;
	private RecycleMonitorVO _viewModel;
	
	public RcmController(ItemView EcoReFrame,RecycleMonitorVO EcoReFrameModel){
		this._view = EcoReFrame;
		this._viewModel = EcoReFrameModel;
	}

	public boolean performAddRCMAction() {
		if(_viewModel.getOptionSelected() == 1){
			RCMVo rcmVO = new RCMVo();
			rcmVO.setGroupId(_viewModel.getGroupId());
			rcmVO.setOpStatus(_viewModel.getOpStatus());
			rcmVO.setLocation(_viewModel.getLocation());
			rcmVO.setMaxCapacity(_viewModel.getMaxCapacity());
			rcmVO.setCashDefaultAmount(_viewModel.getCashDefaultAmount());
			rcmVO.setMaxCapacity(_viewModel.getMaxCapacity());
			try {
				itemDao.insertRCM(rcmVO);
			} catch (DAOException e) {
				System.out.println("Unable to add an item");
				return false;
			}
		}
		return true;
	}

}
