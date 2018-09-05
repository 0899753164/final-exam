package com.example.hp.individual;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper
{
    public static final String dbName = "Icare";        //databaseName
    private static  final int dbVersion = 1;            //V.db
    private static  final String tableName = "USER";    ////table name

/////////////table column namae ////////////////////////////////////////////////
    private static final String ID = "id";                  //column id
    public static final String COL_DATE ="Date";            //column name
    public  static final String COL_DRUG ="Drug";          //column name
    public  static final String COL_SYMPTON ="sympton";     //column name
    public static final String COL_TREATMENT ="treatment";  //column name
///////////////////////////////////////////////////////////////////////////////
                        /////Create table/////
    private static final String CREATE_DATABASE =
            "CREATE TABLE " + tableName + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_DATE + " DATE," + COL_DRUG + " VARCHAR(100),"
                +COL_SYMPTON + " VARCHAR(100)," + COL_TREATMENT + " VARCHAR(100)" + ");";

    public DBHelper(Context context)
    {
        super(context, dbName, null, dbVersion);

        Log.d("table",CREATE_DATABASE);
    }
        ////////Creating table////////////
    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL(CREATE_DATABASE);            ///run the create table db
    }
//////////////onUpgrade/////////////////////////////////////////////////////
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS '" + tableName + "'");
        onCreate(db);
    }
////////////////////////////////////InsertData////////////////////////////////////////////
    public long insertData(String date, String drug, String sympton, String treatment)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_DATE,date);
        contentValues.put(COL_DRUG,drug);
        contentValues.put(COL_SYMPTON,sympton);
        contentValues.put(COL_TREATMENT,treatment);
        long insert = db.insert(tableName, null, contentValues);
        return insert;
    }
    /////////Query data read////////////////////////////////////////
    public ArrayList<UserModel> getAllUser()
      {
        ArrayList<UserModel>  userModelArrayList = new ArrayList<UserModel>();

        String selectQuery = "SELECT * FROM " + tableName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        //////loop through all rows & adding to list///
        if (c.moveToFirst())
        {
           do {
               UserModel userModel = new UserModel();
               userModel.setid(c.getInt(c.getColumnIndex(ID)));
               userModel.setdate(c.getString(c.getColumnIndex(COL_DATE)));
               userModel.setDrug(c.getString(c.getColumnIndex(COL_DRUG)));
               userModel.setSymtop(c.getString(c.getColumnIndex(COL_SYMPTON)));
               userModel.setTreatment(c.getString(c.getColumnIndex(COL_TREATMENT)));
               userModelArrayList.add(userModel);

           }while (c.moveToNext());
        }
        return userModelArrayList;
     }
            ////////////update data////////////////////
     public String updateData(int id, String date, String drug, String sympton, String treatment){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
         contentValues.put(COL_DATE,date);
         contentValues.put(COL_DRUG,drug);
         contentValues.put(COL_SYMPTON,sympton);
         contentValues.put(COL_TREATMENT,treatment);
         return String.valueOf(db.update(tableName, contentValues, ID + " = ?",
                 new String[]{String.valueOf(id)}));
     }

     public UserModel getUserModel(int id)
      {
            SQLiteDatabase db = this.getWritableDatabase();
            String query = " SELECT * FROM " + tableName + " WHERE id= "+ id;
            Cursor cursor = db.rawQuery(query, null);
            UserModel userModel = new UserModel();

         if (cursor.getCount() > 0){

                 cursor.moveToFirst();
                 userModel.setid((int) cursor.getLong(cursor.getColumnIndex(ID)));
                 userModel.setdate(cursor.getString(cursor.getColumnIndex(COL_DATE)));
                 userModel.setDrug(cursor.getString(cursor.getColumnIndex(COL_DRUG)));
                 userModel.setSymtop(cursor.getString(cursor.getColumnIndex(COL_SYMPTON)));
                 userModel.setTreatment(cursor.getString(cursor.getColumnIndex(COL_TREATMENT)));

         }
         return userModel;

     }
     /////////////////update data
  /*   public  void UpdateUserModel(Log id,Context context,UserModel userModel){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE "+tableName+" SET id ='"+ userModel.getId()+
                    "', date = '" + userModel.getDate()+
                    "', drug = '" + userModel.getDrug()+
                    "', sympton '" + userModel.getSymtop()+
                    "', treatment '" + userModel.getTreatment()+
                    "', WHARE id='" + id+ "'");
         Toast.makeText(context, "update successfully", Toast.LENGTH_SHORT).show();
     }
     */
    //////////delete data///////////////////////////////////
    public void deleteData(int id, Context context)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+ tableName+" WHERE id='"+id+"'");
        Toast.makeText(context, "ลบข้อมูลเรียบร้อยแล้ว ", Toast.LENGTH_SHORT).show();

    }
}
