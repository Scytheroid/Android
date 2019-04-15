package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class OurAdapter extends ArrayAdapter {

    private final ArrayList<Animal> animals;
    private final Activity activity;

    public OurAdapter(Activity activity, ArrayList<Animal> animals) {
        super(activity, R.layout.list_item, animals);
        this.activity = activity;
        this.animals = animals;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);

        //ziskame si reference na views v xml
        TextView title = rowView.findViewById(R.id.title);
        TextView info = rowView.findViewById(R.id.info);
        ImageView image = rowView.findViewById(R.id.image);

        //nastavime do nich data z listu
        title.setText(animals.get(position).name);
        info.setText(animals.get(position).info);
        image.setImageResource(animals.get(position).image);

        return rowView;
    }
}
