package com.hero.org;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.hero.org.models.Person;
public class JniToJava extends Activity {
	private native Person getPerson();

	TextView tv_content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jni_to_java);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		tv_content = (TextView) findViewById(R.id.id_default_tv01);
	}

	public void onClick(View v) {
		if (v.getId() == R.id.button1) {
			Person student = getPerson();
			tv_content.setText("name:" + student.getName() + ", number:"
					+ student.getHeight() + "   " + student.getAge());
		}
	}
	static {
		System.loadLibrary("ndklibrary");
	}
}
