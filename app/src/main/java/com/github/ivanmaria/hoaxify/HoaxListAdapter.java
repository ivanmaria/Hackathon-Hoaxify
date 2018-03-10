package com.github.ivanmaria.hoaxify;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by IsaacIvan on 10-03-2018.
 */

public class HoaxListAdapter extends ArrayAdapter<HoaxList> {

    List<HoaxList> hoaxList;

    Context context;

    int resource;

    public HoaxListAdapter(Context context, int resource, List<HoaxList> hoaxList) {
        super(context, resource, hoaxList);
        this.context = context;
        this.resource = resource;
        this.hoaxList = hoaxList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(resource, null, false);

        TextView hoaxmsg = view.findViewById(R.id.hoaxmsg);
        TextView hoaxid = view.findViewById(R.id.hoaxid);

        HoaxList hoax = hoaxList.get(position);

        hoaxmsg.setText(hoax.getText());
        hoaxid.setText(""+hoax.getId());

        return view;
    }
}