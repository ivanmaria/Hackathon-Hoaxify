package com.github.ivanmaria.hoaxify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by IsaacIvan on 10-03-2018.
 */

public class CommentAdapter extends ArrayAdapter<CommentData> implements View.OnClickListener{

    private ArrayList<CommentData> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtDesig;
        TextView txtMessage;
        TextView txtFeeling;
        ImageView dp;

    }

    public CommentAdapter(ArrayList<CommentData> data, Context context) {
        super(context, R.layout.comment_layout, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        /*int position=(Integer) v.getTag();
        Object object= getItem(position);
        CommentData dataModel=(CommentData)object;

        switch (v.getId())
        {
            case R.id.item_info:
                Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }*/
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CommentData dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.comment_layout, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.commentName);
            viewHolder.txtDesig = (TextView) convertView.findViewById(R.id.commentDesig);
            viewHolder.txtMessage = (TextView) convertView.findViewById(R.id.commentMsg);
            viewHolder.txtFeeling = (TextView) convertView.findViewById(R.id.commentFeeling);
            viewHolder.dp = (ImageView) convertView.findViewById(R.id.displayPicture);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtDesig.setText(dataModel.getDesignation());
        viewHolder.txtMessage.setText(dataModel.getMessage());
        viewHolder.txtFeeling.setText(dataModel.getFeeling());

        //viewHolder.info.setOnClickListener(this);
        //viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
