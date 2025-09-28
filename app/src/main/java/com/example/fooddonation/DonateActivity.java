package com.example.fooddonation;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class DonateActivity extends AppCompatActivity {

    private EditText editPickup, editFoodItem, editDate,editTime,editDonatename,editdonateno;
    private TextView txtQuantity;
    private SeekBar seekQuantity;

    private Button btnSubmit;
    private int selectedQuantity = 0;

    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate); // ensure activity_donate.xml exists

        // Init views
        editPickup = findViewById(R.id.editPickup);
        editFoodItem = findViewById(R.id.editFoodItem);
        editDate = findViewById(R.id.editPickupDate);
        editTime = findViewById(R.id.editPickupTime);
        txtQuantity = findViewById(R.id.txtQuantity);
        seekQuantity = findViewById(R.id.seekQuantity);
        btnSubmit = findViewById(R.id.btnSubmit);
        editdonateno=findViewById(R.id.editdonateno);
        editDonatename=findViewById(R.id.editDonatename);

        editDate.setOnClickListener(v -> {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePicker = new DatePickerDialog(this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        editDate.setText(date);
                    }, year, month, day);
            datePicker.show();
        });


        editTime.setOnClickListener(v -> {
            final Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePicker = new TimePickerDialog(this,
                    (view, selectedHour, selectedMinute) -> {
                        String time = String.format("%02d:%02d", selectedHour, selectedMinute);
                        editTime.setText(time);
                    }, hour, minute, true); // true = 24-hour format
            timePicker.show();
        });

        // Firebase DB ref under node "AvailableFood"
        dbRef = FirebaseDatabase.getInstance().getReference("AvailableFood");

        seekQuantity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                selectedQuantity = progress;
                txtQuantity.setText("Quantity: " + selectedQuantity +"kg");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        btnSubmit.setOnClickListener(v -> {
            String Name = editDonatename.getText().toString().trim();
            String Mob_no = editdonateno.getText().toString().trim();
            String pickup = editPickup.getText().toString().trim();
            String food = editFoodItem.getText().toString().trim();
            String dateTime = editTime.getText().toString().trim();
            String dateDate = editDate.getText().toString().trim();

            if (pickup.isEmpty() || food.isEmpty() || Name.isEmpty()||Mob_no.isEmpty()||dateTime.isEmpty() || selectedQuantity == 0) {
                Toast.makeText(DonateActivity.this, "Please fill all fields and set quantity", Toast.LENGTH_SHORT).show();
                return;
            }

            // push new item
            String id = dbRef.push().getKey();
            if (id == null) {
                Toast.makeText(DonateActivity.this, "Error creating entry ID", Toast.LENGTH_SHORT).show();
                return;
            }

            // FoodModel without donorName
            FoodModel foodModel = new FoodModel(id, Name,Mob_no,pickup, food, dateTime,dateDate,selectedQuantity);

            dbRef.child(id).setValue(foodModel)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(DonateActivity.this, "Food posted successfully", Toast.LENGTH_SHORT).show();
                            // clear fields
                            editDonatename.setText("");
                            editdonateno.setText("");
                            editPickup.setText("");
                            editFoodItem.setText("");
                            editDate.setText("");
                            editTime.setText("");
                            seekQuantity.setProgress(0);
                        } else {
                            Toast.makeText(DonateActivity.this, "Failed to post: " + task.getException(), Toast.LENGTH_LONG).show();
                        }
                    });
        });
    }
}
