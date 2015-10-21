package com.example.zaidamejia.iouuome;

/**
 * Created by zaidamejia on 8/26/15.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.util.Log;

import java.sql.Array;


public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "IouUome.db";
    public static final String TABLE_NAME = "creditor_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PHONE";
    public static final String COL_4 = "EMAIL";


    private static final String TAG = "CreditorName";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PHONE TEXT,EMAIL INTEGER)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    //Inserting new creditor data
    public boolean insertNewCreditorData(String name, String phone, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, phone);
        contentValues.put(COL_4, email);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }

    //Display all creditors
    public Cursor getCreditorInfo(){

        SQLiteDatabase db = this.getWritableDatabase();
/**        Cursor result = db.rawQuery("select NAME from " + TABLE_NAME, null);

        Log.i(TAG, "Here");
**/
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        Cursor result = db.rawQuery ( selectQuery, null );



        return result;

    }

    // Getting dataCount
    public int getDataCount() {

        SQLiteDatabase db = this.getWritableDatabase();
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(countQuery, null);

        // return count
        return cursor.getCount();
    }

    }
