package com.example.chetan.campusrecruitmentsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class CompanyChangePasswordNavBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

   /* private FirebaseAuth mAuth;
    private FirebaseUser mUser;*/
    private EditText mnewPassword;
    private EditText moldPassword;
    private EditText mConfirmPassword;
    private String emailIdFromOtherClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_change_password_nav_bar);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");

        final DatabaseHelperCompany helper = new DatabaseHelperCompany(CompanyChangePasswordNavBar.this);
       // mAuth = FirebaseAuth.getInstance();
        ScrollView mscrollView = (ScrollView) findViewById(R.id.company_change_password_scroll_id);

        moldPassword = (EditText) findViewById(R.id.old_password_id);
        mnewPassword = (EditText) findViewById(R.id.new_password_id);
        mConfirmPassword = (EditText) findViewById(R.id.new_confirm_password_id);
        Button mSubmit = (Button) findViewById(R.id.submit_button_id);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(moldPassword.getText().toString().isEmpty())
                {
                    moldPassword.requestFocus();
                    moldPassword.setError("Password is required");
                    return;
                }
                if(moldPassword.getText().toString().length()<6)
                {
                    moldPassword.requestFocus();
                    moldPassword.setError("Password length must be minimum 6");
                    return;
                }

                String password1 = helper.searchPassword(emailIdFromOtherClass);
                if((password1.equals(moldPassword.getText().toString())))
                {
                    if(mnewPassword.getText().toString().isEmpty())
                    {
                        mnewPassword.requestFocus();
                        mnewPassword.setError("Password is required");
                        return;
                    }
                    if(mnewPassword.getText().toString().length()<6)
                    {
                        mnewPassword.requestFocus();
                        mnewPassword.setError("Password length must be minimum 6");
                        return;
                    }

                    if(mConfirmPassword.getText().toString().isEmpty())
                    {
                        mConfirmPassword.requestFocus();
                        mConfirmPassword.setError("Password is required");
                        return;
                    }
                    if(mConfirmPassword.getText().toString().length()<6)
                    {
                        mConfirmPassword.requestFocus();
                        mConfirmPassword.setError("Password length must be minimum 6");
                        return;
                    }
                    if(mnewPassword.getText().toString().equals(mConfirmPassword.getText().toString()))
                    {
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
                        helper.changePassword(mnewPassword.getText().toString(),emailIdFromOtherClass,c);
                        Intent i = new Intent(CompanyChangePasswordNavBar.this,loginCompany.class);
                        i.putExtra("EmailId",emailIdFromOtherClass);
                        Toast.makeText(getApplicationContext(),"Password changed successfully",Toast.LENGTH_LONG).show();
                        startActivity(i);

                    /*mUser = FirebaseAuth.getInstance().getCurrentUser();
                    mUser.updatePassword(mnewPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(),"Password Updated",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(),loginCompany.class));
                                finish();
                            }
                            else
                            {
                                String errorMessage = task.getException().getMessage();
                                Toast.makeText(getApplicationContext(),"Try again",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });*/
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"New Password & new COnfirm password didn't match",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                else
                {
                    moldPassword.requestFocus();
                    moldPassword.setError("oldPassword is wrong Try Again!");
                    return;
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
        getMenuInflater().inflate(R.menu.company_change_password_nav_bar, menu);
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
         /*   startActivity(new Intent(getApplicationContext(),CompanyNavBar.class));*/
            Intent i = new Intent(getApplicationContext(),CompanyNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
            /*startActivity(new Intent(getApplicationContext(),PostJobs.class));*/
            Intent i = new Intent(getApplicationContext(),PostJobs.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            /*startActivity(new Intent(getApplicationContext(),ViewStudentApplicationCompanyNavBar.class));*/
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
            /*startActivity(new Intent(getApplicationContext(),CompanyUpdateDetailsNavBar.class));*/
            Intent i = new Intent(getApplicationContext(),CompanyUpdateDetailsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_password) {
            /*startActivity(new Intent(getApplicationContext(),CompanyChangePasswordNavBar.class));*/
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
