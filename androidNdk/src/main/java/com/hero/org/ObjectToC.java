package com.hero.org;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hero.org.models.Student;

public class ObjectToC extends Activity {
	TextView tv_content;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_java_to_c);
		initView();
	}
	private void initView() {
		// TODO Auto-generated method stub
		tv_content = (TextView) findViewById(R.id.id_default_tv01);
	}
	Student student;
	public void onClick(View v) {
		if (v.getId() == R.id.button1) {
			// accessInstanceMethod("Instance Method Call");
			student = new Student();
			student.setName("herozhou1314");
			student.setNumber(1314);
			student = doWithObj(student);
			tv_content.setText("name:" + student.getName() + ", number:" + student.getNumber());
			System.out.println("name: " + student.getName() + ", number: " + student.getNumber());
		}
	}
	public native Student doWithObj(Student student);

	static {
		System.loadLibrary("ndklibrary");
	}

}
