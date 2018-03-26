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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Iterator;
import java.util.List;

public class SearchJobsNavBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*private FirebaseAuth mAuth;
    private DatabaseReference mRef;*/
    private String emailIdFromOtherClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_jobs_nav_bar);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
      //  mAuth = FirebaseAuth.getInstance();

        ScrollView mscrollView = (ScrollView) findViewById(R.id.search_jobs_scroll_id);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.search_jobs_layout_id);
        /*TextView textView = new TextView(SearchJobsNavBar.this);
        textView.setText("bro");
        linearLayout.addView(textView);*/
        DatabaseHelperCompany helperCompany = new DatabaseHelperCompany(SearchJobsNavBar.this);
        List<CompanyContact> companyList = helperCompany.getAllCompany();

        for(int i=0; i<companyList.size();i++)
        {
            CompanyContact c = companyList.get(i);
            Log.v("Company Name",c.getName());
            Log.v("Job Name",c.getJobName1());
            if(c.getJobName1()!=null)
            {
                TextView textView1 = new TextView(SearchJobsNavBar.this);
                textView1.setText("Job Title: "+c.getJobName1());
                linearLayout.addView(textView1);
                TextView textView = new TextView(SearchJobsNavBar.this);
                textView.setText("Company Name: "+c.getName());
                linearLayout.addView(textView);

                TextView textView2 = new TextView(SearchJobsNavBar.this);
                textView2.setText("Job Id: "+c.getJobId1());
                linearLayout.addView(textView2);

                TextView textView3 = new TextView(SearchJobsNavBar.this);
                textView3.setText("Job Type: "+c.getJobType1());
                linearLayout.addView(textView3);

                TextView textView4 = new TextView(SearchJobsNavBar.this);
                textView4.setText("Salary: "+c.getSalary1());
                linearLayout.addView(textView4);

            }

            if(c.getJobName2()!=null)
            {
                TextView textView5 = new TextView(SearchJobsNavBar.this);
                textView5.setText("Job Title: "+c.getJobName2());
                linearLayout.addView(textView5);
                TextView textView6 = new TextView(SearchJobsNavBar.this);
                textView6.setText("Company Name: "+c.getName());
                linearLayout.addView(textView6);

                TextView textView7 = new TextView(SearchJobsNavBar.this);
                textView7.setText("Job Id: "+c.getJobId2());
                linearLayout.addView(textView7);

                TextView textView8 = new TextView(SearchJobsNavBar.this);
                textView8.setText("Job Type: "+c.getJobType2());
                linearLayout.addView(textView8);

                TextView textView9 = new TextView(SearchJobsNavBar.this);
                textView9.setText("Salary: "+c.getSalary2());
                linearLayout.addView(textView9);

            }

            if(c.getJobName3()!=null)
            {
                TextView textView10 = new TextView(SearchJobsNavBar.this);
                textView10.setText("Job Title: "+c.getJobName3());
                linearLayout.addView(textView10);
                TextView textView11 = new TextView(SearchJobsNavBar.this);
                textView11.setText("Company Name: "+c.getName());
                linearLayout.addView(textView11);

                TextView textView12 = new TextView(SearchJobsNavBar.this);
                textView12.setText("Job Id: "+c.getJobId3());
                linearLayout.addView(textView12);

                TextView textView13 = new TextView(SearchJobsNavBar.this);
                textView13.setText("Job Type: "+c.getJobType3());
                linearLayout.addView(textView13);

                TextView textView14 = new TextView(SearchJobsNavBar.this);
                textView14.setText("Salary: "+c.getSalary3());
                linearLayout.addView(textView14);

            }

            if(c.getJobName4()!=null)
            {
                TextView textView15 = new TextView(SearchJobsNavBar.this);
                textView15.setText("Job Title: "+c.getJobName4());
                linearLayout.addView(textView15);
                TextView textView16 = new TextView(SearchJobsNavBar.this);
                textView16.setText("Company Name: "+c.getName());
                linearLayout.addView(textView16);

                TextView textView17 = new TextView(SearchJobsNavBar.this);
                textView17.setText("Job Id: "+c.getJobId4());
                linearLayout.addView(textView17);

                TextView textView18 = new TextView(SearchJobsNavBar.this);
                textView18.setText("Job Type: "+c.getJobType4());
                linearLayout.addView(textView18);

                TextView textView19 = new TextView(SearchJobsNavBar.this);
                textView19.setText("Salary: "+c.getSalary4());
                linearLayout.addView(textView19);

            }

        }

        /*MyListAdapter adapter = new MyListAdapter(getApplicationContext(), maintitle, subtitle,imgid);
        list=(ListView)findViewById(R.id.list_item);
        list.setAdapter(adapter);
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
        getMenuInflater().inflate(R.menu.search_jobs_nav_bar, menu);
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
            startActivity(new Intent(SearchJobsNavBar.this, login.class));
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
            /*startActivity(new Intent(getApplicationContext(),NavBarActivity.class));*/
            Intent i = new Intent(SearchJobsNavBar.this,NavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            /*startActivity(new Intent(SearchJobsNavBar.this,ApplyForJobsNavBar.class));*/
            Intent i = new Intent(SearchJobsNavBar.this,ApplyForJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            /*startActivity(new Intent(SearchJobsNavBar.this,ViewJobStatusNavBar.class));*/
            Intent i = new Intent(SearchJobsNavBar.this,ViewJobStatusNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            /*startActivity(new Intent(SearchJobsNavBar.this,SearchJobsNavBar.class));*/
            Intent i = new Intent(SearchJobsNavBar.this,SearchJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;

        } else if (id == R.id.nav_manage) {
            /*startActivity(new Intent(SearchJobsNavBar.this,UpdateDetailsNavBar.class));*/
            Intent i = new Intent(SearchJobsNavBar.this,UpdateDetailsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;

        } else if (id == R.id.nav_password) {
            /*startActivity(new Intent(SearchJobsNavBar.this,ChangePasswordNavBar.class));*/
            Intent i = new Intent(SearchJobsNavBar.this,ChangePasswordNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
