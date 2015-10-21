package com.example.zaidamejia.iouuome;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.Intent;

/**
 * Created by zaidamejia on 8/26/15.
 */
public class DatabaseMethods extends IntentService{

    DatabaseHelper myDb;
    String name;
    String phone;
    String email;


    private static final String TAG = "DBIntentTest";

    public DatabaseMethods(){
        super("DatabaseMethods");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //This is what the service does
        myDb = new DatabaseHelper(this);

        String[] creditor_info = intent.getStringArrayExtra("creditor_info");
        name = creditor_info[0];
        phone = creditor_info[1];
        email = creditor_info[2];

        Log.i(TAG, phone);

       addNewCreditor();


    }


    // Insert new creditor data into database
    public void addNewCreditor(){
        boolean isInserted = myDb.insertNewCreditorData(name, phone, email);

        if (isInserted)
           Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_LONG).show();
       else
           Toast.makeText(getApplicationContext(), "Data Not Inserted", Toast.LENGTH_LONG).show();

    }





}
