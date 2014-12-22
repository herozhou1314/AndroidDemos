package com.hero.org.models;

public class Order {
	private String name = "Fruit";
	private double price;
	private int amount = 30;
	public Order() {
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}
}
