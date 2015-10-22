package com.example.zaidamejia.iouuome;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.ImageView;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.Toast;


public class CreditorList extends ActionBarActivity {

    ListAdapter creditorAdapter;
    ListView creditorListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creditor_iou_list);



        final Integer id = getIntent().getIntExtra("creditor_id",0);


        String[]  creditors = {};
        //converter
        //creditorAdapter = new CustomAdapter(this, creditors);

        creditorListView = (ListView) findViewById(R.id.creditorListView);

        // Tells the ListView what data to use
        creditorListView.setAdapter(creditorAdapter);

        ImageView image = (ImageView) findViewById(R.id.creditorImage);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CreditorList.this, id.toString(), Toast.LENGTH_SHORT).show();
            }
        });







    }

}
