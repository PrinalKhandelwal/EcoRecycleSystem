package com.ecorecycle.db;

import java.util.List;

import com.ecorecycle.vo.ItemVO;
import com.ecorecycle.vo.RCMVo;

public interface RecycleManagementDAO {
	
// Actions perform on Items
    ItemVO getItem(int itemId) throws DAOException;
	
	List<ItemVO> getAllItems() throws DAOException;
	
	int insertItem(ItemVO item) throws DAOException;
	
	int updateItem(ItemVO item) throws DAOException;
	
	
// Actions perform on RCM
	
	int insertRCM(RCMVo rcmvo) throws DAOException;
}
