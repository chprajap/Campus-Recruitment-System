package com.example.chetan.campusrecruitmentsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StudentMainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_main);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser mUser = mAuth.getCurrentUser();
        if(mUser != null)
        {
            String name  = mUser.getDisplayName();
            String email = mUser.getEmail();
            String uid = mUser.getUid();

            TextView view = (TextView) findViewById(R.id.hi);
            view.setText("User's Full Name: "+ name + "\n User's Email Id: "+ email + "\n User's ID: "+uid);
        }
        else
        {
            TextView view = (TextView) findViewById(R.id.hi);
            view.setText("You are not logged in");
        }
    }
}
