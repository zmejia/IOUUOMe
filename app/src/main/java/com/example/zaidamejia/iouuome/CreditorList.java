package com.example.zaidamejia.iouuome;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ImageView;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class CreditorList extends ActionBarActivity {

    ListAdapter creditorAdapter;
    ListView creditorListView;
    EditText description_input, total_iou_input;
    TextView  date_text;
    Button save_iou_button;
    Dialog iou_dialog;
    DatabaseHelper iouDb;
    Calendar calendar = Calendar.getInstance();

    private static final String TAG = "IOUListCount";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creditor_iou_list);

        iouDb = new DatabaseHelper(this);

        final Integer creditor_id = getIntent().getIntExtra("creditor_id",0);


        creditorListView = (ListView) findViewById(R.id.creditorListView);

        // Tells the ListView what data to use
        creditorListView.setAdapter(creditorAdapter);


        ImageView image = (ImageView) findViewById(R.id.creditorImage);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CreditorList.this, creditor_id.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        iouList(creditor_id);


    }

    //Displays List of iou list for selected creditor
    public void iouList(Integer creditor_id){

        Integer iou_count = iouDb.getIOUDataCount();

        List<EntryData> iou_data = viewALlIOU();

        //converter
        CreditorCustomAdapter iouAdapter = new CreditorCustomAdapter(this, iou_data);

        ListView iouListView = (ListView) findViewById(R.id.creditorListView);
        // Tells the ListView what data to use
        iouListView.setAdapter(iouAdapter);
       // Log.i(TAG, "pass");

    }

    public List<EntryData> viewALlIOU() {
        Cursor cursor = iouDb.getIOUInfo();
        List<EntryData> iouList = new ArrayList<EntryData>();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                EntryData data = new EntryData();
                data.setID(Integer.parseInt(cursor.getString(0)));
                data.setDescription(cursor.getString(1));
                data.setDate(cursor.getString(2));
                data.setTotal(cursor.getString(3));
                // Adding entry to list
                iouList.add(data);
            } while (cursor.moveToNext());
        }
        // returnS entry list
        return iouList;
    }


    public void addIOUButton(View v){
        iou_dialog = new Dialog(CreditorList.this);
        iou_dialog.setTitle("New IOU");
        iou_dialog.setContentView(R.layout.new_iou_layout);
        iou_dialog.show();

        final Button cancel_new_iou_button = (Button) iou_dialog.findViewById(R.id.cancel_new_iou_button);
        cancel_new_iou_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iou_dialog.cancel();
            }
        });

        //New creditor information from the dialog
        description_input = (EditText) iou_dialog.findViewById(R.id.description_input);
        Button date_button = (Button) iou_dialog.findViewById(R.id.date_button);
        date_text = (TextView) iou_dialog.findViewById(R.id.date_text);
        total_iou_input = (EditText) iou_dialog.findViewById(R.id.total_iou_input);


        date_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CreditorList.this,listener, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        save_iou_button = (Button) iou_dialog.findViewById(R.id.save_iou_button);
        saveNewIOU();

    }

    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

           int cday = dayOfMonth;
           int cmonth = monthOfYear + 1;
           int cyear = year;

            date_text.setText(cmonth + "/" + cday + "/" + cyear);

        }
    };

    //save creditor information
    public void saveNewIOU(){
        save_iou_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent add_iou_intent = new Intent(v.getContext(), AddIOUIntent.class);

                String description = description_input.getText().toString();
                String date = date_text.getText().toString();
                String total = total_iou_input.getText().toString();

                add_iou_intent.putExtra("iou_info", new String[]{description, date, total});

                startService(add_iou_intent);

                //code to return to an updated list
                iou_dialog.cancel();
            }
        });
    }





}
