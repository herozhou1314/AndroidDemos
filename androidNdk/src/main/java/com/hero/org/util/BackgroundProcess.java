package com.hero.org.util;

import java.util.ArrayList;

public class BackgroundProcess {
	static {
		System.loadLibrary("ndklibrary");
	}

	// 三个 native 方法和一个 int 变量
	public native boolean checkValid();

	public native void processData(BackgroundProcess bg);

	public native void processGarbage(String[] bg);

	public int num = 5;

	// C++ 中可以调用的方法
	public String backProcess(ArrayList<String> p) {
		System.out.println("这是 Java 里的方法，在 C++ 中调用。");
		System.out.println("这个方法，是 java 中 native checkValid 方法调用的。");
		return "look up process ->" + p;
	}
}
