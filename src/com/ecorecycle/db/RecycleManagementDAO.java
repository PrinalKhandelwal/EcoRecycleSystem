package com.ecorecycle.db;

import java.util.List;

import com.ecorecycle.vo.ItemVO;
import com.ecorecycle.vo.RcmVO;

public interface RecycleManagementDAO {
	
// Actions perform on Items
    ItemVO getItem(int itemId) throws DAOException;
    
    ItemVO getItem(String type) throws DAOException;
	
	List<ItemVO> getAllItems() throws DAOException;
	
	int insertItem(ItemVO item) throws DAOException;
	
	int updateItem(ItemVO item) throws DAOException;
	
	
// Actions perform on RCM
	
	int insertRCM(RcmVO rcmvo) throws DAOException;
	
	int deleteRCM(RcmVO rcmvo) throws DAOException;
	
	int updateRCM(RcmVO rcmvo) throws DAOException;

	List<RcmVO> getAllRCM() throws DAOException;
	
	
	List<ItemVO> getMappedItems(int machineId) throws DAOException;
	
	int upsertMappedItem(int machineId,List<ItemVO> items) throws DAOException;
}
