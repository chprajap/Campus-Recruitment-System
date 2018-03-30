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
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class ManageCompany extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
/*
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;*/
    private String emailIdFromOtherClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_company);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");

        //      mAuth = FirebaseAuth.getInstance();
        ScrollView mscrollView = (ScrollView) findViewById(R.id.manage_company_scroll_id);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.company_id);

        DatabaseHelperCompany helperCompany = new DatabaseHelperCompany(ManageCompany.this);
        List<CompanyContact> companyList = helperCompany.getAllCompany();

        for(int i=0; i<companyList.size();i++)
        {
            CompanyContact c = companyList.get(i);
/*
            Log.v("Company Name",c.getName());
            Log.v("Job Name",c.getJobName1());
*/
            TextView textView = new TextView(ManageCompany.this);
            textView.setTextSize(18);
            textView.setText("* * * * * * * * * Company No: "+(i+1)+"* * * * * * * * *\n\n"+"Company Name: "+c.getName());
            linearLayout.addView(textView);

            TextView textView1 = new TextView(ManageCompany.this);
            textView1.setTextSize(18);
            textView1.setText("Company UserName: "+c.getUname());
            linearLayout.addView(textView1);

            TextView textView2 = new TextView(ManageCompany.this);
            textView2.setTextSize(18);
            textView2.setText("Company Id: "+c.getUid());
            linearLayout.addView(textView2);

            TextView textView3 = new TextView(ManageCompany.this);
            textView3.setTextSize(18);
            textView3.setText("Company EmailId: "+c.getEmailId());
            linearLayout.addView(textView3);

            TextView textView4 = new TextView(ManageCompany.this);
            textView4.setTextSize(18);
            textView4.setText("Company ContactNo: "+c.getContactNo());
            linearLayout.addView(textView4);

            TextView textView5 = new TextView(ManageCompany.this);
            textView5.setTextSize(18);
            textView5.setText("Company Address: "+c.getAddress());
            linearLayout.addView(textView5);

            TextView textView6 = new TextView(ManageCompany.this);
            textView6.setTextSize(18);
            textView6.setText("Company Rank: "+c.getRank() +"\n==================================\n");
            linearLayout.addView(textView6);



            if(c.getJobName1()!=null)
            {

                TextView textViewc = new TextView(ManageCompany.this);
                textViewc.setText("Company JobName1:"+c.getJobName1());
                textViewc.setTextSize(16);
                linearLayout.addView(textViewc);

                TextView textViewd = new TextView(ManageCompany.this);
                textViewd.setTextSize(16);
                textViewd.setText("Company JobId1: "+c.getJobId1());
                linearLayout.addView(textViewd);

                TextView textViewe = new TextView(ManageCompany.this);
                textViewe.setTextSize(16);
                textViewe.setText("Company JobType1: "+c.getJobType1());
                linearLayout.addView(textViewe);

                TextView textViewf = new TextView(ManageCompany.this);
                textViewf.setTextSize(16);
                textViewf.setText("Company JobSalary1: "+c.getSalary1()+"\n-------------------------------------------------------------\n");
                linearLayout.addView(textViewf);

                if(c.getJobName2()!=null)
                {
                    TextView textViewc1 = new TextView(ManageCompany.this);
                    textViewc1.setTextSize(16);
                    textViewc1.setText("Company JobName2: "+c.getJobName2());
                    linearLayout.addView(textViewc1);

                    TextView textViewd1 = new TextView(ManageCompany.this);
                    textViewd1.setTextSize(16);
                    textViewd1.setText("Company JobId2: "+c.getJobId2());
                    linearLayout.addView(textViewd1);

                    TextView textViewe1 = new TextView(ManageCompany.this);
                    textViewe1.setTextSize(16);
                    textViewe1.setText("Company JobType2: "+c.getJobType2());
                    linearLayout.addView(textViewe1);

                    TextView textViewf1 = new TextView(ManageCompany.this);
                    textViewf1.setTextSize(16);
                    textViewf1.setText("Company JobSalary2: "+c.getSalary2()+"\n-------------------------------------------------------------\n");
                    linearLayout.addView(textViewf1);

                    if(c.getJobName3()!=null)
                    {
                        TextView textViewc3 = new TextView(ManageCompany.this);
                        textViewc3.setTextSize(16);
                        textViewc3.setText("Company JobName3: "+c.getJobName3());
                        linearLayout.addView(textViewc3);

                        TextView textViewd3 = new TextView(ManageCompany.this);
                        textViewd3.setTextSize(16);
                        textViewd3.setText("Company JobId3: "+c.getJobId3());
                        linearLayout.addView(textViewd3);

                        TextView textViewe3 = new TextView(ManageCompany.this);
                        textViewe3.setTextSize(16);
                        textViewe3.setText("Company JobType3: "+c.getJobType3());
                        linearLayout.addView(textViewe3);

                        TextView textViewf3 = new TextView(ManageCompany.this);
                        textViewf3.setTextSize(16);
                        textViewf3.setText("Company JobSalary3: "+c.getSalary3()+"\n-------------------------------------------------------------\n");
                        linearLayout.addView(textViewf3);
                        if(c.getJobName4()!=null)
                        {
                            TextView textViewc4 = new TextView(ManageCompany.this);
                            textViewc4.setTextSize(16);
                            textViewc4.setText("Company JobName4: "+c.getJobName4());
                            linearLayout.addView(textViewc4);

                            TextView textViewd4 = new TextView(ManageCompany.this);
                            textViewd4.setTextSize(16);
                            textViewd4.setText("Company JobId4: "+c.getJobId4());
                            linearLayout.addView(textViewd4);

                            TextView textViewe4 = new TextView(ManageCompany.this);
                            textViewe4.setTextSize(16);
                            textViewe4.setText("Company JobType4: "+c.getJobType4());
                            linearLayout.addView(textViewe4);

                            TextView textViewf4 = new TextView(ManageCompany.this);
                            textViewf4.setTextSize(16);
                            textViewf4.setText("Company JobSalary4: "+c.getSalary4()+"\n-------------------------------------------------------------\n");
                            linearLayout.addView(textViewf4);
                        }
                    }

                }
            }


        }

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
        getMenuInflater().inflate(R.menu.manage_company, menu);
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
    //        mAuth.signOut();
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
            Intent i = new Intent(ManageCompany.this,AdminNavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            // startActivity(new Intent(getApplicationContext(),AdminNavBarActivity.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent i = new Intent(ManageCompany.this,ManageStudentActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            // startActivity(new Intent(getApplicationContext(),ManageStudentActivity.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(ManageCompany.this,ManageCompany.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            //startActivity(new Intent(getApplicationContext(),ManageCompany.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            Intent i = new Intent(ManageCompany.this,AdminUpdateDetails.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            //startActivity(new Intent(getApplicationContext(),AdminUpdateDetails.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_manage) {
            Intent i = new Intent(ManageCompany.this,AdminChangePasswordNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            // /startActivity(new Intent(getApplicationContext(),AdminChangePasswordNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
