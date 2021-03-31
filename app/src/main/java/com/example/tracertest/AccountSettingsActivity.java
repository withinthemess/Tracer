package com.example.tracertest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AccountSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

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

    public void toChangeEmail (View view)
    {
        Intent goToChangeEmail = new Intent (AccountSettingsActivity.this, ChangeEmailActivity.class);
        startActivity(goToChangeEmail);
    }

    public void toChangePassword (View view)
    {
        Intent goToChangePassword = new Intent(AccountSettingsActivity.this, ChangePasswordActivity.class);
        startActivity(goToChangePassword);
    }



}
