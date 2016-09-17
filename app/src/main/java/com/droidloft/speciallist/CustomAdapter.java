package com.droidloft.speciallist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DroidLoft2 on 9/17/2016.
 */
public class CustomAdapter extends BaseAdapter {

    Context mContext;
    private  final ArrayList<String> myTime;
    private final ArrayList<String> myText;


    public CustomAdapter(Context mContext, ArrayList<String> myTime, ArrayList<String> myText) {
        this.mContext = mContext;
        this.myTime = myTime;
        this.myText = myText;

    }


    @Override
    public int getCount() {
        return myText.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View arg1, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_item, viewGroup, false);

        TextView theText = (TextView) row.findViewById(R.id.my_text);
        TextView theTime = (TextView) row.findViewById(R.id.my_time);

        theText.setText(myText.get(position));
        theTime.setText(myTime.get(position));


        return row;
    }

    

}
