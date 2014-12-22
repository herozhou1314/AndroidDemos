package com.hero.org.models;

import com.hero.org.UIApplication;

import android.widget.Toast;

public class Student {
	private String name;
	private int number;

	public Student() {
		name = "";
		number = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void printInfo() {
		Toast.makeText(UIApplication.getInstance(), "name: " + name + ", number: " + number, Toast.LENGTH_SHORT).show();
	}
}
