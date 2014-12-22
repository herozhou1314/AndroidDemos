package com.herozhou.mymodule.app2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity  {
    public native String hellojni();
    static {
        System.loadLibrary("JNILibrary");
    }
}
