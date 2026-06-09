package com.example.program_6;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
   FusedLocationProviderClient fusedLocationProviderClient;
   TextView latitude, longitude, address, city, country;
   Button getLocation;
   private final static int REQUEST_CODE = 100;

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
         latitude = findViewById(R.id.latitude);
         longitude = findViewById(R.id.longitude);
         address=findViewById(R.id.address);
         city = findViewById(R.id.city);
         country = findViewById(R.id.country);
         getLocation = findViewById(R.id.getLocation);

         fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

         getLocation.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 getLastLocation();
             }
         });

    }


    private void getLastLocation(){
        if(ContextCompat.checkSelfPermission(this,
                ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if(location!=null){
                        Log.d("Location","Latitude" + location.getLatitude()) ;
                        Log.d("Location","Longitude" + location.getLongitude()) ;


                        try{
                            Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                            latitude.setText("Latitude:"+ addresses.get(0).getLatitude());
                            longitude.setText("Longitude:"+ addresses.get(0).getLongitude());
                            address.setText("Address:"+ addresses.get(0).getAddressLine(0));
                            city.setText("City:"+ addresses.get(0).getLocality());
                            country.setText("Country:"+ addresses.get(0).getCountryName());

                            Log.d("Location","Addresses" + addresses.toString()) ;
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        else{
            Toast.makeText(MainActivity.this, "Location not Found", Toast.LENGTH_SHORT).show();
        }
    }
}