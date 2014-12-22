package com.hero.org;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hero.org.models.Order;
import com.hero.org.models.Student;
import com.hero.org.util.BackgroundProcess;
import com.hero.org.util.Business;

public class JNICpp extends Activity {
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
	Business business;
	public void onClick(View v) {
		if (v.getId() == R.id.button1) {
			business = new Business();
			business.getPrice("herozhou1314");
			Order order = business.getOrder("herozhou1234", 1111);
			System.out.println("order-->>" + order.toString());
			System.out.println("order-->>2222-->>" + business.getRamdomOrder().toString());
			Order order2 = new Order();
			order2.setAmount(1111111111);
			order2.setName("test11");
			order2.setPrice(343.0f);
			System.out.println("order-->>3333-->>" + order2.toString());
			business.pullOrder(order2);
			business.analyzeOrder(order2);

			String[] array = new String[4];
			array[0] = "jack";
			array[1] = "maggie";
			array[2] = "rocket";
			array[3] = "tom";
			BackgroundProcess bgP = new BackgroundProcess();
			// 调用 C++ DLL 中定义的方法。
			bgP.checkValid();// 该方法回调 java 中的 backProcess
								// 方法,即java::checkValid->c++::checkValid->java::backProcess
			bgP.processData(bgP);
			bgP.processGarbage(array);
			// C++ DLL 改变了该变量
			System.out.println("number 现在的值是: " + bgP.num);
		}
	}
}
