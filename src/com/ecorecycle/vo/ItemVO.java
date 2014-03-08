package com.ecorecycle.vo;

public class ItemVO {
// Table ITEM 
	int itemId;
	String itemName;
	double price;
	double weight;
	String type;


		
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
	
	@Override
	public String toString() {
		return "ItemVO [itemId=" + itemId + ", itemName=" + itemName
				+ ", price=" + price + ", weight=" + weight + ", type=" + type
				+ "]";
	}

	

}