package com.example.fooddonation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button btnDonate, btnAvailableFood, btnNGO, btnNeedFood, btnNearestAshram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        btnDonate = findViewById(R.id.btnDonate);
        btnAvailableFood = findViewById(R.id.btnAvailableFood);
        btnNGO = findViewById(R.id.btnNGO);

        btnNearestAshram = findViewById(R.id.btnAshramPlaces);

        // Navigate to Donate Activity
        btnDonate.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, DonateActivity.class));
        });

        // Navigate to Available Food Activity
        btnAvailableFood.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AvailableFoodActivity.class));
        });

        // Navigate to NGO Activity
        btnNGO.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, NGOActivity.class));
        });

        // Navigate to Need Food Activity


        // Navigate to Nearest Ashram Activity
        btnNearestAshram.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, PlacesActivity.class));
        });
    }

    // Check if user is logged in
    @Override
    protected void onStart() {
        super.onStart();

        if(FirebaseAuth.getInstance().getCurrentUser() == null){
            // User not logged in, go to LoginActivity
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }
}
