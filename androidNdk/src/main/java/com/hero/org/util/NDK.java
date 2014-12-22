package com.hero.org.util;

import com.hero.org.models.Person;

public class NDK {
	static {
		System.loadLibrary("ndklibrary");
	}
	public native String getString();
	public native int add(int x, int y);
	/****
	 * 传递 object
	 * 
	 * @param Person
	 * @return
	 */
	public native void push(Person model);
	/***
	 * 获取 object
	 * 
	 * @return Person
	 */
	public native Person fetch();

	void callback() {
		System.out.println("MainActivity-->>callback()");
	}

}
