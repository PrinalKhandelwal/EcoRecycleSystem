package com.ecorecycle.vo;

import java.util.Date;

public class RcmVO {

	//Table RCM_GROUP
	int machineId;
	int opStatus;
	String location;
	String maxCapacity;
	String cashDefaultAmount;
	Date time_last_activated;
	
	public Date getTime_last_activated() {
		return time_last_activated;
	}
	public void setTime_last_activated(Date time_last_activated) {
		this.time_last_activated = time_last_activated;
	}
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
	
	@Override
	public String toString() {
		return "RCMVo [machineId=" + machineId 
				+ ", opStatus=" + opStatus + ", location=" + location
				+ ", maxCapacity=" + maxCapacity
				+ ", cashDefaultAmount=" + cashDefaultAmount
			    + "]";
	}
}
