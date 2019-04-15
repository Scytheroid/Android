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
        animals.add(new Animal(R.drawable.alligator,"Aligator","A lot of Jaws", "100%"));
        animals.add(new Animal(R.drawable.bear,"Bear","Quite dangerous to see", "13%"));
        animals.add(new Animal(R.drawable.bug,"bug","Very spicy", "80%"));
        animals.add(new Animal(R.drawable.butterfly,"buterfly","Super movie", "60%"));
        animals.add(new Animal(R.drawable.snail,"snail","Pain to watch", "15%"));

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
