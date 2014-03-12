package com.ecorecycle.db;

import java.util.List;

import com.ecorecycle.vo.ItemVO;
import com.ecorecycle.vo.RCMVO;

public interface RecycleManagementDAO {
	
// Actions perform on Items
    ItemVO getItem(int itemId) throws DAOException;
	
	List<ItemVO> getAllItems() throws DAOException;
	
	int insertItem(ItemVO item) throws DAOException;
	
	int updateItem(ItemVO item) throws DAOException;
	
	
// Actions perform on RCM
	
	int insertRCM(RCMVO rcmvo) throws DAOException;
	
	int deleteRCM(RCMVO rcmvo) throws DAOException;
	
	int updateRCM(RCMVO rcmvo) throws DAOException;

	List<RCMVO> getAllRCM() throws DAOException;
}
