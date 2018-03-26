package com.example.chetan.campusrecruitmentsystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class loginCompany extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference rootRef;
    private EditText loginEmailText;
    private EditText loginPasswordText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_company);

        mAuth = FirebaseAuth.getInstance();
        loginEmailText = (EditText) findViewById(R.id.userEmail);
        loginPasswordText = (EditText) findViewById(R.id.userPassword);
        loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String loginEmail = loginEmailText.getText().toString();
                String loginPassword = loginPasswordText.getText().toString();

                if(loginEmail.isEmpty())
                {
                    loginEmailText.requestFocus();
                    loginEmailText.setError("Email id is required");
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(loginEmail).matches())
                {
                    loginEmailText.requestFocus();
                    loginEmailText.setError("Enter a valid email id");
                    return;
                }

                if(loginPassword.isEmpty())
                {
                    loginPasswordText.requestFocus();
                    loginPasswordText.setError("Password is required");
                    return;
                }
                if(loginPassword.length()<6)
                {
                    loginPasswordText.requestFocus();
                    loginPasswordText.setError("Password length must be minimum 6");
                    return;
                }

                mAuth.signInWithEmailAndPassword(loginEmail, loginPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            rootRef= FirebaseDatabase.getInstance().getReference().child("Company");

                            rootRef.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.hasChild(mAuth.getCurrentUser().getUid()))
                                    {
                                        Intent i = new Intent(loginCompany.this, CompanyNavBar.class);
                                        startActivity(i);
                                        finish();
                                    }
                                    else
                                    {
                                        Log.v("Tag","hi");
                                        Intent i = new Intent(loginCompany.this, CompanyUpdateDetailsNavBar.class);
                                        startActivity(i);
                                        finish();
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });

                        }
                        else
                        {
                            String errorMessage = task.getException().getMessage();
                            Toast.makeText(loginCompany.this, "Error: " + errorMessage, Toast.LENGTH_LONG ).show();
                        }
                    }
                });

            }
        });

    }
}
