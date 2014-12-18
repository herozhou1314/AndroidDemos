package dev.xesam.android.study.lollipop.v7.toolbar;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import dev.xesam.android.study.lollipop.R;

public class ToolbarActivity extends ActionBarActivity {

    private SlidingTabLayout mSlidingTabLayout;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.v7_activity_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.v7_toolbar_1);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        toolbar.setNavigationIcon(R.drawable.btn_back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Spinner spinner = (Spinner) findViewById(R.id.v7_toolbar_spinner);
        String[] data = new String[]{
                "AAAAAAAAAA",
                "BBBBBBBBBB",
                "CCCCCCCCCC",
                "AAAAAAAAAA",
                "BBBBBBBBBB",
                "CCCCCCCCCC",
                "AAAAAAAAAA",
                "BBBBBBBBBB",
                "CCCCCCCCCC",
                "AAAAAAAAAA",
                "BBBBBBBBBB",
                "CCCCCCCCCC",
                "AAAAAAAAAA",
                "BBBBBBBBBB",
                "CCCCCCCCCC",
                "AAAAAAAAAA",
                "BBBBBBBBBB",
                "CCCCCCCCCC",
                "AAAAAAAAAA",
                "BBBBBBBBBB",
                "CCCCCCCCCC",
                "AAAAAAAAAA",
                "BBBBBBBBBB",
                "CCCCCCCCCC",
                "AAAAAAAAAA",
                "BBBBBBBBBB",
                "CCCCCCCCCC"
        };

        SpinnerAdapter spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data);
        spinner.setAdapter(spinnerAdapter);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.v7_toolbar_2);
        toolbar2.setTitle("tabs");
        toolbar2.setLogo(R.drawable.ic_launcher);
        toolbar2.setNavigationContentDescription("第2个");

        mViewPager = (ViewPager) findViewById(R.id.v7_pager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return TextFragment.newInstance("text" + position);
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "标题" + position;
            }

        });

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.v7_sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_menu_1) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class TextFragment extends Fragment {

        private static final String ARG = "ARG";

        public static TextFragment newInstance(String text) {
            TextFragment fg = new TextFragment();
            Bundle data = new Bundle();
            data.putString(ARG, text);
            fg.setArguments(data);
            return fg;
        }

        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            TextView textView = new TextView(getActivity());
            textView.setText(getArguments().getString(ARG));
            textView.setTextSize(50);
            return textView;
        }

    }
}
