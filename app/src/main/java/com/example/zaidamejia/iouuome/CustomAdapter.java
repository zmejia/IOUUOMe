package com.example.zaidamejia.iouuome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by zaidamejia on 7/31/15.
 */
public class CustomAdapter extends ArrayAdapter<UserData> {

    public CustomAdapter(Context context, List<UserData> values){

        super(context, R.layout.iou_row_layout, values);

        }



@Override
public View getView(int position, View convertView, ViewGroup parent) {

        // The LayoutInflater puts a layout into the right View
        LayoutInflater theInflater = LayoutInflater.from(getContext());

        // inflate takes the resource to load, the parent that the resource may be
        // loaded into and true or false if we are loading into a parent view.
        convertView = (RelativeLayout) theInflater.inflate(R.layout.iou_row_layout, null);

        // We retrieve the text from the array
        UserData userInfo = (UserData) getItem(position);

        // Get the TextView we want to edit
        TextView theTextView = (TextView) convertView.findViewById(R.id.creditor_name_textView);

        // Put the next creditor name into the TextView
        theTextView.setText(userInfo.getName());

        // Get the ImageView in the layout
        ImageView theImageView = (ImageView) convertView.findViewById(R.id.myImage);

        // We can set a ImageView like this
        theImageView.setImageResource(R.drawable.zaida);

        return convertView;

        }




}
