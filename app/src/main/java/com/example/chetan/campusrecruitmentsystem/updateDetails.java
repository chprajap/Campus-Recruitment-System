package com.example.chetan.campusrecruitmentsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class updateDetails extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private DatabaseReference rootRef;
    private DatabaseReference userRef;
    private EditText mfullName;
    private EditText mUsername;
    private EditText mUserId;
    private EditText mEmailId;
    private EditText mContactNo;
    private EditText mAddress;
    private EditText mSSC;
    private EditText mHSC;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatestudentdetails);

        mAuth = FirebaseAuth.getInstance();
        rootRef=FirebaseDatabase.getInstance().getReference().child("users");

        mfullName = (EditText) findViewById(R.id.updateName);
        mUsername = (EditText) findViewById(R.id.updateUsername);
        mUserId = (EditText) findViewById(R.id.updateUserId);
        mEmailId = (EditText) findViewById(R.id.updateEmailId);
        mContactNo = (EditText) findViewById(R.id.updateContactNo);
        mAddress = (EditText) findViewById(R.id.updateAddress);
        mSSC = (EditText) findViewById(R.id.updateSSC);
        mHSC = (EditText) findViewById(R.id.updateHSC);
        mButton = (Button) findViewById(R.id.update_profile_button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(mfullName.getText().toString(),mUsername.getText().toString(),mUserId.getText().toString(),mEmailId.getText().toString(),mContactNo.getText().toString(),mAddress.getText().toString(),mSSC.getText().toString(),mHSC.getText().toString());
                DatabaseReference userRef = rootRef.child(mAuth.getCurrentUser().getUid());
                userRef.child("Full Name").setValue(mfullName.getText().toString());
                userRef.child("UserName").setValue(mUsername.getText().toString());
                userRef.child("User Id").setValue(mUserId.getText().toString());
                userRef.child("Email Id").setValue(mEmailId.getText().toString());
                userRef.child("Contact No").setValue(mContactNo.getText().toString());
                userRef.child("Address").setValue(mAddress.getText().toString());
                userRef.child("SSC").setValue(mSSC.getText().toString());
                userRef.child("HSC").setValue(mHSC.getText().toString());
                //childRef.setValue(mfullName);
                startActivity(new Intent(updateDetails.this,StudentMainActivity.class));
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu,menu);
        return true;
    }

    @Override
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
    }
}

