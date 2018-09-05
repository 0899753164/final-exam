package com.example.hp.helloandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbName = "ND";
    private static final String tableName ="Customers";
    private  static final  int dbVersion = 1;

    public DBHelper(Context context String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, dbName, factory, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + tableName +
            "(CustomerID INTEGER PRIMARY KEY," +
            "FullName TEXT(100)," +
            "Gender TEXT(200));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {

    }
}
