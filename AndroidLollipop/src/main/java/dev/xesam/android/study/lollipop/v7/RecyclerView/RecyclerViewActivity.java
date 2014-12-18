package dev.xesam.android.study.lollipop.v7.RecyclerView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import dev.xesam.android.study.lollipop.R;

public class RecyclerViewActivity extends ActionBarActivity {


    private RecyclerView rv;

    class RvViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tv;

        public RvViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            itemView.setTag(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v == itemView) {
                Toast.makeText(itemView.getContext(), getPosition() + "", Toast.LENGTH_SHORT).show();
            }
        }
    }

    class RvAdapter extends RecyclerView.Adapter<RvViewHolder> {

        Context context;
        String[] items;

        public RvAdapter(Context context, String[] items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public RvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.v7_apt_recycler_view, parent, false);
            return new RvViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RvViewHolder holder, int position) {
            holder.tv.setText(items[position]);
        }

        @Override
        public int getItemCount() {
            return items.length;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.v7_activity_recycler_view);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setAdapter(new RvAdapter(this, new String[]{
                "A", "B", "C", "D",
                "A", "B", "C", "D",
                "A", "B", "C", "D",
                "A", "B", "C", "D",
                "A", "B", "C", "D",
                "A", "B", "C", "D",
                "A", "B", "C", "D",
                "A", "B", "C", "D",
                "A", "B", "C", "D",
                "A", "B", "C", "D",
                "A", "B", "C", "D",
                "A", "B", "C", "D",
                "A", "B", "C", "D"
        }));
//        网格模式
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
//        rv.setLayoutManager(gridLayoutManager);

        //横向列表
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
//        rv.setLayoutManager(linearLayoutManager);

        //纵向列表
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        rv.addItemDecoration(new RecyclerView.ItemDecoration() {

            Paint paint = new Paint();

            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }

            @Override
            public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDrawOver(c, parent, state);
                for (int i = 0, size = parent.getChildCount(); i < size; i++) {
                    View child = parent.getChildAt(i);
                    c.drawLine(child.getLeft(), child.getBottom(), child.getRight(), child.getBottom(), paint);
                }
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
            }
        });

    }
}
