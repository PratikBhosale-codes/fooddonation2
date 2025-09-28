package com.example.fooddonation;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AvailableFoodActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<FoodModel> foodModels;
    private ArrayList<String> displayList;
    private ArrayAdapter<String> adapter;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_food);

        listView = findViewById(R.id.listAvailableFood);
        foodModels = new ArrayList<>();
        displayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.item_food, R.id.textItem, displayList);

        listView.setAdapter(adapter);

        dbRef = FirebaseDatabase.getInstance().getReference("AvailableFood");

        // Listen for data changes
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override public void onDataChange(@NonNull DataSnapshot snapshot) {
                foodModels.clear();
                displayList.clear();

                for (DataSnapshot child : snapshot.getChildren()) {
                    FoodModel model = child.getValue(FoodModel.class);
                    if (model == null) continue;

                    foodModels.add(model);

                    // Use the getters that match your FoodModel
                    String foodName = model.getFoodItem() != null ? model.getFoodItem() : "Unknown item";
                    String Name = model.getName() != null ? model.getName() : "Unknown item";
                    int qty = model.getQuantity();
                    String pickup = model.getPickupAddress() != null ? model.getPickupAddress() : "No address";

                    displayList.add(foodName + " (" + qty + ") - " + pickup);
                }

                adapter.notifyDataSetChanged();
            }

            @Override public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AvailableFoodActivity.this, "Failed to load data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Show details when an item is clicked
        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (position >= 0 && position < foodModels.size()) {
                FoodModel m = foodModels.get(position);
                String msg = "Food: " + safe(m.getFoodItem())
                        + "\nQuantity: " + m.getQuantity()
                        +"\nName : " +m.getName()
                        +"\nMob no "+m.getMob_no()
                        + "\nPickup Address: " + safe(m.getPickupAddress())
                        + "\nPickup Date: "+ safe(m.getPickupTime())
                        + "\nPickup time: " + safe(m.getPickupDate())
                        ;
                new AlertDialog.Builder(AvailableFoodActivity.this)
                        .setTitle("Details")
                        .setMessage(msg)
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }

    // small helper to avoid NPE display
    private String safe(String s) {
        return s == null || s.isEmpty() ? "N/A" : s;
    }
}
