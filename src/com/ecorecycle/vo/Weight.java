package com.ecorecycle.vo;

public class Weight {

	String units;
	double value;

	public Weight(String units, double value) {
		super();
		this.units = units;
		this.value = value;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
