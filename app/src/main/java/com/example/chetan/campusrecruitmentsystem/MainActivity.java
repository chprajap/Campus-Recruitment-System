package com.example.chetan.campusrecruitmentsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null)
        {
            // user is signed in
            // if user is admin take to admin page else student
            // page else company page
        }
        else
        {
            // no user is signed in
        }
    }

    public void goToLogin(View v)
    {
        Intent i = new Intent(this, login.class);
        startActivity(i);
        finish();
    }

    public void goToSignup(View v)
    {
        Intent i = new Intent(this, doSignUp.class);
        startActivity(i);
        finish();
    }

}
