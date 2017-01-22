package com.ucsc.finalyear.trustappinstaller;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nrv on 1/23/17.
 */

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    public CustomList(Activity context,
                      String[] web, Integer[] imageId) {
        super(context, R.layout.list_single, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtperm);


        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgperm);
        txtTitle.setText(web[position]);
        if(imageId[position]==1) {
            imageView.setImageResource(R.drawable.ok);
        }
        else{
            imageView.setImageResource(R.drawable.no);
        }
        return rowView;
    }
}