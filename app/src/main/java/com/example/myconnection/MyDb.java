package com.example.myconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.HashMap;

public class MyDb {
    private SQLiteDatabase db;
    private Context context;
    private DbHelper dbHelper;

    public MyDb(Context context){
        this.context = context;
        dbHelper = new DbHelper(context);
    }

    public void open() throws SQLiteException{
        try {
            db = dbHelper.getWritableDatabase();
        }catch (SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }
    }

    public void close(){
        db.close();
    }

    public long insertEntry(String date, String entry){
        try {
            ContentValues newEntry = new ContentValues();
            newEntry.put(Constants.DATE, date);
            newEntry.put(Constants.ENTRY, entry);
            return db.insert(Constants.TABLE_NAME, null, newEntry);
        } catch(SQLiteException e){
            return -1;
        }
    }

    public ArrayList<String> getEntries(){
        String sql = "SELECT * FROM " + Constants.TABLE_NAME + ";";
        ArrayList<String> entries = new ArrayList<>();

        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();

        if(c.getCount() > 0){

            if(c.isFirst()){
                entries.add(c.getString(0));
                entries.add(c.getString(1));
            }

            while(c.moveToNext()){
                entries.add(c.getString(0));
                entries.add(c.getString(1));
            }
        }

        return entries;
    }
}
