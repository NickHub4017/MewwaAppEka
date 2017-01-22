package com.ucsc.finalyear.trustappinstaller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import android.support.v7.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by nrv on 1/22/17.
 */


public class AppSearchActivity extends AppCompatActivity {

    private ListView listView;
    private MyAppAdapter myAppAdapter;
    private ArrayList<App> postArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applayout);
        listView = (ListView) findViewById(R.id.listView);
        postArrayList = new ArrayList<>();
        final DbHandle db=new DbHandle(getApplicationContext());
        postArrayList=db.getAppList();



        myAppAdapter = new MyAppAdapter(postArrayList, AppSearchActivity.this);
        listView.setAdapter(myAppAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                App appl=(App)myAppAdapter.arraylist.get(position);

                DbHandle db=new DbHandle(getApplicationContext());
                ArrayList<Perm> prm=db.getPermList(appl.getAppTitle());
                Object[] ar=prm.toArray();
                if(ar.length==1){
                    Toast.makeText(getApplicationContext(),"Your selected Trusted peer doesn't use this app. Please use Your own permissions.",Toast.LENGTH_LONG).show();

                }
                else{

                    //Toast.makeText(getApplicationContext()," ddd  "+permls.size(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AppSearchActivity.this, showPerm.class);
                    intent.putExtra("appid",appl.getAppTitle());
                    startActivityForResult(intent, 100);
                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public class MyAppAdapter extends BaseAdapter {

        public class ViewHolder {
            TextView txtTitle, txtSubTitle;
            ImageView imgview,installicon;


        }

        public List<App> parkingList;

        public Context context;
        ArrayList<App> arraylist;

        private MyAppAdapter(List<App> apps, Context context) {
            this.parkingList = apps;
            this.context = context;
            arraylist = new ArrayList<App>();
            arraylist.addAll(parkingList);

        }

        @Override
        public int getCount() {
            return parkingList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View rowView = convertView;
            ViewHolder viewHolder;

            if (rowView == null) {
                LayoutInflater inflater = getLayoutInflater();
                rowView = inflater.inflate(R.layout.approw, null);
                // configure view holder
                viewHolder = new ViewHolder();
                viewHolder.txtTitle = (TextView) rowView.findViewById(R.id.title);

                viewHolder.imgview=(ImageView)rowView.findViewById(R.id.appicon);
                viewHolder.installicon=(ImageView)rowView.findViewById(R.id.install);
                rowView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.txtTitle.setText(parkingList.get(position).getAppTitle() + "");
          //  viewHolder.txtSubTitle.setText(parkingList.get(position).getAppTitle() + "");
            if(parkingList.get(position).getAppTitle().equals("Candy Crush") ) {
                viewHolder.imgview.setImageResource(R.drawable.candy);
            }
            else if(parkingList.get(position).getAppTitle().equals("Facebook") ) {
                viewHolder.imgview.setImageResource(R.drawable.fb);
            }
            else if(parkingList.get(position).getAppTitle().equals("Hangouts") ) {
                viewHolder.imgview.setImageResource(R.drawable.hangouts);
            }
            else if(parkingList.get(position).getAppTitle().equals("Instagram") ) {
                viewHolder.imgview.setImageResource(R.drawable.inst);
            }
            else if(parkingList.get(position).getAppTitle().equals("Messenger") ) {
                viewHolder.imgview.setImageResource(R.drawable.messenger);
            }
            else if(parkingList.get(position).getAppTitle().equals("Viber") ) {
                viewHolder.imgview.setImageResource(R.drawable.viber);
            }
            else if(parkingList.get(position).getAppTitle().equals("Whatsapp") ) {
                viewHolder.imgview.setImageResource(R.drawable.whts);
            }

            viewHolder.installicon.setImageResource(R.drawable.install);
            return rowView;


        }

        public void filter(String charText) {

            charText = charText.toLowerCase(Locale.getDefault());

            parkingList.clear();
            if (charText.length() == 0) {
                parkingList.addAll(arraylist);

            } else {
                for (App postDetail : arraylist) {
                    if (charText.length() != 0 && postDetail.getAppTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
                        parkingList.add(postDetail);
                    } else if (charText.length() != 0 && postDetail.getAppTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
                        parkingList.add(postDetail);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //*** setOnQueryTextFocusChangeListener ***
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchQuery) {
                myAppAdapter.filter(searchQuery.toString().trim());
                listView.invalidate();
                return true;
            }
        });

        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when collapsed
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                return true;  // Return true to expand action view
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}