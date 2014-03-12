package com.ecorecycle.gui.viewmodels;

import java.util.Date;
import java.util.List;

public class RcmViewModel {
	//Table RCM_GROUP
	int machineId;
	int opStatus;
	String location;
	String maxCapacity;
	String cashDefaultAmount;
	Date time_last_activated;
	private int optionSelected;
	
	List<String> selectedItems;
	
	public int getMachineId() {
		return machineId;
	}
	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}
	
	public int getOpStatus() {
		return opStatus;
	}
	public void setOpStatus(int opStatus) {
		this.opStatus = opStatus;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(String maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public String getCashDefaultAmount() {
		return cashDefaultAmount;
	}
	public void setCashDefaultAmount(String cashDefaultAmount) {
		this.cashDefaultAmount = cashDefaultAmount;
	}
	public Date getTime_last_activated() {
		return time_last_activated;
	}
	public void setTime_last_activated(Date time_last_activated) {
		this.time_last_activated = time_last_activated;
	}
	public int getOptionSelected() {
		return optionSelected;
	}
	public void setOptionSelected(int optionSelected) {
		this.optionSelected = optionSelected;
	}
	
	public String toString(){
		return  machineId + "::" + location;
	}
	public List<String> getSelectedItems() {
		return selectedItems;
	}
	
	public void setSelectedItems(List<String> items){
		this.selectedItems = items;
	}
	
}
