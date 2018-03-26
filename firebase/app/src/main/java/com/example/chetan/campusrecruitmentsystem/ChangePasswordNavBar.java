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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChangePasswordNavBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private EditText mnewPassword;
    private EditText moldPassword;
    private EditText mConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password_nav_bar);

        mAuth = FirebaseAuth.getInstance();
        ScrollView mscrollView = (ScrollView) findViewById(R.id.change_password_scroll_id);

        moldPassword = (EditText) findViewById(R.id.old_password_id);
        mnewPassword = (EditText) findViewById(R.id.new_password_id);
        mConfirmPassword = (EditText) findViewById(R.id.new_confirm_password_id);
        Button mSubmit = (Button) findViewById(R.id.submit_button_id);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    mUser = FirebaseAuth.getInstance().getCurrentUser();
                    mUser.updatePassword(mnewPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(),"Password Updated",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(),login.class));
                                finish();
                            }
                            else
                            {
                                String errorMessage = task.getException().getMessage();
                                Toast.makeText(getApplicationContext(),"Try again",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"New Password & new COnfirm password didn't match",Toast.LENGTH_LONG).show();
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
        getMenuInflater().inflate(R.menu.change_password_nav_bar, menu);
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
            startActivity(new Intent(ChangePasswordNavBar.this, login.class));
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
            startActivity(new Intent(ChangePasswordNavBar.this,ApplyForJobsNavBar.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(ChangePasswordNavBar.this,ViewJobStatusNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(ChangePasswordNavBar.this,SearchJobsNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;

        } else if (id == R.id.nav_manage) {
            startActivity(new Intent(ChangePasswordNavBar.this,UpdateDetailsNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;

        } else if (id == R.id.nav_password) {
            startActivity(new Intent(ChangePasswordNavBar.this,ChangePasswordNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
