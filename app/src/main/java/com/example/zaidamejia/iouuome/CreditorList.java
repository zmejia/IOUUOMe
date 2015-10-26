package com.example.zaidamejia.iouuome;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ImageView;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.Toast;


import java.util.Calendar;


public class CreditorList extends ActionBarActivity {

    ListAdapter creditorAdapter;
    ListView creditorListView;
    EditText description_input;
    TextView  date_text;
    Dialog iou_dialog;
    Calendar calendar = Calendar.getInstance();



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


        date_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(CreditorList.this,listener, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


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

}
