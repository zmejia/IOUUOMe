package com.example.zaidamejia.iouuome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;


public class CreditorCustomAdapter extends ArrayAdapter<EntryData> {

    public CreditorCustomAdapter(Context context, List<EntryData> values){

        super(context, R.layout.creditor_row_layout, values);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // The LayoutInflater puts a layout into the right View
        LayoutInflater theInflater = LayoutInflater.from(getContext());

        // inflate takes the resource to load, the parent that the resource may be
        // loaded into and true or false if we are loading into a parent view.
        convertView = (RelativeLayout) theInflater.inflate(R.layout.creditor_row_layout, null);

        // We retrieve the text from the array
        EntryData entryInfo = (EntryData) getItem(position);

        // Get the TextView we want to edit
        TextView description = (TextView) convertView.findViewById(R.id.description);

        // Put the next description into the TextView
        description.setText(entryInfo.getDescription());

        // Get the TextView we want to edit
        TextView date = (TextView) convertView.findViewById(R.id.date);

        // Put the next date into the TextView
        date.setText(entryInfo.getDate());

        // Get the TextView we want to edit
        TextView total = (TextView) convertView.findViewById(R.id.totalOwed);

        // Put the next total into the TextView
        total.setText(entryInfo.getTotal());


        return convertView;

    }
}
