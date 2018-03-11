package com.example.android.campusrecruitmentsystem;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.android.campusrecruitmentsystem.R;
import com.example.android.campusrecruitmentsystem.login;
import com.google.firebase.auth.FirebaseAuth;

public class updateDetails extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatestudentdetails);

        /*Side navigation bar button (Three line wali button bohot time laga hai bhai)*/

        mDrawerLayout = (DrawerLayout) findViewById(R.id.student_sideNabBar);
        mToogle = new ActionBarDrawerToggle(this, mDrawerLayout ,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();

        NavigationView mNavigationView = (NavigationView) findViewById(R.id.nv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpDrawercontent(mNavigationView);

        /*Pura yaha tak code hai */

        /*code for spinner*/
        Spinner spinner = (Spinner) findViewById(R.id.department_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.department_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        /**code for spinner**/

        mAuth = FirebaseAuth.getInstance();


    }


    //combined here, taken from below
    @Override

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(mToogle.onOptionsItemSelected(item) )
        {

            switch(item.getItemId())
            {
                case R.id.apply_for_jobs_id :
                   // Log.v("debugging","hi hello");
                    startActivity(new Intent(updateDetails.this,updateDetails.class ));
                    return true;
                default:
                    Log.v("debugging","hi hello");
                    return true;
            }

        }
        else if(item.getItemId() == R.id.logout)
        {
            mAuth.signOut();
            startActivity(new Intent(updateDetails.this, login.class));
            finish();
            return true;
        }
        else
        {
            return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu,menu);
        return true;
    }

    //It is combined above so, not needed
    /*@Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.logout:
                mAuth.signOut();
                startActivity(new Intent(updateDetails.this, login.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    public void selectItemDrawer(MenuItem menuItem)
    {
        android.support.v4.app.Fragment myFragment = null;
        Class fragmentClass;

        switch(menuItem.getItemId())
        {
            case R.id.apply_for_jobs_id :
                fragmentClass = applyforJobs.class;
                break;
            default:
                fragmentClass = applyforJobs.class;
                break;
        }
        try{
             myFragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame,myFragment).commit();
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();
    }
    private void setUpDrawercontent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });
    }

}


