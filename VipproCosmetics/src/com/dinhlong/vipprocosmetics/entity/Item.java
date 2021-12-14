package com.dinhlong.vipprocosmetics.entity;

public class Item {
	private Cosmetics cosmetics;
	private int quantity;

	public Item() {
	}

	public Item(Cosmetics cosmetics, int quantity) {
		this.cosmetics = cosmetics;
		this.quantity = quantity;
	}

	public Cosmetics getCosmetics() {
		return cosmetics;
	}

	public void setCosmetics(Cosmetics cosmetics) {
		this.cosmetics = cosmetics;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
