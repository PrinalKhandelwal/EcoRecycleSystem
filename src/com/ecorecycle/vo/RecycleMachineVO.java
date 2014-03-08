package com.ecorecycle.vo;

import java.util.*;

public class RecycleMachineVO {

	//RCM machine information
	int machineId;
	int groupId;
	String opStatus;
	String location;
	Date timeLastActivated;
	double maxCapacity;
	double totalCash;

	List<ItemVO> itemList;

	// RCM Consolidation fields
	Date timeLastEmptied;
	int numOfItemsReturned;
	double totalValueIssued;

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getOpStatus() {
		return opStatus;
	}

	public void setOpStatus(String opStatus) {
		this.opStatus = opStatus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getTimeLastActivated() {
		return timeLastActivated;
	}

	public void setTimeLastActivated(Date timeLastActivated) {
		this.timeLastActivated = timeLastActivated;
	}

	public double getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(double maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public double getTotalCash() {
		return totalCash;
	}

	public void setTotalCash(double totalCash) {
		this.totalCash = totalCash;
	}

	public List<ItemVO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemVO> itemList) {
		this.itemList = itemList;
	}

	public Date getTimeLastEmptied() {
		return timeLastEmptied;
	}

	public void setTimeLastEmptied(Date timeLastEmptied) {
		this.timeLastEmptied = timeLastEmptied;
	}

	public int getNumOfItemsReturned() {
		return numOfItemsReturned;
	}

	public void setNumOfItemsReturned(int numOfItemsReturned) {
		this.numOfItemsReturned = numOfItemsReturned;
	}

	public double getTotalValueIssued() {
		return totalValueIssued;
	}

	public void setTotalValueIssued(double totalValueIssued) {
		this.totalValueIssued = totalValueIssued;
	}

}
