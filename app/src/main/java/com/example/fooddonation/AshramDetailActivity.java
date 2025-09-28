package com.example.fooddonation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AshramDetailActivity extends AppCompatActivity {

    private TextView txtAshramName, txtAshramAddress, txtAshramContact, txtAshramPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ashram_detail);

        txtAshramName = findViewById(R.id.txtAshramName);
        txtAshramAddress = findViewById(R.id.txtAshramAddress);
        txtAshramContact = findViewById(R.id.txtAshramContact);
        txtAshramPeople = findViewById(R.id.txtAshramPeople);

        String ashramName = getIntent().getStringExtra("ashramName");

        switch (ashramName) {
            case "Punyadham Ashram":
                txtAshramName.setText("Punyadham Ashram");
                txtAshramAddress.setText("Survey No. 38/39, Pisoli, Off Somji Chowk, Kondhwa – Katraj Road, Pisoli P.O., Mohammadwadi, Pune – 411060, Maharashtra, India");
                txtAshramContact.setText("+919021937953");
                txtAshramPeople.setText("250 People");
                break;
            case "Apna Ghar Ashram":
                txtAshramName.setText("Apna Ghar Ashram");
                txtAshramAddress.setText("Apna Ghar Ashram, Near Dattawadi, Pune, Maharashtra 411030");
                txtAshramContact.setText(" +912024363150 / +912024362359");
                txtAshramPeople.setText("110 People");
                break;
            case "Anand Ashram":
                txtAshramName.setText("Anand Ashram");
                txtAshramAddress.setText("Ananda Ashram, 16/5, Ganesh Khind Road, Near University Circle, Pune – 411007");
                txtAshramContact.setText("+912025670247");
                txtAshramPeople.setText("95 People");
                break;
            case "Shree Dattguru Ashram":
                txtAshramName.setText("Shree Dattguru Ashram");
                txtAshramAddress.setText("Shri Guru Dattashram, Behind Narayan Peth, Pune, Maharashtra 411030");
                txtAshramContact.setText("+912024462754 /+912024463772");
                txtAshramPeople.setText("75 People");
                break;
            case "Prarthana Ashram":
                txtAshramName.setText("Prarthana Ashram");
                txtAshramAddress.setText("Sitabuldi, Nagpur");
                txtAshramContact.setText("9123456700");
                txtAshramPeople.setText("40 People");
                break;
            case "Shanti Ashram":
                txtAshramName.setText("Shanti Ashram");
                txtAshramAddress.setText("A50, Shanti Ashram Bus Depot, Jeevan Udhahar, LIC Colony, Borivali West, Mumbai – 400103");
                txtAshramContact.setText("07410995073");
                txtAshramPeople.setText("120 People");
                break;
            case "Apna Ghar Ashram Mumbai":
                txtAshramName.setText("Apna Ghar Ashram");
                txtAshramAddress.setText("S. No. 4/8/3, Ganesh Wadi, Kaman Bhiwandi Road, Chinchoti Naka, Vasai Virar, Mumbai");
                txtAshramContact.setText(" 8655866312");
                txtAshramPeople.setText("90 People");
                break;
            case "Seal Ashram":
                txtAshramName.setText("Seal Ashram");
                txtAshramAddress.setText("Vangani Village, New Panvel, Navi Mumbai - 410206");
                txtAshramContact.setText("09594969535");
                txtAshramPeople.setText("200 People");
                break;
            case "Immanuel Mercy Home Ashram":
                txtAshramName.setText("Immanuel Mercy Home Ashram");
                txtAshramAddress.setText("Khairwadi, Morbe Post, New Panvel, Navi Mumbai, Raigad, Maharashtra – 410206");
                txtAshramContact.setText("9876543211");
                txtAshramPeople.setText("55 People");
                break;
            case "Mata Amritanandamayi Math Ashram":
                txtAshramName.setText("Mata Amritanandamayi Math Ashram");
                txtAshramAddress.setText("G575+JJ9, Mata Amritanandamayi Marg, Shanti Kunj Main, Sector D, Vasant Kunj, New Delhi, Delhi 110070");
                txtAshramContact.setText("9876543211");
                txtAshramPeople.setText("70 People");
                break;
            case "Sri Aurobindo Ashram":
                txtAshramName.setText("Sri Aurobindo Ashram");
                txtAshramAddress.setText("Begumpur Road, Sarvodaya Enclave, New Delhi, Delhi 110016");
                txtAshramContact.setText("01126567863");
                txtAshramPeople.setText("90 People");
                break;
            case "Apna Ghar Ashram Delhi":
                txtAshramName.setText("Apna Ghar Ashram");
                txtAshramAddress.setText("Achnera Rd, Mod, Khemra, Charliganj, Rajasthan 321001");
                txtAshramContact.setText(" 8655866312");
                txtAshramPeople.setText("60 People");
                break;
            case "Malhar NGO":
                txtAshramName.setText("Malhar NGO");
                txtAshramAddress.setText("Malhar NGO, Nagpur, Maharashtra, India");
                txtAshramContact.setText("7259909787");
                txtAshramPeople.setText("90 People");
                break;
            case "Kalamanch Ashram":
                txtAshramName.setText("Kalamanch Ashram");
                txtAshramAddress.setText("Snehanchal Vedana Shaman Kendra, Nagpur, Maharashtra, India");
                txtAshramContact.setText("01126567863");
                txtAshramPeople.setText("30 People");
                break;
            case "Matru Sewa Sangh Ashram":
                txtAshramName.setText("Matru Sewa Sangh Ashram");
                txtAshramAddress.setText("Matru Sewa Sangh Ashram, Nagpur, Maharashtra, India");
                txtAshramContact.setText("1234567892");
                txtAshramPeople.setText("120 People");
                break;
            case "Annapurna Foundation Solapur":
                txtAshramName.setText("Annapurna Foundation Solapur");
                txtAshramAddress.setText("Annpurna 13 A Sahayadri Housing Society, Vikas Nagar, Hotgi, Road, Solapur, 413003");
                txtAshramContact.setText("099234 04583");
                txtAshramPeople.setText("210 People");
                break;
            case "Kalamanch Ashram Solapur":
                txtAshramName.setText("Kalamanch Ashram");
                txtAshramAddress.setText("Kalamanch Ashram Vikas Nagar, Hotgi, Road, Solapur, 413003\"");
                txtAshramContact.setText("7259909787");
                txtAshramPeople.setText("90 People");
                break;
            case "Matru Sewa Sangh Ashram Solapur":
                txtAshramName.setText("Matru Sewa Sangh Ashram");
                txtAshramAddress.setText("Matru Sewa Sangh Ashram, Nagpur, Maharashtra, India");
                txtAshramContact.setText("1234567892");
                txtAshramPeople.setText("120 People");
                break;
            default:
                txtAshramName.setText("No Ashram Found");
                txtAshramAddress.setText("-");
                txtAshramContact.setText("-");
                txtAshramPeople.setText("-");
        }
    }
}
