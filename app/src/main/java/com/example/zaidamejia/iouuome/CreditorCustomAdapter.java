package com.example.zaidamejia.iouuome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zaidamejia on 9/15/15.
 */


public class CreditorCustomAdapter extends ArrayAdapter<String> {

    public CreditorCustomAdapter(Context context, String[] values){

        super(context, R.layout.creditor_row_layout, values);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // The LayoutInflater puts a layout into the right View
        LayoutInflater theInflater = LayoutInflater.from(getContext());

        // inflate takes the resource to load, the parent that the resource may be
        // loaded into and true or false if we are loading into a parent view.
        View theView = theInflater.inflate(R.layout.creditor_row_layout, parent, false);

        // We retrieve the text from the array
        String tvShow = getItem(position);

        // Get the TextView we want to edit
        TextView theTextView = (TextView) theView.findViewById(R.id.creditor_name_textView);

        // Put the next TV Show into the TextView
        theTextView.setText(tvShow);

        // Get the ImageView in the layout
        ImageView theImageView = (ImageView) theView.findViewById(R.id.myImage);

        // We can set a ImageView like this
        theImageView.setImageResource(R.drawable.noimage);

        return theView;

    }




}
