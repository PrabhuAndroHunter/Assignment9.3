package com.assignment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by prabhu on 17/1/18.
 */

public class MyListAdapter extends ArrayAdapter<String> {

    //declaring variables
    private final Activity context;
    private final String[] name;
    private final String[] number;

    /**
     * and in creating a constructor of MyListAdapter and passing requirements values
     * and in super class passing context, list_view layout xml and name
     */
    public MyListAdapter(Activity context, String[] name, String[] number) {
        super(context, R.layout.item_contact,name);
        // initializing the values
        this.context = context;
        this.name = name;
        this.number = number;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // using LayoutInflater to fill layouts
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_contact,null,true);
        TextView txtName= rowView.findViewById(R.id.textView_name);
        TextView txtContacts= rowView.findViewById(R.id.textView_number);
        txtName.setText(name[position]);//sets name position
        txtContacts.setText(number[position]);//sets number position
        return rowView;//returns rowView
    }
}