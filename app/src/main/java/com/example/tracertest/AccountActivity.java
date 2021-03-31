package com.example.tracertest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {

    Button logOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

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


    public void toPersonal(View view)
    {
        Intent goToPersonal = new Intent(AccountActivity.this, PersonalActivity.class);
        startActivity(goToPersonal);
    }

    public void toAccountSettings (View view)
    {
        Intent goToAccountSettings = new Intent(AccountActivity.this, AccountSettingsActivity.class);
        startActivity(goToAccountSettings);
    }

    public void toLogin (View view)
    {
        Intent goToLogin = new Intent (AccountActivity.this, LoginActivity.class);
        startActivity(goToLogin);
    }


}

