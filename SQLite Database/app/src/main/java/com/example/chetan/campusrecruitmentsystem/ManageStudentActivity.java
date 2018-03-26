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

public class ManageStudentActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*private FirebaseAuth mAuth;
    private FirebaseUser mUser;*/
    private String emailIdFromOtherClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_student);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");

//        mAuth = FirebaseAuth.getInstance();
        ScrollView mscrollView = (ScrollView) findViewById(R.id.manage_student_scroll_id);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.stduent_id);

        DatabaseHelper helper = new DatabaseHelper(ManageStudentActivity.this);

        List<StudentContact> studentList = helper.getAllStudent();

        for(int i=0; i<studentList.size();i++)
        {
            StudentContact c = studentList.get(i);
            Log.v("Student Name",c.getName());
            Log.v("Job Name",c.getJobName1());
           /* TextView textView = new TextView(ViewStudentApplicationCompanyNavBar.this);
            textView.setText(c.getCompanyEmail1()+c.getCompanyEmail2()+c.getCompanyEmail3()+c.getCompanyEmail4());
            linearLayout.addView(textView);*/
            TextView textView = new TextView(ManageStudentActivity.this);
            textView.setText("Student Name: "+c.getName());
            linearLayout.addView(textView);

            TextView textView1 = new TextView(ManageStudentActivity.this);
            textView1.setText("Student UserName: "+c.getUname());
            linearLayout.addView(textView1);

            TextView textView2 = new TextView(ManageStudentActivity.this);
            textView2.setText("Student Id: "+c.getUid());
            linearLayout.addView(textView2);

            TextView textView3 = new TextView(ManageStudentActivity.this);
            textView3.setText("Student EmailId: "+c.getEmailId());
            linearLayout.addView(textView3);

            TextView textView4 = new TextView(ManageStudentActivity.this);
            textView4.setText("Student ContactNo: "+c.getContactNo());
            linearLayout.addView(textView4);

            TextView textView5 = new TextView(ManageStudentActivity.this);
            textView5.setText("Student Address: "+c.getAddress());
            linearLayout.addView(textView5);

            TextView textView6 = new TextView(ManageStudentActivity.this);
            textView6.setText("Student SSC Marks: "+c.getSsc());
            linearLayout.addView(textView6);

            TextView textView7 = new TextView(ManageStudentActivity.this);
            textView7.setText("Student HSC Marks: "+c.getHsc());
            linearLayout.addView(textView7);

            if(c.getGrade()!=null)
            {
                TextView textView8 = new TextView(ManageStudentActivity.this);
                textView8.setText("Student Grade: "+c.getGrade());
                linearLayout.addView(textView8);

                TextView textView9 = new TextView(ManageStudentActivity.this);
                textView9.setText("Student Skills: "+c.getSkill());
                linearLayout.addView(textView9);

                TextView textViewa = new TextView(ManageStudentActivity.this);
                textViewa.setText("Student CompanyName1: "+c.getCompanyName1());
                linearLayout.addView(textViewa);

                TextView textViewb = new TextView(ManageStudentActivity.this);
                textViewb.setText("Student CompanyEmail1: "+c.getCompanyEmail1());
                linearLayout.addView(textViewb);

                TextView textViewc = new TextView(ManageStudentActivity.this);
                textViewc.setText("Student JobName1: "+c.getJobName1());
                linearLayout.addView(textViewc);

                TextView textViewd = new TextView(ManageStudentActivity.this);
                textViewd.setText("Student JobId1: "+c.getJobId1());
                linearLayout.addView(textViewd);

                TextView textViewe = new TextView(ManageStudentActivity.this);
                textViewe.setText("Student JobType1: "+c.getJobType1());
                linearLayout.addView(textViewe);

                if(c.getCompanyName2()!=null)
                {
                    TextView textViewa1 = new TextView(ManageStudentActivity.this);
                    textViewa1.setText("Student CompanyName2: "+c.getCompanyName2());
                    linearLayout.addView(textViewa1);

                    TextView textViewb1 = new TextView(ManageStudentActivity.this);
                    textViewb1.setText("Student CompanyEmail2: "+c.getCompanyEmail2());
                    linearLayout.addView(textViewb1);

                    TextView textViewc1 = new TextView(ManageStudentActivity.this);
                    textViewc1.setText("Student JobName2: "+c.getJobName2());
                    linearLayout.addView(textViewc1);

                    TextView textViewd1 = new TextView(ManageStudentActivity.this);
                    textViewd1.setText("Student JobId2: "+c.getJobId2());
                    linearLayout.addView(textViewd1);

                    TextView textViewe1 = new TextView(ManageStudentActivity.this);
                    textViewe1.setText("Student JobType2: "+c.getJobType2());
                    linearLayout.addView(textViewe1);

                    if(c.getCompanyName3()!=null)
                    {
                        TextView textViewa3 = new TextView(ManageStudentActivity.this);
                        textViewa3.setText("Student CompanyName3: "+c.getCompanyName3());
                        linearLayout.addView(textViewa3);

                        TextView textViewb3 = new TextView(ManageStudentActivity.this);
                        textViewb3.setText("Student CompanyEmail13: "+c.getCompanyEmail3());
                        linearLayout.addView(textViewb3);

                        TextView textViewc3 = new TextView(ManageStudentActivity.this);
                        textViewc3.setText("Student JobName3: "+c.getJobName3());
                        linearLayout.addView(textViewc3);

                        TextView textViewd3 = new TextView(ManageStudentActivity.this);
                        textViewd3.setText("Student JobId3: "+c.getJobId3());
                        linearLayout.addView(textViewd3);

                        TextView textViewe3 = new TextView(ManageStudentActivity.this);
                        textViewe3.setText("Student JobType3: "+c.getJobType3());
                        linearLayout.addView(textViewe3);

                        if(c.getCompanyName4()!=null)
                        {
                            TextView textViewa4 = new TextView(ManageStudentActivity.this);
                            textViewa4.setText("Student CompanyName4: "+c.getCompanyName4());
                            linearLayout.addView(textViewa4);

                            TextView textViewb4 = new TextView(ManageStudentActivity.this);
                            textViewb4.setText("Student CompanyEmail4: "+c.getCompanyEmail4());
                            linearLayout.addView(textViewb4);

                            TextView textViewc4 = new TextView(ManageStudentActivity.this);
                            textViewc4.setText("Student JobName4: "+c.getJobName4());
                            linearLayout.addView(textViewc4);

                            TextView textViewd4 = new TextView(ManageStudentActivity.this);
                            textViewd4.setText("Student JobId4: "+c.getJobId4());
                            linearLayout.addView(textViewd4);

                            TextView textViewe4 = new TextView(ManageStudentActivity.this);
                            textViewe4.setText("Student JobType4: "+c.getJobType4());
                            linearLayout.addView(textViewe4);

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
        getMenuInflater().inflate(R.menu.manage_student, menu);
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
  //          mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), loginAdmin.class));
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
        if(id==R.id.admin_home){
            Intent i = new Intent(ManageStudentActivity.this,AdminNavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            //        startActivity(new Intent(getApplicationContext(),AdminNavBarActivity.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent i = new Intent(ManageStudentActivity.this,ManageStudentActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            //  startActivity(new Intent(getApplicationContext(),ManageStudentActivity.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(ManageStudentActivity.this,ManageCompany.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            //startActivity(new Intent(getApplicationContext(),ManageCompany.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            Intent i = new Intent(ManageStudentActivity.this,AdminUpdateDetails.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            //startActivity(new Intent(getApplicationContext(),AdminUpdateDetails.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_manage) {
            Intent i = new Intent(ManageStudentActivity.this,AdminChangePasswordNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            //startActivity(new Intent(getApplicationContext(),AdminChangePasswordNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
