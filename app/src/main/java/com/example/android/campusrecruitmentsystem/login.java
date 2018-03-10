package com.example.android.campusrecruitmentsystem;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.campusrecruitmentsystem.R;
import com.example.android.campusrecruitmentsystem.updateDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText loginEmailText;
    private EditText loginPasswordText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        mAuth = FirebaseAuth.getInstance();
        loginEmailText = (EditText) findViewById(R.id.userEmail);
        loginPasswordText = (EditText) findViewById(R.id.userPassword);
        loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String loginEmail = loginEmailText.getText().toString();
                String loginPassword = loginPasswordText.getText().toString();
                if(!TextUtils.isEmpty(loginEmail) && !TextUtils.isEmpty((loginPassword)))
                {
                    mAuth.signInWithEmailAndPassword(loginEmail, loginPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Intent i = new Intent(login.this, updateDetails.class);
                                startActivity(i);
                                finish();
                            }
                            else
                            {
                                String errorMessage = task.getException().getMessage();
                                Toast.makeText(login.this, "Error: " + errorMessage, Toast.LENGTH_LONG ).show();
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser =  mAuth.getCurrentUser();

    }
}
