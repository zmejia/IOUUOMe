package com.example.zaidamejia.iouuome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.app.Dialog;
import android.database.Cursor;
import android.app.AlertDialog;
import android.util.Log;
import java.util.List;


import java.util.ArrayList;

/**
 * Created by zaidamejia on 7/31/15.
 */
public class IOUList extends ActionBarActivity {

    Button save_new_creditor_button;
    EditText creditor_name, creditor_email, creditor_phone;
    Dialog dialog;
    DatabaseHelper myDb;

    private static final String TAG = "Creditor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iou_list);

        myDb = new DatabaseHelper(this);

        Intent db_intent = new Intent(this, MyIntentService.class);
        startService(db_intent);

        creditorList();

    }

    //Displays List of creditors
    public void creditorList(){

        //TEST CASE FOR WHEN THE LIST IS EMPTY


        int count = myDb.getDataCount();

        List<UserData> data = viewALlCreditors();
        //converter
        CustomAdapter theAdapter = new CustomAdapter(this, data);
        ListView theListView = (ListView) findViewById(R.id.IOUListView);
        // Tells the ListView what data to use
        theListView.setAdapter(theAdapter);


        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               UserData user = (UserData) adapterView.getItemAtPosition(position);
               Integer creditor = user.getID();

                Toast.makeText(IOUList.this, creditor.toString(), Toast.LENGTH_SHORT).show();

            }

        });


    }


    // Getting All User data
    public List<UserData> viewALlCreditors() {
        Cursor cursor = myDb.getCreditorInfo();
        List<UserData> contactList = new ArrayList<UserData>();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserData data = new UserData();
                data.setID(Integer.parseInt(cursor.getString(0)));
                data.setName(cursor.getString(1));
                data.setEmail(cursor.getString(2));//phone
                ///SET PHONE NUMBER OR EMAIL CHECK WHICH

                // Adding contact to list
                contactList.add(data);
            } while (cursor.moveToNext());
        }

        // returnS user list
        return contactList;
    }


    //Dialog to enter new creditor information
    public void addNewCreditorButton(View v){
       // final Dialog dialog = new Dialog(IOUList.this);
        dialog = new Dialog(IOUList.this);
        dialog.setTitle("New Creditor");
        dialog.setContentView(R.layout.new_creditor_layout);
        dialog.show();

        final Button cancel_new_creditor_button = (Button) dialog.findViewById(R.id.cancel_button);
        cancel_new_creditor_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        //New creditor information from the dialog
        creditor_name = (EditText) dialog.findViewById(R.id.creditor_name_input);
        creditor_phone = (EditText) dialog.findViewById(R.id.creditor_phone_input);
        creditor_email = (EditText) dialog.findViewById(R.id.creditor_email_input);


        save_new_creditor_button = (Button) dialog.findViewById(R.id.save_button);
        saveNewCreditor();



    }

    //save creditor information
    public void saveNewCreditor(){
        save_new_creditor_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent add_creditor_intent = new Intent(v.getContext(), DatabaseMethods.class);

                //DatabaseMethods.addNewCreditor(creditor_name,creditor_phone,creditor_email);
                String name = creditor_name.getText().toString();
                String phone = creditor_phone.getText().toString();
                String email = creditor_email.getText().toString();

                add_creditor_intent.putExtra("creditor_info", new String[]{name, phone, email});

                startService(add_creditor_intent);

                //code to return to an updated list
                dialog.cancel();
            }
        });
    }




    //CONTINUE WORKING ON THIS ONE
    public void creditorIOU(String name, Integer id){
        Toast.makeText(IOUList.this, "Intent here", Toast.LENGTH_SHORT).show();

    }

    //CHECK FOR FUNCTIONALITY
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }







}
