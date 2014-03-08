package com.ecorecycle.vo;

import java.util.Date;


public class RecycleMonitorVO {
	// Table ITEM 
	int itemId;
	String itemName;
	double price;
	double weight;
	String type;
	private int optionSelected;
	
	//Table RCM_GROUP
	int machineId;
	int groupId;
	char opStatus;
	String location;
	String maxCapacity;
	String cashDefaultAmount;
	Date time_last_activated;

	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getOptionSelected() {
		return optionSelected;
	}
	public void setOptionSelected(int optionSelected) {
		this.optionSelected = optionSelected;
	}
	
	
	// RCM Info
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
	public char getOpStatus() {
		return opStatus;
	}
	public void setOpStatus(char opStatus) {
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
	
}
