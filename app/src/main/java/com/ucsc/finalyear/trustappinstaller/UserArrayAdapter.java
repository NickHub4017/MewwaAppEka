package com.ucsc.finalyear.trustappinstaller;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nrv on 1/22/17.
 */


public class UserArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public UserArrayAdapter(Context context, String[] values) {
        super(context, R.layout.users_rowlayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.users_rowlayout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        textView.setText(values[position]);

        // Change icon based on name
        String s = values[position];

        System.out.println(s);

        if (s.equals("WindowsMobile")) {
            imageView.setImageResource(R.drawable.girlone);
        } else if (s.equals("iOS")) {
            imageView.setImageResource(R.drawable.girlone);
        } else if (s.equals("Blackberry")) {
            imageView.setImageResource(R.drawable.girlone);
        } else {
            imageView.setImageResource(R.drawable.girlone);
        }

        return rowView;
    }


}