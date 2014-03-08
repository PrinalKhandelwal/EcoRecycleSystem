package com.ecorecycle.vo;

public class PayOut {

	double value;
	String paymentMode;

	public PayOut(double value, String paymentMode) {
		super();
		this.value = value;
		this.paymentMode = paymentMode;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

}
