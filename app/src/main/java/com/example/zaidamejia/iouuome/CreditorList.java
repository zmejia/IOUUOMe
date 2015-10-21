package com.example.zaidamejia.iouuome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
/**
 * Created by zaidamejia on 9/15/15.
 */
public class CreditorList extends ActionBarActivity {

    ListAdapter creditorAdapter;
    ListView creditorListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creditor_iou_list);


        String[]  creditors = {};
                //converter
        creditorAdapter = new CustomAdapter(this, creditors);

        creditorListView = (ListView) findViewById(R.id.creditorListView);

        // Tells the ListView what data to use
        creditorListView.setAdapter(creditorAdapter);

    }
}
