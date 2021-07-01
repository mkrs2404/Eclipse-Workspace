package com.mohit.war;


public class Battalion {
	
	
	private String type;
	
	private int rank;
	
	private int quantityLeft;
	
	private int MaxQty;

	public Battalion(String type, int rank, int quantityLeft, int MaxQty) {
		this.type = type;
		this.rank = rank;
		this.quantityLeft = quantityLeft;
		this.MaxQty = MaxQty;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getQuantityLeft() {
		return quantityLeft;
	}

	public void setQuantityLeft(int quantityLeft) {
		this.quantityLeft = quantityLeft;
	}

	public int getMaxQty() {
		return MaxQty;
	}

	public void setMaxQty(int maxQty) {
		MaxQty = maxQty;
	}
	
}
