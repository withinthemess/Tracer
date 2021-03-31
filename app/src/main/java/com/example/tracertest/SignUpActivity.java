package com.example.tracertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;
import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    //re = register X
    TextInputEditText reEmailAddress, reFirstName, reLastName, rePassword;

    Button createAccountBtn;

    //Will use this object to auth user
    FirebaseAuth firebaseAuth;
    //After using the auth object we use this one to handle user activity
    FirebaseUser firebaseUser;

    //From firebase.database
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_sign_up);

        //Hide nav bar
        hideNavigationBar();


        //If someone is authenticated store him as a user
        firebaseAuth = FirebaseAuth.getInstance();

        //Makes a new branch called "Users" to store data in
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");



        reEmailAddress = findViewById(R.id.signUp_email);
        reFirstName = findViewById(R.id.signUp_firstName);
        reLastName = findViewById(R.id.signUp_lastName);
        rePassword = findViewById(R.id.signUp_password);
        createAccountBtn = findViewById(R.id.signUp_createAccountBtn);



    }


    public void createAccount (View view)
    {
        //Getting the text as char seq and making it into strings and trimming extra space and storing into variables
        //String fullName =  = reFirstName.getText().toString().trim().concat(reLastName.getText().toString().trim());

        String firstName = reFirstName.getText().toString().trim();
        String lastName = reLastName.getText().toString().trim();
        String password = rePassword.getText().toString().trim();
        String email = reEmailAddress.getText().toString().trim();

        //Creating the user with an email and a password
        //Attaching a lister to execute task if firebase registers the user successfully
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            //onComplete is executed if the firebase made a new user with the passed arguments (email, password)
            //It returns the a task variable to  let us know the status
            public void onComplete(@NonNull Task<AuthResult> task) {
                //If the task is successful that means this is a user now
                if(task.isSuccessful())
                {
                    //Store the person that just logged in as a user
                    firebaseUser = task.getResult().getUser();

                    //Now store the data we just collected as a new user
                    //Make a new branch of our "users" folder for each user and name it with their id
                    DatabaseReference newUser = databaseReference.child(firebaseUser.getUid());

                    //Store the user details in new different branches
                    newUser.child("First Name").setValue(firstName);
                    newUser.child("Last Name").setValue(lastName);
                    newUser.child("Email").setValue(email);
                    newUser.child("Password").setValue(password);

                    //Navigate to home screen
                    toHome();
                }
                else
                {
                    //If the task "making a new user" fails> show a toast with the reason
                    Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });



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

    private void toHome ()
    {
        Intent goToHome = new Intent (SignUpActivity.this, HomeActivity.class);
        startActivity(goToHome);
    }

}