package com.example.android.campusrecruitmentsystem;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.android.campusrecruitmentsystem.R;
import com.example.android.campusrecruitmentsystem.login;
import com.google.firebase.auth.FirebaseAuth;

public class updateDetails extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatestudentdetails);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.logout:
                mAuth.signOut();
                startActivity(new Intent(updateDetails.this, login.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
