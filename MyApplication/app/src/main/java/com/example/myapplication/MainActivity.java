package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Animal> animals;
    public static String animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animals = new ArrayList<>();
        animals.add(new Animal(R.drawable.alligator,"Aligator","bla bla1"));
        animals.add(new Animal(R.drawable.bear,"Bear","bla bla2"));
        animals.add(new Animal(R.drawable.bug,"bug","bla bla3"));
        animals.add(new Animal(R.drawable.butterfly,"buterfly","bla bla4"));
        animals.add(new Animal(R.drawable.snail,"snail","bla bla5"));

        OurAdapter adapter = new OurAdapter(this, animals);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Animal a = animals.get(position);
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                i.putExtra(animal, a);
                startActivity(i);
            }

        });

    }
}
