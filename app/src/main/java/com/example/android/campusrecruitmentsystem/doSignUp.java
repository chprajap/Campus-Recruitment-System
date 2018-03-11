package com.example.android.campusrecruitmentsystem;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.campusrecruitmentsystem.R;
import com.example.android.campusrecruitmentsystem.login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class doSignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText mUserFullName;
    private EditText mUserName;
    private EditText mUserId;
    private EditText mUserEmailId;
    private EditText mUserContactNo;
    private EditText mUserPassword;
    private EditText mUserConfirmPassword;
    private Button mSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_sign_up);

        /**code for spinner**/
        Spinner spinner = (Spinner) findViewById(R.id.signup_spinner_id);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.signup_spinner_id, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        /**code for spinner**/

        mAuth = FirebaseAuth.getInstance();

        mUserFullName = (EditText) findViewById(R.id.UserFullName);
        mUserName = (EditText) findViewById(R.id.Username);
        mUserId = (EditText) findViewById(R.id.userId);
        mUserEmailId = (EditText) findViewById(R.id.userEmailId);
        mUserContactNo = (EditText) findViewById(R.id.userContactNo);
        mUserPassword = (EditText) findViewById(R.id.userPassword);
        mUserConfirmPassword = (EditText) findViewById(R.id.userConfirmPassword);
        mSignUpButton = (Button) findViewById(R.id.signUpButton);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mUserEmailId.getText().toString();
                String password = mUserPassword.getText().toString();
                String confirmPassword = mUserConfirmPassword.getText().toString();

                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirmPassword))
                {
                    if(password.equals(confirmPassword))
                    {
                        // bhai phod diya aur tu ab tera register ho sakta hai

                        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    Intent i = new Intent(doSignUp.this,login.class);
                                    startActivity(i);
                                    finish();
                                }
                                else
                                {
                                    String errorMessage = task.getException().getMessage();
                                    Toast.makeText(doSignUp.this,"Error: "+errorMessage,Toast.LENGTH_LONG);
                                }
                            }
                        });
                    }
                    else
                    {
                        Toast.makeText(doSignUp.this, "Confirm Password & Password doesn't match",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null)
        {
            // kuch to karenge
        }
    }
}
