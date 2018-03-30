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
import com.google.firebase.database.DatabaseReference;

import org.w3c.dom.Text;

import java.util.List;

public class ViewStudentApplicationCompanyNavBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

   /* private FirebaseAuth mAuth;
    private DatabaseReference myRef;
*/
   private String emailIdFromOtherClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_application_company_nav_bar);

  //      mAuth = FirebaseAuth.getInstance();
        ScrollView mscrollView = (ScrollView) findViewById(R.id.view_student_application_company_scroll_id);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.view_student_application_company_linear_layout_id);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        DatabaseHelper helper = new DatabaseHelper(ViewStudentApplicationCompanyNavBar.this);

        List<StudentContact> studentList = helper.getAllStudent();

        for(int i=0; i<studentList.size();i++)
        {
            StudentContact c = studentList.get(i);
           /* TextView textView = new TextView(ViewStudentApplicationCompanyNavBar.this);
            textView.setText(c.getCompanyEmail1()+c.getCompanyEmail2()+c.getCompanyEmail3()+c.getCompanyEmail4());
            linearLayout.addView(textView);*/
            if(c.getCompanyEmail1()!=null && c.getCompanyEmail1().equals(emailIdFromOtherClass))
            {
                TextView textView1 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView1.setTextSize(18);
                textView1.setText(" * * * * * Student Name * * * * *\n\n"+"Student Name: "+c.getName());
                linearLayout.addView(textView1);

                TextView textView2 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView2.setTextSize(18);
                textView2.setText("Job Name: "+c.getJobName1());
                linearLayout.addView(textView2);

                TextView textView3 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView3.setTextSize(18);
                textView3.setText("Job Id: "+c.getJobId1());
                linearLayout.addView(textView3);

                TextView textView4 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView4.setTextSize(18);
                textView4.setText("Job Type: "+c.getJobType1());
                linearLayout.addView(textView4);

                TextView textView5 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView5.setTextSize(18);
                textView5.setText("Student EmailId: "+c.getEmailId());
                linearLayout.addView(textView5);

                TextView textView6 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView6.setTextSize(18);
                textView6.setText("Student ContactNo: "+c.getContactNo());
                linearLayout.addView(textView6);

                TextView textView7 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView7.setTextSize(18);
                textView7.setText("Student Grade: "+c.getGrade());
                linearLayout.addView(textView7);

                TextView textView8 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView8.setTextSize(18);
                textView8.setText("Student Skill: "+c.getSkill()+"\n==================================\n");
                linearLayout.addView(textView8);

            }
            /*TextView timepass = new TextView(ViewStudentApplicationCompanyNavBar.this);
            timepass.setText(emailIdFromOtherClass);
            linearLayout.addView(timepass);*/
/*            Log.v("email",emailIdFromOtherClass);
            Log.v("email1",c.getCompanyEmail2());*/
            if(c.getCompanyEmail2()!=null && (c.getCompanyEmail2()).equals(emailIdFromOtherClass))
            {
                /*TextView timepass1 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                timepass1.setText(c.getCompanyEmail2());
                linearLayout.addView(timepass1);*/

                TextView textView9 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView9.setTextSize(16);
                textView9.setText("Student Name: "+c.getName());
                linearLayout.addView(textView9);

                TextView textView10 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView10.setTextSize(16);
                textView10.setText("Job Name: "+c.getJobName2());
                linearLayout.addView(textView10);

                TextView textView11 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView11.setTextSize(16);
                textView11.setText("Job Id: "+c.getJobId2());
                linearLayout.addView(textView11);

                TextView textView12 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView12.setTextSize(16);
                textView12.setText("Job Type: "+c.getJobType2());
                linearLayout.addView(textView12);

                TextView textView13 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView13.setTextSize(16);
                textView13.setText("Student EmailId: "+c.getEmailId());
                linearLayout.addView(textView13);

                TextView textView14 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView14.setTextSize(16);
                textView14.setText("Student ContactNo: "+c.getContactNo());
                linearLayout.addView(textView14);

                TextView textView15 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView15.setTextSize(16);
                textView15.setText("Student Grade: "+c.getGrade());
                linearLayout.addView(textView15);

                TextView textView16 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView16.setTextSize(16);
                textView16.setText("Student Skill: "+c.getSkill()+"\n-------------------------------------------------------------\n");
                linearLayout.addView(textView16);

            }

            if(c.getCompanyEmail3()!=null && c.getCompanyEmail3().equals(emailIdFromOtherClass))
            {
                TextView textView1a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView1a.setTextSize(16);
                textView1a.setText("Student Name: "+c.getName());
                linearLayout.addView(textView1a);

                TextView textView2a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView2a.setTextSize(16);
                textView2a.setText("Job Name: "+c.getJobName3());
                linearLayout.addView(textView2a);

                TextView textView3a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView3a.setTextSize(16);
                textView3a.setText("Job Id: "+c.getJobId3());
                linearLayout.addView(textView3a);

                TextView textView4a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView4a.setTextSize(16);
                textView4a.setText("Job Type: "+c.getJobType3());
                linearLayout.addView(textView4a);

                TextView textView5a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView5a.setTextSize(16);
                textView5a.setText("Student EmailId: "+c.getEmailId());
                linearLayout.addView(textView5a);

                TextView textView6a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView6a.setTextSize(16);
                textView6a.setText("Student ContactNo: "+c.getContactNo());
                linearLayout.addView(textView6a);

                TextView textView7a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView7a.setTextSize(16);
                textView7a.setText("Student Grade: "+c.getGrade());
                linearLayout.addView(textView7a);

                TextView textView8a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView8a.setTextSize(16);
                textView8a.setText("Student Skill: "+c.getSkill()+"\n-------------------------------------------------------------\n");
                linearLayout.addView(textView8a);

            }

            if(c.getCompanyEmail4()!=null && c.getCompanyEmail4().equals(emailIdFromOtherClass))
            {
                TextView textView1b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView1b.setTextSize(16);
                textView1b.setText("Student Name: "+c.getName());
                linearLayout.addView(textView1b);

                TextView textView2b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView2b.setTextSize(16);
                textView2b.setText("Job Name: "+c.getJobName4());
                linearLayout.addView(textView2b);

                TextView textView3b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView3b.setTextSize(16);
                textView3b.setText("Job Id: "+c.getJobId4());
                linearLayout.addView(textView3b);

                TextView textView4b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView4b.setTextSize(16);
                textView4b.setText("Job Type: "+c.getJobType4());
                linearLayout.addView(textView4b);

                TextView textView5b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView5b.setTextSize(16);
                textView5b.setText("Student EmailId: "+c.getEmailId());
                linearLayout.addView(textView5b);

                TextView textView6b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView6b.setTextSize(16);
                textView6b.setText("Student ContactNo: "+c.getContactNo());
                linearLayout.addView(textView6b);

                TextView textView7b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView7b.setTextSize(16);
                textView7b.setText("Student Grade: "+c.getGrade());
                linearLayout.addView(textView7b);

                TextView textView8b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView8b.setTextSize(16);
                textView8b.setText("Student Skill: "+c.getSkill()+"\n-------------------------------------------------------------\n");
                linearLayout.addView(textView8b);

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
        getMenuInflater().inflate(R.menu.view_student_application_company_nav_bar, menu);
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
//            mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), loginCompany.class));
            finish();
            return true;
        }
        else if(id==R.id.help)
        {
            startActivity(new Intent(getApplicationContext(),companyHelp.class));
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
//            startActivity(new Intent(getApplicationContext(),CompanyNavBar.class));
            Intent i = new Intent(getApplicationContext(),CompanyNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);

            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
//            startActivity(new Intent(getApplicationContext(),PostJobs.class));
            Intent i = new Intent(getApplicationContext(),PostJobs.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);

            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
//            startActivity(new Intent(getApplicationContext(),ViewStudentApplicationCompanyNavBar.class));
            Intent i = new Intent(getApplicationContext(),ViewStudentApplicationCompanyNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);

            drawer.closeDrawer(GravityCompat.START);
            return true;
        } /*else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(getApplicationContext(),SearchJobsNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }*/ else if (id == R.id.nav_manage) {
            //startActivity(new Intent(getApplicationContext(),CompanyUpdateDetailsNavBar.class));
            Intent i = new Intent(getApplicationContext(),CompanyUpdateDetailsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);

            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_password) {
            //startActivity(new Intent(getApplicationContext(),CompanyChangePasswordNavBar.class));
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
