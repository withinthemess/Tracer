package com.example.tracertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

    // creating a variable for
    // our Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our
    // Database Reference for Firebase.
    DatabaseReference databaseReference;

    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_home);

        userName = findViewById(R.id.home_userFirstName);

        // below line is used to get the instance
        // of our Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();



        //Hide the navigation bar
        hideNavigationBar();

    }



    //Hide navigation bar even after going out and coming back to the app
    @Override
    protected void onResume()
    {
        super.onResume();
        hideNavigationBar();
    }

    //Hide the navigation bar
    private void hideNavigationBar ()
    {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        );




    }


    //Start the account details activity
    public void toAccountDetails (View view)
    {
        Intent goToAccountDetails = new Intent(HomeActivity.this, AccountActivity.class);
        startActivity(goToAccountDetails);
    }

    public void toNavigation (View view)
    {
        Intent goToNavigation = new Intent(HomeActivity.this, NavigationActivity.class);
        startActivity(goToNavigation);
    }

    public void toAddContact (View view)
    {
        Intent goToAddContact = new Intent(HomeActivity.this, AddContactActivity.class);
        startActivity(goToAddContact);
    }

    public void toDeviceSettings (View view)
    {
        Intent goToDeviceSettings = new Intent(HomeActivity.this, DeviceSettingsActivity.class);
        startActivity(goToDeviceSettings);
    }



}