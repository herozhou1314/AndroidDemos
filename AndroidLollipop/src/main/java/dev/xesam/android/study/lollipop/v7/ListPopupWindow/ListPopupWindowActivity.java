package dev.xesam.android.study.lollipop.v7.ListPopupWindow;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import dev.xesam.android.study.lollipop.R;

public class ListPopupWindowActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.v7_activity_list_popup_window);
    }

    public void showPop(View view) {
        ListPopupWindow listPopupWindow = new ListPopupWindow(this);
        listPopupWindow.setWidth(300);
        listPopupWindow.setModal(true);
        listPopupWindow.setAnchorView(view);
        listPopupWindow.setAdapter(new ArrayAdapter<String>(this, R.layout.v7_apt_list_popup_window, R.id.apt_v7_tv, new String[]{
                "发起群聊",
                "添加朋友",
                "扫一扫",
                "意见反馈"
        }));
        listPopupWindow.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_popup_window, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
