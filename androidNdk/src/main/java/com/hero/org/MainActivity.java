package com.hero.org;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.hero.org.models.Person;
import com.hero.org.util.NDK;

public class MainActivity extends Activity {
	TextView tv_content;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv_content = (TextView) findViewById(R.id.id_default_tv01);
		NDK ndk = new NDK();
		Person person = new Person();
		person.setName("herozhou1314");
		person.setAge(25);
		person.setHeight(165.33f);
		ndk.push(person);
		Person person2 = ndk.fetch();
		System.out.println("modelUtil2==>>" + person2.getName());
		tv_content.setText(ndk.getString() + "  " + ndk.add(100, 100));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public native float getFloat(float a);
}
