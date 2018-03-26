package com.example.chetan.campusrecruitmentsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.AppLaunchChecker;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NavBarActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

   /* private FirebaseAuth mAuth;
    private DatabaseReference myRef;
*/
   private String emailIdFromOtherClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);
    /*    mAuth = FirebaseAuth.getInstance();
        myRef= FirebaseDatabase.getInstance().getReference().child("Student").child(mAuth.getCurrentUser().getUid()).child("Profile");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TextView hi = (TextView) findViewById(R.id.hi);
                 String justTry = "Full Name: " + dataSnapshot.child("Full Name").getValue().toString() + "\nUserName: " + dataSnapshot.child("UserName").getValue().toString() + "\nUser Id: " + dataSnapshot.child("User Id").getValue().toString() + "\nEmail Id: " + dataSnapshot.child("Email Id").getValue().toString() + "\nContact No: " + dataSnapshot.child("Contact No").getValue().toString() + "\nAddress: " + dataSnapshot.child("Address").getValue().toString() + "\nHSC: " + dataSnapshot.child("HSC").getValue().toString() + "\nSSC: " + dataSnapshot.child("SSC").getValue().toString();
                //view.setText("hello crp");
                hi.setText(justTry);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(NavBarActivity.this);
/*        emailIdFromOtherClass = preferences.getString("EmailId","hello");*/
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        Log.d("hello","hi");
        Log.d("hello",emailIdFromOtherClass);
        DatabaseHelper helper = new DatabaseHelper(NavBarActivity.this);
        ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);
        Log.v("hi",list.get(1));
        TextView hi = (TextView) findViewById(R.id.hi);

        /*String justTry = list.get(0);
        justTry+=list.get(1);
        justTry+=list.get(2);
        justTry+=list.get(3);
        justTry+=list.get(4);
        justTry+=list.get(5);
        justTry+=list.get(6);
        justTry+=list.get(7);
        justTry+=list.get(8);
        justTry+=list.get(9);
        hi.setText(justTry);
*/
        String justTry = "Full Name: " + list.get(1)+ "\nUserName: " + list.get(2)+ "\nUser Id: " + list.get(3)+ "\nEmail Id: " + list.get(4)+ "\nContact No: " + list.get(5)+ "\nAddress: " + list.get(7)+ "\nHSC: " + list.get(8)+ "\nSSC: " + list.get(9);
        //view.setText("hello crp");
        hi.setText(justTry);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
        //    mAuth.signOut();
            startActivity(new Intent(NavBarActivity.this, login.class));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        int id = item.getItemId();

        if (id == R.id.student_home )
        {
            Intent i = new Intent(NavBarActivity.this,NavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
            /*startActivity(new Intent(NavBarActivity.this,ApplyForJobsNavBar.class));*/
            Intent i = new Intent(NavBarActivity.this,ApplyForJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            /*startActivity(new Intent(NavBarActivity.this,ViewJobStatusNavBar.class));*/
            Intent i = new Intent(NavBarActivity.this,ViewJobStatusNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            /*startActivity(new Intent(NavBarActivity.this,SearchJobsNavBar.class));*/
            Intent i = new Intent(NavBarActivity.this,SearchJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_manage) {
            /*startActivity(new Intent(NavBarActivity.this,UpdateDetailsNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;*/
            Intent i = new Intent(NavBarActivity.this,UpdateDetailsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_password) {
            /*startActivity(new Intent(NavBarActivity.this,ChangePasswordNavBar.class));*/
            Intent i = new Intent(NavBarActivity.this,ChangePasswordNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
