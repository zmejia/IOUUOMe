package com.example.zaidamejia.iouuome;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "IouUome.db";
    public static final String TABLE_NAME = "creditor_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PHONE";
    public static final String COL_4 = "EMAIL";

    public static final String IOU_TABLE = "iou_table";
    public static final String IOU_ID = "ID";
    public static final String IOU_DESCRIPTION = "DESCRIPTION";
    public static final String IOU_DATE = "DATE";
    public static final String IOU_TOTAL = "TOTAL";



    private static final String TAG = "CreditorName";
    private static final String TAG1 = "Count";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PHONE TEXT,EMAIL INTEGER)");
        db.execSQL("create table " + IOU_TABLE +
                "(" + IOU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + IOU_DESCRIPTION + " TEXT,"
                + IOU_DATE + " TEXT," + IOU_TOTAL + " INTEGER)");


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+IOU_TABLE);
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
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        Cursor result = db.rawQuery(selectQuery, null);

        return result;

    }

    // Getting dataCount
    public int getDataCount() {

        SQLiteDatabase db = this.getWritableDatabase();
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(countQuery, null);

        // return count
        return cursor.getCount();
    }

    //Inserting new iou data
    public boolean insertNewIOUData(String description, String date, String total){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(IOU_DESCRIPTION, description);
        contentValues.put(IOU_DATE, date);
        contentValues.put(IOU_TOTAL, total);
        long result = db.insert(IOU_TABLE, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }

    // Getting dataCount
    public int getIOUDataCount() {

        SQLiteDatabase db = this.getWritableDatabase();
        String iouCountQuery = "SELECT  * FROM " + IOU_TABLE;
        Cursor iouCursor = db.rawQuery(iouCountQuery, null);
        Integer count = iouCursor.getCount();
        //Log.i(TAG1, count.toString());
        return count;
    }

    //Display all creditor
    public Cursor getIOUInfo(){

        SQLiteDatabase db = this.getWritableDatabase();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + IOU_TABLE;

        Cursor result = db.rawQuery(selectQuery, null);

        return result;

    }


}
