package com.example.fooddonation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class PlacesActivity extends AppCompatActivity {

    private ListView listPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        listPlaces = findViewById(R.id.listPlaces);

        String[] places = {"Pune","Mumbai", "Nagpur", "Delhi","Solapur"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, places);
        listPlaces.setAdapter(adapter);

        listPlaces.setOnItemClickListener((parent, view, position, id) -> {
            String selectedPlace = places[position];
            Intent intent = new Intent(PlacesActivity.this, AshramListActivity.class);
            intent.putExtra("place", selectedPlace);
            startActivity(intent);
        });
    }
}
