package com.ucsc.finalyear.trustappinstaller;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by nrv on 1/22/17.
 */


public class UserMobileActivity extends ListActivity {
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    static final String[] MOBILE_OS =
            new String[] { "Shehan -0713403400", "Kalpani -0773581254", "Damith -0112897845", "Manuranga- 0112784536","Dulakshi -07558895855", "Kasuni- 0112985687"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new UserArrayAdapter(this, MOBILE_OS));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        //get selected items
        String selectedValue = (String) getListAdapter().getItem(position);
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.putString("name", selectedValue.split("-")[0]);
        editor.putString("phone",  selectedValue.split("-")[1]);
        editor.commit();


    }

}
