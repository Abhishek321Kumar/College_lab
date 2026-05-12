package com.example.mytourismapp;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String[] places = {"Bengaluru","Mysore","Kodagu","Shivagange","Tumkur","Jogfalls",
            "Agumbe","Chikkamagaluru","Badami","Talakaadu","Mangaluru","Udupi",
            "Bengaluru","Mysore","Kodagu","Shivagange","Tumkur","Jogfalls",
            "Agumbe","Chikkamagaluru","Badami","Talakaadu","Mangaluru","Udupi",
            "Bengaluru","Mysore","Kodagu","Shivagange","Tumkur","Jogfalls",
            "Agumbe","Chikkamagaluru","Badami","Talakaadu","Mangaluru","Udupi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView listView = (ListView) findViewById(R.id.Listview1);
        Adapter  Adapter = new ArrayAdapter<String>(this,R.layout.activitytext, places);
        listView.setAdapter((ListAdapter) Adapter);
    }
}