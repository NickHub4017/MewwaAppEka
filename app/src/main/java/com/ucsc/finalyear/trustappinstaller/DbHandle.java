package com.ucsc.finalyear.trustappinstaller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by nrv on 1/22/17.
 */
public class DbHandle extends SQLiteOpenHelper {
    private ArrayList<App> appList;

    public DbHandle(Context context) {
        super(context,"app.db",null,3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE app_perm_data (\n" +
                "  app text NOT NULL,\n" +
                "  permission text NOT NULL,\n" +
                "  is_peer_given tinyint(1) NOT NULL\n" +
                ")");
        db.execSQL("INSERT INTO `app_perm_data` (`app`, `permission`, `is_peer_given`) VALUES\n" +
                "('Facebook', 'Device & app history', 1),\n" +
                "('Facebook', 'Identity', 1),\n" +
                "('Facebook', 'Calendar', 1),\n" +
                "('Facebook', 'Contacts', 1),\n" +
                "('Facebook', 'Location', 0),\n" +
                "('Facebook', 'SMS', 0),\n" +
                "('Facebook', 'Phone', 1),\n" +
                "('Facebook', 'Photos/Media/Files', 1),\n" +
                "('Facebook', 'Storage', 1),\n" +
                "('Facebook', 'Camera', 1),\n" +
                "('Facebook', 'Microphone', 1),\n" +
                "('Facebook', 'Wi-Fi connection information', 1),\n" +
                "('Facebook', 'Device ID & call information', 0),\n" +
                "('Whatsapp', 'Device & app history', 1),\n" +
                "('Whatsapp', 'Identity', 1),\n" +
                "('Whatsapp', 'Calendar', 0),\n" +
                "('Whatsapp', 'Contacts', 1),\n" +
                "('Whatsapp', 'Location', 0),\n" +
                "('Whatsapp', 'SMS', 0),\n" +
                "('Whatsapp', 'Phone', 1),\n" +
                "('Whatsapp', 'Photos/Media/Files', 1),\n" +
                "('Whatsapp', 'Storage', 1),\n" +
                "('Whatsapp', 'Camera', 1),\n" +
                "('Whatsapp', 'Microphone', 1),\n" +
                "('Whatsapp', 'Wi-Fi connection information', 1),\n" +
                "('Whatsapp', 'Device ID & call information', 1),\n" +
                "('Viber', 'Device & app history', 1),\n" +
                "('Viber', 'Identity', 1),\n" +
                "('Viber', 'Calendar', 0),\n" +
                "('Viber', 'Contacts', 1),\n" +
                "('Viber', 'Location', 0),\n" +
                "('Viber', 'SMS', 0),\n" +
                "('Viber', 'Phone', 1),\n" +
                "('Viber', 'Photos/Media/Files', 1),\n" +
                "('Viber', 'Storage', 1),\n" +
                "('Viber', 'Camera', 1),\n" +
                "('Viber', 'Microphone', 1),\n" +
                "('Viber', 'Wi-Fi connection information', 1),\n" +
                "('Viber', 'Device ID & call information', 1),\n" +
                "('Instagram', 'Device & app history', 0),\n" +
                "('Instagram', 'Identity', 1),\n" +
                "('Instagram', 'Calendar', 0),\n" +
                "('Instagram', 'Contacts', 1),\n" +
                "('Instagram', 'Location', 1),\n" +
                "('Instagram', 'SMS', 0),\n" +
                "('Instagram', 'Phone', 0),\n" +
                "('Instagram', 'Photos/Media/Files', 1),\n" +
                "('Instagram', 'Storage', 1),\n" +
                "('Instagram', 'Camera', 1),\n" +
                "('Instagram', 'Microphone', 1),\n" +
                "('Instagram', 'Wi-Fi connection information', 1),\n" +
                "('Instagram', 'Device ID & call information', 1),('Whatsapp', 'Device & app history', 1),\n" +
                "('hangouts', 'Identity', 1),\n" +
                "('hangouts', 'Calendar', 1),\n" +
                "('hangouts', 'Contacts', 1),\n" +
                "('hangouts', 'Location', 0),\n" +
                "('hangouts', 'SMS', 1),\n" +
                "('hangouts', 'Phone', 1),\n" +
                "('hangouts', 'Photos/Media/Files', 1),\n" +
                "('hangouts', 'Storage', 1),\n" +
                "('hangouts', 'Camera', 1),\n" +
                "('hangouts', 'Microphone', 1),\n" +
                "('hangouts', 'Wi-Fi connection information', 1),\n" +
                "('hangouts', 'Device ID & call information', 1),\n" +
                "('Candy Crush', '0', 0),\n" +
                "('Messenger', 'Device & app history', 1),\n" +
                "('Messenger', 'Identity', 1),\n" +
                "('Messenger', 'Calendar', 0),\n" +
                "('Messenger', 'Contacts', 1),\n" +
                "('Messenger', 'Location', 0),\n" +
                "('Messenger', 'SMS', 1),\n" +
                "('Messenger', 'Phone', 1),\n" +
                "('Messenger', 'Photos/Media/Files', 1),\n" +
                "('Messenger', 'Storage', 1),\n" +
                "('Messenger', 'Camera', 1),\n" +
                "('Messenger', 'Microphone', 1),\n" +
                "('Messenger', 'Wi-Fi connection information', 1),\n" +
                "('Messenger', 'Device ID & call information', 1);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<App> getAppList() {

        ArrayList<App> array_list = new ArrayList<App>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from 'app_perm_data' group by app", null);
        res.moveToFirst();

        while(res.isAfterLast() == false){
            App a=new App();
            a.setAppTitle(res.getString(res.getColumnIndex("app")));
            array_list.add(a);
            res.moveToNext();
        }
        return array_list;

    }

    public ArrayList<Perm> getPermList(String appname) {

        ArrayList<Perm> array_list = new ArrayList<Perm>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from 'app_perm_data' where app = '"+appname+"'", null);
        res.moveToFirst();

        while(res.isAfterLast() == false){
            Perm a=new Perm();
            a.setPermname(res.getString(res.getColumnIndex("permission")));
            a.setIspper(res.getInt(res.getColumnIndex("is_peer_given"))==1);
            array_list.add(a);
            res.moveToNext();
        }
        return array_list;

    }
}
