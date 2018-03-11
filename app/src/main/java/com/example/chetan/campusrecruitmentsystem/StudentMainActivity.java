package com.example.chetan.campusrecruitmentsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentMainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_main);
        mAuth = FirebaseAuth.getInstance();
        myRef= FirebaseDatabase.getInstance().getReference().child("users").child(mAuth.getCurrentUser().getUid());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
                TextView view = (TextView) findViewById(R.id.hi);
                view.setText("Full Name: " + dataSnapshot.child("Full Name").getValue().toString() +
                        "\nUserName: " + dataSnapshot.child("UserName").getValue().toString() +
                        "\nUser Id: " + dataSnapshot.child("User Id").getValue().toString() +
                        "\nEmail Id: " + dataSnapshot.child("Email Id").getValue().toString() +
                        "\nContact No: " + dataSnapshot.child("Contact No").getValue().toString() +
                        "\nAddress: " + dataSnapshot.child("Address").getValue().toString() +
                        "\nHSC: " + dataSnapshot.child("HSC").getValue().toString() +
                        "\nSSC: " + dataSnapshot.child("SSC").getValue().toString() );
                //view.setText("UserName: " + dataSnapshot.child("UserName").getValue().toString() );
                //view.setText("User Id: " + dataSnapshot.child("User Id").getValue().toString() );
                //view.setText("Email Id: " + dataSnapshot.child("Email Id").getValue().toString() );
                /*view.setText("Contact No: " + dataSnapshot.child("Contact No").getValue().toString() );
                view.setText("Address: " + dataSnapshot.child("Address").getValue().toString() );
                view.setText("HSC: " + dataSnapshot.child("HSC").getValue().toString() );
                view.setText("SSC: " + dataSnapshot.child("SSC").getValue().toString() );*/
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
  //      TextView view = (TextView) findViewById(R.id.hi);
//        view.setText("hello");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.logout:
                mAuth.signOut();
                startActivity(new Intent(StudentMainActivity.this, login.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        FirebaseUser mUser = mAuth.getCurrentUser();
        if(mUser != null)
        {
            *//*String name  = mUser.getDisplayName();
            String email = mUser.getEmail();
            String uid = mUser.getUid();*//*



            TextView view = (TextView) findViewById(R.id.hi);
            view.setText("User's Full Name: "+ name + "\n User's Email Id: "+ email + "\n User's ID: "+uid);
        }
        else
        {
            *//*TextView view = (TextView) findViewById(R.id.hi);
            view.setText("You are not logged in");*//*
            Toast.makeText(StudentMainActivity.this,"You are not logged in",Toast.LENGTH_LONG);
            startActivity(new Intent(StudentMainActivity.this, login.class));
            finish();
        }
    }*/
}
