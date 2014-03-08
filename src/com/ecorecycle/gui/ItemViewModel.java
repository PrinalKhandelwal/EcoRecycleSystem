package com.ecorecycle.gui;

public class ItemViewModel {

	int itemId;
	String itemName;
	double price;
	double weight;
	String type;
	private int optionSelected;
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
	
	public String toString(){
		return getItemName();
	}
	
}
