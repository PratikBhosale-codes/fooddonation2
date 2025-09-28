package com.example.fooddonation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NGOActivity extends AppCompatActivity {

    private EditText editNgoName, editAgentName, editContact, editFoodItems;
    private TextView txtQuantity;
    private SeekBar seekQuantity;
    private Button btnNgoSubmit;

    private int selectedQuantity = 0;

    // Firebase reference
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo);

        // Initialize views
        editNgoName = findViewById(R.id.editNgoName);
        editAgentName = findViewById(R.id.editAgentName);
        editContact = findViewById(R.id.editContact);
        editFoodItems = findViewById(R.id.editFoodItems);
        txtQuantity = findViewById(R.id.txtQuantity);
        seekQuantity = findViewById(R.id.seekQuantity);
        btnNgoSubmit = findViewById(R.id.btnNgoSubmit);

        // Firebase DB ref under node "NGORequests"
        dbRef = FirebaseDatabase.getInstance().getReference("NGORequests");

        // SeekBar listener
        seekQuantity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                selectedQuantity = progress;
                txtQuantity.setText("Quantity: " + selectedQuantity);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        // Submit button listener
        btnNgoSubmit.setOnClickListener(v -> {
            String ngoName = editNgoName.getText().toString().trim();
            String agentName = editAgentName.getText().toString().trim();
            String contact = editContact.getText().toString().trim();
            String foodItems = editFoodItems.getText().toString().trim();

            if (ngoName.isEmpty() || agentName.isEmpty() || contact.isEmpty() || foodItems.isEmpty() || selectedQuantity == 0) {
                Toast.makeText(NGOActivity.this, "Please fill all fields and set quantity!", Toast.LENGTH_SHORT).show();
            } else {
                // Generate unique id
                String id = dbRef.push().getKey();

                // Create model object
                NGOModel model = new NGOModel(id, ngoName, agentName, contact, foodItems, selectedQuantity);

                // Save to Firebase
                dbRef.child(id).setValue(model).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(NGOActivity.this, "NGO Data Submitted Successfully!", Toast.LENGTH_LONG).show();

                        // clear fields
                        editNgoName.setText("");
                        editAgentName.setText("");
                        editContact.setText("");
                        editFoodItems.setText("");
                        seekQuantity.setProgress(0);
                    } else {
                        Toast.makeText(NGOActivity.this, "Error: " + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    // ✅ Inner Model Class
    public static class NGOModel {
        private String id;
        private String ngoName;
        private String agentName;
        private String contact;
        private String foodItems;
        private int quantity;

        public NGOModel() {
            // required empty constructor
        }

        public NGOModel(String id, String ngoName, String agentName, String contact, String foodItems, int quantity) {
            this.id = id;
            this.ngoName = ngoName;
            this.agentName = agentName;
            this.contact = contact;
            this.foodItems = foodItems;
            this.quantity = quantity;
        }

        public String getId() { return id; }
        public String getNgoName() { return ngoName; }
        public String getAgentName() { return agentName; }
        public String getContact() { return contact; }
        public String getFoodItems() { return foodItems; }
        public int getQuantity() { return quantity; }
    }
}
