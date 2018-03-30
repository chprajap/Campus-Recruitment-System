package com.example.chetan.campusrecruitmentsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import java.util.ArrayList;

public class AdminNavBarActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*private FirebaseAuth mAuth;
    private DatabaseReference myRef;
*/
    private String emailIdFromOtherClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_nav_bar);

        /*mAuth = FirebaseAuth.getInstance();
        myRef= FirebaseDatabase.getInstance().getReference().child("Admin").child(mAuth.getCurrentUser().getUid());

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TextView hi = (TextView) findViewById(R.id.hi_admin);
                String justTry = "Admin Name: " + dataSnapshot.child("Admin Name").getValue().toString() + "\nAdmin Id: " + dataSnapshot.child("Admin Id").getValue().toString() + "\nEmail Id: " + dataSnapshot.child("Email Id").getValue().toString() + "\nContact No: " + dataSnapshot.child("Contact No").getValue().toString() + "\nAddress: " + dataSnapshot.child("Address").getValue().toString() ;
                //view.setText("hello crp");
                hi.setText(justTry);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/

        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        Log.d("hello","hi");
      //  Log.d("hello",emailIdFromOtherClass);
        DatabaseHelperAdmin helper = new DatabaseHelperAdmin(AdminNavBarActivity.this);
        ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);
        Log.v("hi",list.get(1));
        TextView hi = (TextView) findViewById(R.id.hi_admin);
        String justTry = " * * * * * Admin Information * * * * *\n\n"+"  Admin Name: " + list.get(1)+ "\n  Admin Id: " + list.get(3)+ "\n  Email Id: " + list.get(4)+ "\n  Contact No: " + list.get(5)+ "\n  Address: " + list.get(7);
        //view.setText("hello crp");
        hi.setTextSize(18);
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
        getMenuInflater().inflate(R.menu.admin_nav_bar, menu);
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
          //  mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), loginAdmin.class));
            finish();
            return true;
        }

        else if(id==R.id.help)
        {
            startActivity(new Intent(getApplicationContext(),adminHelp.class));
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
        if(id==R.id.admin_home){
            Intent i = new Intent(AdminNavBarActivity.this,AdminNavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            /*startActivity(new Intent(getApplicationContext(),AdminNavBarActivity.class));
            *///finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
//            startActivity(new Intent(getApplicationContext(),ManageStudentActivity.class));
            Intent i = new Intent(AdminNavBarActivity.this,ManageStudentActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            //startActivity(new Intent(getApplicationContext(),ManageCompany.class));
            Intent i = new Intent(AdminNavBarActivity.this,ManageCompany.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            //startActivity(new Intent(getApplicationContext(),AdminUpdateDetails.class));

            Intent i = new Intent(AdminNavBarActivity.this,AdminUpdateDetails.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_manage) {
            /*startActivity(new Intent(getApplicationContext(),AdminChangePasswordNavBar.class));*/

            Intent i = new Intent(AdminNavBarActivity.this,AdminChangePasswordNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
