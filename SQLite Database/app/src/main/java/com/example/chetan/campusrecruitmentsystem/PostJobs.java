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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PostJobs extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

/*    private FirebaseAuth mAuth;
    private DatabaseReference muserRef;
    private DatabaseReference myRef;*/
private String emailIdFromOtherClass;
    private EditText mJobId;
    private EditText mJobName;
    private EditText mJobType;
    private EditText mSalary;
    private Button mUpdateButton;
    static int var =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_jobs);

      //  mAuth = FirebaseAuth.getInstance();
        ScrollView mscrollView = (ScrollView) findViewById(R.id.post_jobs_scroll_id);

        mJobId = (EditText) findViewById(R.id.job_id);
        mJobName = (EditText) findViewById(R.id.job_name_id);
        mJobType = (EditText) findViewById(R.id.job_type_id);
        mSalary = (EditText) findViewById(R.id.salary_id);
        mUpdateButton = (Button) findViewById(R.id.update_post_jobs_button_id);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        Log.v("email",emailIdFromOtherClass);
        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelperCompany helper = new DatabaseHelperCompany(PostJobs.this);
                final ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);

                CompanyContact c = new CompanyContact();
                c.setId(Integer.parseInt(list.get(0)));
                c.setName(list.get(1));
                c.setUname(list.get(2));
                c.setUid(list.get(3));
                c.setEmailId(list.get(4));
                c.setContactNo(list.get(5));
                c.setPassword(list.get(6));
                c.setAddress(list.get(7));
                c.setRank(list.get(8));
                helper.postJobs(emailIdFromOtherClass,Integer.parseInt(mJobId.getText().toString()),mJobName.getText().toString(),mJobType.getText().toString(),Integer.parseInt(mSalary.getText().toString()),c);
                Intent i = new Intent(PostJobs.this,CompanyNavBar.class);
                i.putExtra("EmailId",emailIdFromOtherClass);
                Toast.makeText(getApplicationContext(),"Job posted successfully",Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });
        /*mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                muserRef=FirebaseDatabase.getInstance().getReference().child("Company").child(mAuth.getCurrentUser().getUid());
                muserRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("Job Details"))
                        {
                            var++;
                            Log.v("Tag",Integer.toString(var));
                            muserRef.child("Job Details").child(Integer.toString(var)).child("Job Name").setValue(mJobName.getText().toString());
                            muserRef.child("Job Details").child(Integer.toString(var)).child("Job Type").setValue(mJobType.getText().toString());
                            muserRef.child("Job Details").child(Integer.toString(var)).child("Salary").setValue(mSalary.getText().toString());
                            break;
                        }
                        else
                        {
                            var=1;
                            Log.v("Tag1",Integer.toString(var));
                            FirebaseDatabase.getInstance().getReference().child("Company").child(mAuth.getCurrentUser().getUid()).child("Job Details").child(Integer.toString(var)).child("Job Name").setValue(mJobName.getText().toString());
                            FirebaseDatabase.getInstance().getReference().child("Company").child(mAuth.getCurrentUser().getUid()).child("Job Details").child(Integer.toString(var)).child("Job Type").setValue(mJobType.getText().toString());
                            FirebaseDatabase.getInstance().getReference().child("Company").child(mAuth.getCurrentUser().getUid()).child("Job Details").child(Integer.toString(var)).child("Salary").setValue(mSalary.getText().toString());
                            break;
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });*/

                /*Toast.makeText(getApplicationContext(),"Job Details added Successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),CompanyNavBar.class));
            }
        });
*/
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
        getMenuInflater().inflate(R.menu.post_jobs, menu);
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
            startActivity(new Intent(getApplicationContext(), loginCompany.class));
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
        if (id == R.id.company_home )
        {
            Intent i = new Intent(getApplicationContext(),CompanyNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            //drawer.closeDrawer(GravityCompat.START);
        //    startActivity(new Intent(getApplicationContext(),CompanyNavBar.class));
           drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
           // drawer.closeDrawer(GravityCompat.START);
          //  startActivity(new Intent(getApplicationContext(),PostJobs.class));
            //finish();
            Intent i = new Intent(getApplicationContext(),PostJobs.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            //startActivity(new Intent(getApplicationContext(),ViewStudentApplicationCompanyNavBar.class));
            Intent i = new Intent(getApplicationContext(),ViewStudentApplicationCompanyNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } /*else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(getApplicationContext(),SearchJobsNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } */else if (id == R.id.nav_manage) {
            //startActivity(new Intent(getApplicationContext(),CompanyUpdateDetailsNavBar.class));
            Intent i = new Intent(getApplicationContext(),CompanyUpdateDetailsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_password) {
            //startActivity(new Intent(getApplicationContext(),ChangePasswordNavBar.class));
            Intent i = new Intent(getApplicationContext(),CompanyChangePasswordNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
