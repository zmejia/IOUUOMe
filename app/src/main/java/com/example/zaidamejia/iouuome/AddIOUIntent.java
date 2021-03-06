package com.example.zaidamejia.iouuome;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;



public class AddIOUIntent extends IntentService {

    DatabaseHelper myDb;
    String description;
    String date;
    String total;
    String test;
    Integer creditorId;

    private static final String TAG = "DBIOUTest";
    private static final String TAG1 = "ADDIOU";


    public AddIOUIntent(){
        super("AddIOUIntent");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //This is what the service does
        myDb = new DatabaseHelper(this);

        String[] iou_info = intent.getStringArrayExtra("iou_info");
        description = iou_info[0];
        date = iou_info[1];
        total = iou_info[2];
        creditorId = Integer.parseInt(iou_info[3]);

        test = description + " " + date + " " + total;// + " "+ creditorId;
        Log.i(TAG, test);

        addNewIOU(creditorId);


    }

    // Insert new creditor data into database
    public void addNewIOU(int creditorId){

        boolean isInserted = myDb.insertNewIOUData(description, date, total);
        //Log.i(TAG1, test);

        if (isInserted)
            Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(), "Data Not Inserted", Toast.LENGTH_LONG).show();

    }


}
