package com.hero.org;

import android.app.Application;

public class UIApplication extends Application {
	static UIApplication instance;
	public static UIApplication getInstance() {
		return instance;
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		instance = this;
	}

}
