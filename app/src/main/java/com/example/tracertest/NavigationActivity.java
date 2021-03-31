package com.example.tracertest;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;


public class NavigationActivity extends AppCompatActivity implements OnMapReadyCallback {

    //The initial location values/text
    String locationText = "Latitude: 00.00 \nLongitude: 00.00";

    //Taking the coordinates into global variable so they are accessible to all methods
    private double lat= 0, lng = 0;
    private String contactName = "contactName";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        //Hide nav bar
        hideNavigationBar();

        //Asking for SMS reading permission
        ActivityCompat.requestPermissions(NavigationActivity.this, new String[]{Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);


        //Read the latest SMS message and extract a location
        readSMS();

        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);


        //Asking for SMS reading permission
        ActivityCompat.requestPermissions(NavigationActivity.this, new String[]{Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);


    }

    //Read & parse the latest SMS for GPS coordinates (latitude / Longitude)
    //After finding the data, set global variables lat / lng to those values
    private void readSMS ()
    {
        //Go through the SMS inbox and read the latest message
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms"), null, null,null,null);
        cursor.moveToFirst();

        //Gets the full string
        locationText = cursor.getString(12);

        //Chop the string in half at the " , " and store those 2 halves in a strings array
        String[] locationVals = locationText.split("[,]", 0);

        //We know that the latitude was sent first so the first value in the array is that and the second value is the longitude
        String latitude = locationVals[0], longitude = locationVals[1] ;

        //Overwrite the old string value to the new one with the actual location from the sms
        locationText = "Latitude:"+ latitude +  "\nLongitude:"+ longitude;

        //Copying those values we got from the message to global variable to use them in other methods
        lat = Double.valueOf(latitude);
        lng = Double.valueOf(longitude);

        //Copy the contact name to a global variable



    }

/*
    //Open the location in via an intent in an external maps app
    public void openLocationInMap(View view)
    {
        //Go looking for an application that can open maps with those coordinates
        // "?z"  indicates the zoom level from 1(FAR) - 23(CLOSE)
        //geo:0,0?q=latitude,longitude >> this form makes it show a label/ marker
        Intent showLocationInMaps = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+lat+","+ lng+"(This is my location)"));
        //The emulator is not working with it, could be because it has limited access, resolve this !!!!!!!!!!!!!!!!
        showLocationInMaps.setData(Uri.parse("geo:0,0?q="+lat+","+ lng+"(This is my location)"));
        if (showLocationInMaps.resolveActivity(getPackageManager()) != null) {
            startActivity(showLocationInMaps);
        }
        else
        {
            Log.v("MAPS", "No handler found");
        }

    }
*/

    public void toHome (View view)
    {
        Intent goToHome = new Intent(NavigationActivity.this, HomeActivity.class);
        startActivity(goToHome);
    }




    //Hide the navigation bar
    private void hideNavigationBar ()
    {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        );
    }

    //Hide navigation bar even after going out and coming back to the app
    @Override
    protected void onResume()
    {
        super.onResume();
        hideNavigationBar();

    }

    //Pass the location we extracted on opening the navigation page into a map fragment

    @Override
    public void onMapReady(GoogleMap googleMap)
    {

        // Passing latitude and longitude into a Lating object
        LatLng emergencyLocation = new LatLng(lat, lng);

        //Pass the object with the zoom level (14) to the google map fragment
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(emergencyLocation,19));

        //Adding a marker on our emergency location and giving it a title
        googleMap.addMarker(new MarkerOptions()
                .position(emergencyLocation)
                .title(contactName + " Needs your help"));
    }

}








    





