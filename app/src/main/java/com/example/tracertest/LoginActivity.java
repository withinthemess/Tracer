package com.example.tracertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    //lo = login X
    TextInputEditText loEmailAddress, loPassword;
    TextInputLayout passwordBox, emailBox;
    Button loginBtn;

    //Will use this object to auth user
    FirebaseAuth firebaseAuth;
    //After using the auth object we use this one to handle user activity
    FirebaseUser firebaseUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_login);



        //Hide the navigation bar
        hideNavigationBar();

        passwordBox = findViewById(R.id.login_passwordOutlinedTextField);
        loEmailAddress = findViewById(R.id.login_email);
        loPassword = findViewById(R.id.login_password);
        firebaseAuth = FirebaseAuth.getInstance();
        loginBtn = findViewById(R.id.login_loginButton);
    }


    public void login (View view)
    {
        //Extract our strings
        String email = loEmailAddress.getText().toString().trim();
        String password = loPassword.getText().toString().trim();

        //If both fields are filled
        if (!email.isEmpty() && !password.isEmpty())
        {
            //Send a login request
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    //If login credentials are correct
                    if (task.isSuccessful())
                    {
                        //Go to home page
                        toHome();
                    }
                    //If login credentials are NOT correct
                    else
                    {
                        //Show this toast if the credentials are not in our database
                        Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        //Make the password container flamingo pink
                        passwordBox.setBoxStrokeErrorColor(ColorStateList.valueOf(getResources().getColor(R.color.flamingo)));

                        //Make hint text flamingo pink
                        passwordBox.setErrorTextColor(ColorStateList.valueOf(getResources().getColor(R.color.flamingo)));

                        //Show hint text
                        passwordBox.setError("Wrong email or password");
                    }
                }
            });
        }
    }


    public void toHome ()
    {
        Intent goToHome = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(goToHome);
    }

    public void toSignUp (View view)
    {
        Intent goToSignUp = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(goToSignUp);
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

}