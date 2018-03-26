package com.example.chetan.campusrecruitmentsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ApplyForJobsNavBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private EditText mname;
    private EditText memailId;
    private EditText mcontactno;
    private EditText mgrade;
    private EditText mskill;
    private EditText maddress;
    private Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_for_jobs_nav_bar);

        mAuth = FirebaseAuth.getInstance();

        ScrollView mscrollView = (ScrollView) findViewById(R.id.apply_for_jobs_scroll_id);
        mname = (EditText) findViewById(R.id.student_name);
        memailId = (EditText) findViewById(R.id.student_email);
        mcontactno = (EditText) findViewById(R.id.student_contact);
        mgrade = (EditText) findViewById(R.id.student_grade);
        mskill = (EditText) findViewById(R.id.student_skill);
        maddress = (EditText) findViewById(R.id.student_address);
        mbutton = (Button) findViewById(R.id.apply_for_jobs_button_id);

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
        onStart();
    }

    @Override
    protected void onStart() {
        super.onStart();

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference().child("Student").child(mAuth.getCurrentUser().getUid()).child("Application");
                myRef.child("Student Name").setValue(mname.getText().toString());
                myRef.child("Student EmailId").setValue(memailId.getText().toString());
                myRef.child("Student Contact No").setValue(mcontactno.getText().toString());
                myRef.child("Student Grade").setValue(mgrade.getText().toString());
                myRef.child("Student Skill").setValue(mskill.getText().toString());
                myRef.child("Student Address").setValue(maddress.getText().toString());

                startActivity(new Intent(getApplicationContext(),NavBarActivity.class));

            }
        });
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
        getMenuInflater().inflate(R.menu.apply_for_jobs_nav_bar, menu);
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
            mAuth.signOut();
            startActivity(new Intent(ApplyForJobsNavBar.this, login.class));
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
            startActivity(new Intent(getApplicationContext(),NavBarActivity.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            startActivity(new Intent(ApplyForJobsNavBar.this,ApplyForJobsNavBar.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(ApplyForJobsNavBar.this,ViewJobStatusNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(ApplyForJobsNavBar.this,SearchJobsNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;

        } else if (id == R.id.nav_manage) {
            startActivity(new Intent(ApplyForJobsNavBar.this,UpdateDetailsNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;

        } else if (id == R.id.nav_password) {
            startActivity(new Intent(ApplyForJobsNavBar.this,ChangePasswordNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}