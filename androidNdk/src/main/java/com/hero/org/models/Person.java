package com.hero.org.models;

public class Person {
	public String mName;
	public static String instanceField = "Instance Field";
	public int mAge;
	public float mHeight = 1.2f;
	public Person() {
	}
	public String toString() {
		return "mName:" + mName + ", mAge:" + mAge + ", mHeight:" + mHeight;
	}

	public String getName() {
		return "herozhou1314";
	}

	public int getAge() {
		return mAge;
	}

	public float getHeight() {
		return mHeight;
	}

	public void setName(String mName) {
		this.mName = mName;
	}

	public void setAge(int mAge) {
		this.mAge = mAge;
	}

	public void setHeight(float mHeight) {
		this.mHeight = mHeight;
	}
}
