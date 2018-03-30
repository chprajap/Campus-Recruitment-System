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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminUpdateDetails extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*private FirebaseAuth mAuth;
    private DatabaseReference rootRef;
    private DatabaseReference userRef;*/
    private EditText mfullName;
    private EditText mUserId;
    private EditText mRank;
    private EditText mEmailId;
    private EditText mContactNo;
    private EditText mAddress;
    private Button mButton;
    private String mhint;
    private String mhint1;
    private String mhint2;
    private String mhint3;
    private String mhint4;
    private String mhint5;
    private String emailIdFromOtherClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_details);

       /* mAuth = FirebaseAuth.getInstance();
        rootRef= FirebaseDatabase.getInstance().getReference().child("Admin");
*/
        ScrollView mscrollView = (ScrollView) findViewById(R.id.update_admin_details_scroll_id);

  /*      rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(mAuth.getCurrentUser().getUid()))
                {
                    mhint = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Admin Name").getValue().toString();
                    mfullName = (EditText) findViewById(R.id.AdminFullName);
                    mfullName.setText(mhint);

                    mhint1 = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Admin Id").getValue().toString();
                    mUserId = (EditText) findViewById(R.id.AdminId);
                    mUserId.setText(mhint1);

                    *//*mhint2 = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Rank").getValue().toString();
                    mRank = (EditText) findViewById(R.id.update_rank_id_company);
                    mRank.setText(mhint2);*//*

                    mhint3 = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Email Id").getValue().toString();
                    mEmailId = (EditText) findViewById(R.id.AdminEmailId);
                    mEmailId.setText(mhint3);

                    mhint4 = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Contact No").getValue().toString();
                    mContactNo = (EditText) findViewById(R.id.AdminContactNo);
                    mContactNo.setText(mhint4);

                    mhint5 = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Address").getValue().toString();
                    mAddress = (EditText) findViewById(R.id.AdminAddress);
                    mAddress.setText(mhint5);

                }
                else
                {
                    mfullName = (EditText) findViewById(R.id.AdminFullName);
                    mUserId = (EditText) findViewById(R.id.AdminId);

                    mEmailId = (EditText) findViewById(R.id.AdminEmailId);
                    mContactNo = (EditText) findViewById(R.id.AdminContactNo);
                    mAddress = (EditText) findViewById(R.id.AdminAddress);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/
        mfullName = (EditText) findViewById(R.id.AdminFullName);
        mUserId = (EditText) findViewById(R.id.AdminId);

        mEmailId = (EditText) findViewById(R.id.AdminEmailId);
        mContactNo = (EditText) findViewById(R.id.AdminContactNo);
        mAddress = (EditText) findViewById(R.id.AdminAddress);
        mButton = (Button) findViewById(R.id.update_admin_profile_id);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        Log.v("email",emailIdFromOtherClass);
        DatabaseHelperAdmin helper = new DatabaseHelperAdmin(AdminUpdateDetails.this);
        final ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);
        mfullName.setText(list.get(1));
        /*mUsername.setText(list.get(2));*/
        mUserId.setText(list.get(3));
        mEmailId.setText(list.get(4));
        mContactNo.setText(list.get(5));
        mAddress.setText(list.get(7));
      /*  mSSC.setText(list.get(8));
        mHSC.setText(list.get(9));
*/
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //userRef = rootRef.child(mAuth.getCurrentUser().getUid());
                if(mfullName.getText().toString().isEmpty())
                {
                    mfullName.requestFocus();
                    mfullName.setError("Admin Name is required");
                    return;
                }
                if(mUserId.getText().toString().isEmpty())
                {
                    mUserId.requestFocus();
                    mUserId.setError("Admin Id is required");
                    return;
                }
                if(mEmailId.getText().toString().isEmpty())
                {
                    mEmailId.requestFocus();
                    mEmailId.setError("Email Id is required");
                    return;
                }
                if(mContactNo.getText().toString().isEmpty())
                {
                    mContactNo.requestFocus();
                    mContactNo.setError("Contact No is required");
                    return;
                }
                if(mAddress.getText().toString().isEmpty())
                {
                    mAddress.requestFocus();
                    mAddress.setError("Address is required");
                    return;
                }

                //childRef.setValue(mfullName);
                if(mfullName.getText().toString().isEmpty() || mUserId.getText().toString().isEmpty() || mEmailId.getText().toString().isEmpty() || mContactNo.getText().toString().isEmpty() || mAddress.getText().toString().isEmpty() )
                {
                    return;
                }
                else
                {
                    /*userRef.child("Admin Name").setValue(mfullName.getText().toString());
                    userRef.child("Admin Id").setValue(mUserId.getText().toString());
                    userRef.child("Email Id").setValue(mEmailId.getText().toString());
                    userRef.child("Contact No").setValue(mContactNo.getText().toString());
                    userRef.child("Address").setValue(mAddress.getText().toString());*/
                    DatabaseHelperAdmin helperAdmin = new DatabaseHelperAdmin(AdminUpdateDetails.this);
                    AdminContact c = new AdminContact();
                    c.setId(Integer.parseInt(list.get(0)));
                    c.setName(mfullName.getText().toString());
                   /* c.setUname(mUsername.getText().toString());*/
                    c.setUid(mUserId.getText().toString());
                    c.setEmailId(mEmailId.getText().toString());
                    c.setContactNo(mContactNo.getText().toString());
                    //String password = helper.searchPassword(mEmailId.getText().toString());
                   // c.setPassword(password);
                    c.setAddress(mAddress.getText().toString());
                   // c.setSsc(mSSC.getText().toString());
                    //c.setHsc(mHSC.getText().toString());
                    helperAdmin.updateProfile(c);
                    Intent i = new Intent(AdminUpdateDetails.this,AdminNavBarActivity.class);
                    i.putExtra("EmailId",mEmailId.getText().toString());
                    startActivity(i);
                    finish();
//                    startActivity(new Intent(getApplicationContext(),AdminNavBarActivity.class));
                   // finish();
                }

            }
        });


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
        getMenuInflater().inflate(R.menu.admin_update_details, menu);
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
            Intent i = new Intent(AdminUpdateDetails.this,AdminNavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);

            //startActivity(new Intent(getApplicationContext(),AdminNavBarActivity.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent i = new Intent(AdminUpdateDetails.this,ManageStudentActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);

            //startActivity(new Intent(getApplicationContext(),ManageStudentActivity.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            //startActivity(new Intent(getApplicationContext(),ManageCompany.class));
            Intent i = new Intent(AdminUpdateDetails.this,ManageCompany.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);

            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            //startActivity(new Intent(getApplicationContext(),AdminUpdateDetails.class));
            Intent i = new Intent(AdminUpdateDetails.this,AdminUpdateDetails.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);

            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_manage) {
            //startActivity(new Intent(getApplicationContext(),AdminChangePasswordNavBar.class));
            Intent i = new Intent(AdminUpdateDetails.this,AdminChangePasswordNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);

            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
