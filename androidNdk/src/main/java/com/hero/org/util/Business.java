package com.hero.org.util;

import com.hero.org.models.Order;

public class Business {
	static {
		System.loadLibrary("ndklibrary");
	}
	public Business() {
	}
	public native double getPrice(String name);

	public native Order getOrder(String name, int amount);

	public native Order getRamdomOrder();

	public native int pullOrder(Order order);

	public native void analyzeOrder(Order order);

	public void notification() {
		System.out.println("Got a notification.");
	}

	public static void notificationByStatic() {
		System.out.println("Got a notification in a static method.");
	}
}
