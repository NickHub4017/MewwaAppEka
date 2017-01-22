package com.ucsc.finalyear.trustappinstaller;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by nrv on 1/23/17.
 */
public class showPerm extends Activity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permlist);
        String appid=getIntent().getStringExtra("appid");
        DbHandle db=new DbHandle(getApplicationContext());
        ArrayList<Perm> prm=db.getPermList(appid);
        Object[] ar=prm.toArray();
        String[] web=new String[ar.length];
        Integer[] imageId=new Integer[ar.length];

            for (int i = 0; i < ar.length; i++) {
                Perm p = (Perm) prm.get(i);
                web[i] = p.getPermname();
                if (p.ispper()) {
                    imageId[i] = 1;
                } else {
                    imageId[i] = 0;
                }
            }
            CustomList adapter = new
                    CustomList(showPerm.this, web, imageId);
            list = (ListView) findViewById(R.id.listperm);
            list.setAdapter(adapter);



    }
    public void openDialog() {
        final Dialog dialog = new Dialog(getApplicationContext()); // Context, this, etc.
        dialog.setContentView(R.layout.cusomdialog);
        dialog.setTitle("No trusted Peer");
        dialog.show();
    }

}
