package com.github.ivanmaria.hoaxify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
/**
 * Created by IsaacIvan on 10-03-2018.
 */
public class HoaxActivity extends AppCompatActivity {ArrayList<CommentData> dataModels;
    ListView commentList;
    private static CommentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoax);

        String id = getIntent().getStringExtra("hoax_id");

        commentList=(ListView)findViewById(R.id.commentList);

        dataModels= new ArrayList<>();

        dataModels.add(new CommentData("Ivan Maria", "Engineering Student", "I agree","4"));
        dataModels.add(new CommentData("Atharva Aglawe", "TE COMPS", "I disagree","8"));


        adapter= new CommentAdapter(dataModels,getApplicationContext());

        commentList.setAdapter(adapter);
        setListViewHeightBasedOnChildren(commentList);

    }







    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + 20 + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
