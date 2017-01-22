package com.ucsc.finalyear.trustappinstaller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by nrv on 1/22/17.
 */
public class PermListView extends Activity {

    ListView mainListView ;
    ArrayAdapter<String> listAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.permlist);
        DbHandle db=new DbHandle(getApplicationContext());
        // Find the ListView resource.
        mainListView = (ListView) findViewById( R.id.listperm );
        String appid=getIntent().getStringExtra("appid");
        ArrayList<Perm> permls=db.getPermList(appid);
        // Create ArrayAdapter using the planet list.

        // Create and populate a List of planet names.
        String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(planets) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.aperm, planetList);


        // Add more planets. If you passed a String[] instead of a List<String>
        // into the ArrayAdapter constructor, you must not add more items.
        // Otherwise an exception will occur.


        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );


    }
}
