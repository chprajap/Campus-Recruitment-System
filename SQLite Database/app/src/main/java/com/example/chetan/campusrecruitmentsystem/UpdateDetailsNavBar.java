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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UpdateDetailsNavBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*private FirebaseAuth mAuth;

    private DatabaseReference rootRef;
    private DatabaseReference userRef;*/
    /*private EditText mfullName;
    private EditText mUsername;
    private EditText mUserId;
    private EditText mEmailId;
    private EditText mContactNo;
    private EditText mAddress;
    private EditText mSSC;
    private EditText mHSC;
    private Button mButton;
    private String mhint;
    private String mhint1;
    private String mhint2;
    private String mhint3;
    private String mhint4;
    private String mhint5;
    private String mhint6;
    private String mhint7;*/
    /*private FirebaseAuth mAuth;

    private DatabaseReference rootRef;
    private DatabaseReference userRef;*/
    private String emailIdFromOtherClass;
    private EditText mfullName;
    private EditText mUsername;
    private EditText mUserId;
    private EditText mEmailId;
    private EditText mContactNo;
    private EditText mAddress;
    private EditText mSSC;
    private EditText mHSC;
    private Button mButton;
    private String mhint;
    private String mhint1;
    private String mhint2;
    private String mhint3;
    private String mhint4;
    private String mhint5;
    private String mhint6;
    private String mhint7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details_nav_bar);

        /*code for spinner*/

        Spinner spinner = (Spinner) findViewById(R.id.department_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(UpdateDetailsNavBar.this, R.array.department_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner mspinner = (Spinner) findViewById(R.id.year_id);
        ArrayAdapter<CharSequence> madapter = ArrayAdapter.createFromResource(UpdateDetailsNavBar.this, R.array.year_spinner, android.R.layout.simple_spinner_item);
        madapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinner.setAdapter(madapter);

        Spinner nspinner = (Spinner) findViewById(R.id.year1_id);
        ArrayAdapter<CharSequence> nadapter = ArrayAdapter.createFromResource(UpdateDetailsNavBar.this, R.array.year_spinner, android.R.layout.simple_spinner_item);
        nadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nspinner.setAdapter(nadapter);

        /*mAuth = FirebaseAuth.getInstance();
        rootRef= FirebaseDatabase.getInstance().getReference().child("Student");*/
        /**code for spinner**/
        /*ScrollView mscrollView = (ScrollView) findViewById(R.id.update_details_scroll_id);
        mfullName = (EditText) findViewById(R.id.updateName);
        mUsername = (EditText) findViewById(R.id.updateUsername);
        mUserId = (EditText) findViewById(R.id.updateUserId);
        mEmailId = (EditText) findViewById(R.id.updateEmailId);
        mContactNo = (EditText) findViewById(R.id.updateContactNo);
        mAddress = (EditText) findViewById(R.id.updateAddress);
        mSSC = (EditText) findViewById(R.id.updateSSC);
        mHSC = (EditText) findViewById(R.id.updateHSC);
*/
        ScrollView mscrollView = (ScrollView) findViewById(R.id.update_details_scroll_id);
        mfullName = (EditText) findViewById(R.id.updateName);
        mUsername = (EditText) findViewById(R.id.updateUsername);
        mUserId = (EditText) findViewById(R.id.updateUserId);
        mEmailId = (EditText) findViewById(R.id.updateEmailId);
        mContactNo = (EditText) findViewById(R.id.updateContactNo);
        mAddress = (EditText) findViewById(R.id.updateAddress);
        mSSC = (EditText) findViewById(R.id.updateSSC);
        mHSC = (EditText) findViewById(R.id.updateHSC);

        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        Log.v("email",emailIdFromOtherClass);
        DatabaseHelper helper = new DatabaseHelper(UpdateDetailsNavBar.this);
        final ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);
        mfullName.setText(list.get(1));
        mUsername.setText(list.get(2));
        mUserId.setText(list.get(3));
        mEmailId.setText(list.get(4));
        mContactNo.setText(list.get(5));
        mAddress.setText(list.get(7));
        mSSC.setText(list.get(8));
        mHSC.setText(list.get(9));

        /*rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(mAuth.getCurrentUser().getUid()))
                {
                    mhint = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Profile").child("Full Name").getValue().toString();
                    mfullName = (EditText) findViewById(R.id.updateName);
                    mfullName.setText(mhint);

                    mhint1 = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Profile").child("UserName").getValue().toString();
                    mUsername = (EditText) findViewById(R.id.updateUsername);
                    mUsername.setText(mhint1);

                    mhint2 = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Profile").child("User Id").getValue().toString();
                    mUserId = (EditText) findViewById(R.id.updateUserId);
                    mUserId.setText(mhint2);

                    mhint3 = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Profile").child("Email Id").getValue().toString();
                    mEmailId = (EditText) findViewById(R.id.updateEmailId);
                    mEmailId.setText(mhint3);

                    mhint4 = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Profile").child("Contact No").getValue().toString();
                    mContactNo = (EditText) findViewById(R.id.updateContactNo);
                    mContactNo.setText(mhint4);

                    mhint5 = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Profile").child("Address").getValue().toString();
                    mAddress = (EditText) findViewById(R.id.updateAddress);
                    mAddress.setText(mhint5);

                    mhint6 = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Profile").child("SSC").getValue().toString();
                    mSSC = (EditText) findViewById(R.id.updateSSC);
                    mSSC.setText(mhint6);

                    mhint7 = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("Profile").child("HSC").getValue().toString();
                    mHSC = (EditText) findViewById(R.id.updateHSC);
                    mHSC.setText(mhint7);
                }
                else
                {
                    mfullName = (EditText) findViewById(R.id.updateName);
                    mUsername = (EditText) findViewById(R.id.updateUsername);
                    mUserId = (EditText) findViewById(R.id.updateUserId);
                    mEmailId = (EditText) findViewById(R.id.updateEmailId);
                    mContactNo = (EditText) findViewById(R.id.updateContactNo);
                    mAddress = (EditText) findViewById(R.id.updateAddress);
                    mSSC = (EditText) findViewById(R.id.updateSSC);
                    mHSC = (EditText) findViewById(R.id.updateHSC);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
        /*userRef = rootRef.child(mAuth.getCurrentUser().getUid());
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mhint = dataSnapshot.child("Full Name").getValue().toString();
                mfullName = (EditText) findViewById(R.id.updateName);
                mfullName.setText(mhint);

                mhint1 = dataSnapshot.child("UserName").getValue().toString();
                mUsername = (EditText) findViewById(R.id.updateUsername);
                mUsername.setText(mhint1);

                mhint2 = dataSnapshot.child("User Id").getValue().toString();
                mUserId = (EditText) findViewById(R.id.updateUserId);
                mUserId.setText(mhint2);

                mhint3 = dataSnapshot.child("Email Id").getValue().toString();
                mEmailId = (EditText) findViewById(R.id.updateEmailId);
                mEmailId.setText(mhint3);

                mhint4 = dataSnapshot.child("Contact No").getValue().toString();
                mContactNo = (EditText) findViewById(R.id.updateContactNo);
                mContactNo.setText(mhint4);

                mhint5 = dataSnapshot.child("Address").getValue().toString();
                mAddress = (EditText) findViewById(R.id.updateAddress);
                mAddress.setText(mhint5);

                mhint6 = dataSnapshot.child("SSC").getValue().toString();
                mSSC = (EditText) findViewById(R.id.updateSSC);
                mSSC.setText(mhint6);

                mhint7 = dataSnapshot.child("HSC").getValue().toString();
                mHSC = (EditText) findViewById(R.id.updateHSC);
                mHSC.setText(mhint7);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/



        /*mButton = (Button) findViewById(R.id.update_profile_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  User user = new User(mfullName.getText().toString(),mUsername.getText().toString(),mUserId.getText().toString(),mEmailId.getText().toString(),mContactNo.getText().toString(),mAddress.getText().toString(),mSSC.getText().toString(),mHSC.getText().toString());
              //  userRef = rootRef.child(mAuth.getCurrentUser().getUid()).child("Profile");
                if(mfullName.getText().toString().isEmpty())
                {
                    mfullName.requestFocus();
                    mfullName.setError("Full Name is required");
                    return;
                }

                if(mUsername.getText().toString().isEmpty())
                {
                    mUsername.requestFocus();
                    mUsername.setError("Username is required");
                    return;
                }

                if(mUserId.getText().toString().isEmpty())
                {
                    mUserId.requestFocus();
                    mUserId.setError("User Id is required");
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

                if(mSSC.getText().toString().isEmpty())
                {
                    mSSC.requestFocus();
                    mSSC.setError("SSC is required");
                    return;
                }

                if(mHSC.getText().toString().isEmpty())
                {
                    mHSC.requestFocus();
                    mHSC.setError("HSC is required");
                    return;
                }

                //childRef.setValue(mfullName);
                if(mfullName.getText().toString().isEmpty() || mUsername.getText().toString().isEmpty() || mUserId.getText().toString().isEmpty() || mEmailId.getText().toString().isEmpty() || mContactNo.getText().toString().isEmpty() || mAddress.getText().toString().isEmpty() || mSSC.getText().toString().isEmpty() || mHSC.getText().toString().isEmpty())
                {
                    return;
                }
                else
                {
                    *//*userRef.child("Full Name").setValue(mfullName.getText().toString());
                    userRef.child("UserName").setValue(mUsername.getText().toString());
                    userRef.child("User Id").setValue(mUserId.getText().toString());
                    userRef.child("Email Id").setValue(mEmailId.getText().toString());
                    userRef.child("Contact No").setValue(mContactNo.getText().toString());
                    userRef.child("Address").setValue(mAddress.getText().toString());
                    userRef.child("SSC").setValue(mSSC.getText().toString());
                    userRef.child("HSC").setValue(mHSC.getText().toString());*//*
                    DatabaseHelper helper = new DatabaseHelper(UpdateDetailsNavBar.this,3);
                    StudentContact c = new StudentContact();
                    c.setName(mfullName.getText().toString());
                    c.setUname(mUsername.getText().toString());
                    c.setUid(mUserId.getText().toString());
                    c.setEmailId(mEmailId.getText().toString());
                    c.setContactNo(mContactNo.getText().toString());
                    String password = helper.searchPassword(mEmailId.getText().toString());
                    c.setPassword(password);
                    c.setAddress(mAddress.getText().toString());
                    c.setSsc(mSSC.getText().toString());
                    c.setHsc(mHSC.getText().toString());
                    helper.updateProfile(c);
                    startActivity(new Intent(UpdateDetailsNavBar.this,NavBarActivity.class));
                    finish();
                }

            }
        });
*/

        mButton = (Button) findViewById(R.id.update_profile_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  User user = new User(mfullName.getText().toString(),mUsername.getText().toString(),mUserId.getText().toString(),mEmailId.getText().toString(),mContactNo.getText().toString(),mAddress.getText().toString(),mSSC.getText().toString(),mHSC.getText().toString());
                //  userRef = rootRef.child(mAuth.getCurrentUser().getUid()).child("Profile");
                if(mfullName.getText().toString().isEmpty())
                {
                    mfullName.requestFocus();
                    mfullName.setError("Full Name is required");
                    return;
                }

                if(mUsername.getText().toString().isEmpty())
                {
                    mUsername.requestFocus();
                    mUsername.setError("Username is required");
                    return;
                }

                if(mUserId.getText().toString().isEmpty())
                {
                    mUserId.requestFocus();
                    mUserId.setError("User Id is required");
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

                if(mSSC.getText().toString().isEmpty())
                {
                    mSSC.requestFocus();
                    mSSC.setError("SSC is required");
                    return;
                }

                if(mHSC.getText().toString().isEmpty())
                {
                    mHSC.requestFocus();
                    mHSC.setError("HSC is required");
                    return;
                }

                //childRef.setValue(mfullName);
                if(mfullName.getText().toString().isEmpty() || mUsername.getText().toString().isEmpty() || mUserId.getText().toString().isEmpty() || mEmailId.getText().toString().isEmpty() || mContactNo.getText().toString().isEmpty() || mAddress.getText().toString().isEmpty() || mSSC.getText().toString().isEmpty() || mHSC.getText().toString().isEmpty())
                {
                    return;
                }
                else
                {
                    /*userRef.child("Full Name").setValue(mfullName.getText().toString());
                    userRef.child("UserName").setValue(mUsername.getText().toString());
                    userRef.child("User Id").setValue(mUserId.getText().toString());
                    userRef.child("Email Id").setValue(mEmailId.getText().toString());
                    userRef.child("Contact No").setValue(mContactNo.getText().toString());
                    userRef.child("Address").setValue(mAddress.getText().toString());
                    userRef.child("SSC").setValue(mSSC.getText().toString());
                    userRef.child("HSC").setValue(mHSC.getText().toString());*/
                    DatabaseHelper helper = new DatabaseHelper(UpdateDetailsNavBar.this);
                    StudentContact c = new StudentContact();
                    c.setId(Integer.parseInt(list.get(0)));
                    c.setName(mfullName.getText().toString());
                    c.setUname(mUsername.getText().toString());
                    c.setUid(mUserId.getText().toString());
                    c.setEmailId(mEmailId.getText().toString());
                    c.setContactNo(mContactNo.getText().toString());
                    String password = helper.searchPassword(mEmailId.getText().toString());
                    c.setPassword(password);
                    c.setAddress(mAddress.getText().toString());
                    c.setSsc(mSSC.getText().toString());
                    c.setHsc(mHSC.getText().toString());
                    helper.updateProfile(c);
                    Intent i = new Intent(UpdateDetailsNavBar.this,NavBarActivity.class);
                    i.putExtra("EmailId",mEmailId.getText().toString());
                    startActivity(i);
                    finish();
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
        getMenuInflater().inflate(R.menu.update_details_nav_bar, menu);
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
            //mAuth.signOut();
            startActivity(new Intent(UpdateDetailsNavBar.this, login.class));
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
            /*startActivity(new Intent(getApplicationContext(),NavBarActivity.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;*/
            Intent i = new Intent(UpdateDetailsNavBar.this,NavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            /*startActivity(new Intent(UpdateDetailsNavBar.this,ApplyForJobsNavBar.class));*/
            //finish();
            Intent i = new Intent(UpdateDetailsNavBar.this,ApplyForJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            /*startActivity(new Intent(UpdateDetailsNavBar.this,ViewJobStatusNavBar.class));*/
            Intent i = new Intent(UpdateDetailsNavBar.this,ViewJobStatusNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            /*startActivity(new Intent(UpdateDetailsNavBar.this,SearchJobsNavBar.class));*/
            Intent i = new Intent(UpdateDetailsNavBar.this,SearchJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;

        } else if (id == R.id.nav_manage) {
            /*startActivity(new Intent(UpdateDetailsNavBar.this,UpdateDetailsNavBar.class));*/
            Intent i = new Intent(UpdateDetailsNavBar.this,UpdateDetailsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;

        } else if (id == R.id.nav_password) {
            /*startActivity(new Intent(UpdateDetailsNavBar.this,ChangePasswordNavBar.class));*/
            Intent i = new Intent(UpdateDetailsNavBar.this,ChangePasswordNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
