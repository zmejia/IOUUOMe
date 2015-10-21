package com.example.zaidamejia.iouuome;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class MyIntentService extends IntentService {

    private static final String TAG = "IntentTest";

    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //This is what the service does


        Log.i(TAG, "The Service has now started");

    }
}
