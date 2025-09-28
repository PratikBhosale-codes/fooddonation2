package com.example.fooddonation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class AshramListActivity extends AppCompatActivity {

    private ListView listAshrams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ashram_list);

        listAshrams = findViewById(R.id.listAshrams);

        String place = getIntent().getStringExtra("place");

        String[] ashrams;

        switch (place) {
            case "Pune":
                ashrams = new String[]{"Punyadham Ashram", "Apna Ghar Ashram", "Anand Ashram","Shree Dattguru Ashram","Prarthana Ashram" };
                break;
            case "Mumbai":
                ashrams = new String[]{"Shanti Ashram", "Apna Ghar Ashram","Seal Ashram","Immanuel Mercy Home Ashram"};
                break;
            case "Delhi":
                ashrams = new String[]{"Mata Amritanandamayi Math Ashram", "Sri Aurobindo Ashram", "Apna Ghar Ashram"};
                break;
            case "Nagpur":
                ashrams = new String[]{"Malhar NGO", "Kalamanch Ashram", "Matru Sewa Sangh Ashram"};
                break;
            case "Solapur":
                ashrams = new String[]{"Annapurna Foundation Solapur", "Kalamanch Ashram", "Matru Sewa Sangh Ashram"};
                break;

            default:
                ashrams = new String[]{"No Ashram Found"};
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, ashrams);
        listAshrams.setAdapter(adapter);

        listAshrams.setOnItemClickListener((parent, view, position, id) -> {
            String selectedAshram = ashrams[position];
            Intent intent = new Intent(AshramListActivity.this, AshramDetailActivity.class);
            intent.putExtra("ashramName", selectedAshram);
            startActivity(intent);
        });
    }
}
