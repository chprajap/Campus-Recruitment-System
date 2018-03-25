package com.example.chetan.campusrecruitmentsystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class doSignUp extends AppCompatActivity {

    /*private FirebaseAuth mAuth;
    private DatabaseReference rootRef;
    private DatabaseReference userRef;
    private EditText mUserFullName;
    private EditText mUserName;
    private EditText mUserId;
    private EditText mUserEmailId;
    private EditText mUserContactNo;
    private EditText mUserPassword;
    private EditText mUserConfirmPassword;
    private Button mSignUpButton;
    private String email;
    private String password;
    private String confirmPassword;
    private Spinner spinner;
    private String s;
*/
    /*private FirebaseAuth mAuth;
    private DatabaseReference rootRef;
    private DatabaseReference userRef;*/
    private EditText mUserFullName;
    private EditText mUserName;
    private EditText mUserId;
    private EditText mUserEmailId;
    private EditText mUserContactNo;
    private EditText mUserPassword;
    private EditText mUserConfirmPassword;
    private Button mSignUpButton;
    private String email;
    private String password;
    private String confirmPassword;
    private Spinner spinner;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_sign_up);

  //      mAuth = FirebaseAuth.getInstance();

        /*mUserFullName = (EditText) findViewById(R.id.UserFullName);
        mUserName = (EditText) findViewById(R.id.Username);
        mUserId = (EditText) findViewById(R.id.userId);
        mUserEmailId = (EditText) findViewById(R.id.userEmailId);
        mUserContactNo = (EditText) findViewById(R.id.userContactNo);
        mUserPassword = (EditText) findViewById(R.id.userPassword);
        mUserConfirmPassword = (EditText) findViewById(R.id.userConfirmPassword);*/
        mUserFullName = (EditText) findViewById(R.id.UserFullName);
        mUserName = (EditText) findViewById(R.id.Username);
        mUserId = (EditText) findViewById(R.id.userId);
        mUserEmailId = (EditText) findViewById(R.id.userEmailId);
        mUserContactNo = (EditText) findViewById(R.id.userContactNo);
        mUserPassword = (EditText) findViewById(R.id.userPassword);
        mUserConfirmPassword = (EditText) findViewById(R.id.userConfirmPassword);


        /**code for spinner**/
        final Spinner spinner = (Spinner) findViewById(R.id.signup_spinner_id);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(doSignUp.this,R.array.signup_spinner_id,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                s = adapterView.getSelectedItem().toString();
                Log.v("string",s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mSignUpButton = (Button) findViewById(R.id.signUpButton);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mUserFullName.getText().toString().isEmpty())
                {
                    mUserFullName.requestFocus();
                    mUserFullName.setError("Full Name is required");
                    return;
                }
                if(mUserName.getText().toString().isEmpty())
                {
                    mUserName.requestFocus();
                    mUserName.setError("UserName is required");
                    return;
                }
                if(mUserId.getText().toString().isEmpty())
                {
                    mUserId.requestFocus();
                    mUserId.setError("UserId is required");
                    return;
                }


                email = mUserEmailId.getText().toString();
                password = mUserPassword.getText().toString();
                confirmPassword = mUserConfirmPassword.getText().toString();

                if(email.isEmpty()){
                    mUserEmailId.requestFocus();
                    mUserEmailId.setError("email id is required");
                    return;

                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    mUserEmailId.requestFocus();
                    mUserEmailId.setError("Enter  a valid email id");
                    return;
                }

                if(mUserContactNo.getText().toString().isEmpty())
                {
                    mUserContactNo.requestFocus();
                    mUserContactNo.setError("User Contact No is required");
                    return;
                }

                if(password.isEmpty()){
                    mUserPassword.requestFocus();
                    mUserPassword.setError("Password is required");
                    return;
                }

                if(confirmPassword.length()<6)
                {
                    mUserConfirmPassword.requestFocus();
                    mUserConfirmPassword.setError("Password length must be minimum 6");
                    return;
                }
                Log.v("password",password);
                Log.v("cpassword",confirmPassword);
                if(password.equals(confirmPassword)) {
                    // bhai phod diya aur tu ab tera register ho sakta hai

                    if (s.equals("Student")) {
                        /*mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    rootRef= FirebaseDatabase.getInstance().getReference().child("Student");
                                    *//*DatabaseReference userRef = rootRef.child(mAuth.getCurrentUser().getUid());
                                    userRef.child("Email Id").setValue(email)*//*;
                                    Intent i = new Intent(doSignUp.this,login.class);
                                    startActivity(i);
                                    finish();
                                }
                                else
                                {
                                    if(task.getException() instanceof FirebaseAuthEmailException)
                                    {
                                        Toast.makeText(getApplicationContext(),"User already registered",Toast.LENGTH_SHORT).show();
                                        return ;
                                    }
                                    else
                                    {
                                        String errorMessage = task.getException().getMessage();
                                        Toast.makeText(doSignUp.this,"Error: "+errorMessage,Toast.LENGTH_LONG);
                                        return;
                                    }

                                }
                            }
                        });*/

                        /*StudentContact c = new StudentContact();
                        c.setName(mUserFullName.getText().toString());
                        c.setUname(mUserName.getText().toString());
                        c.setUid(mUserId.getText().toString());
                        c.setEmailId(mUserEmailId.getText().toString());
                        c.setContactNo(mUserContactNo.getText().toString());
                        c.setPassword(mUserPassword.getText().toString());
                        DatabaseHelper helper = new DatabaseHelper(doSignUp.this);
                        helper.insertStudentContact(c);
                        startActivity(new Intent(getApplicationContext(),login.class));*/
                        StudentContact c = new StudentContact();
                        c.setName(mUserFullName.getText().toString());
                        c.setUname(mUserName.getText().toString());
                        c.setUid(mUserId.getText().toString());
                        c.setEmailId(mUserEmailId.getText().toString());
                        c.setContactNo(mUserContactNo.getText().toString());
                        c.setPassword(mUserPassword.getText().toString());
                        DatabaseHelper helper = new DatabaseHelper(doSignUp.this);
                        helper.insertStudentContact(c);
                        startActivity(new Intent(getApplicationContext(),login.class));
                    }
                    else if(s.equals("Company"))
                    {
                        /*mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    rootRef= FirebaseDatabase.getInstance().getReference().child("Company");
                                    *//**//*DatabaseReference userRef = rootRef.child(mAuth.getCurrentUser().getUid());
                                    userRef.child("Email Id").setValue(email);*//**//*
                                    Intent i = new Intent(doSignUp.this,loginCompany.class);
                                    startActivity(i);
                                    finish();
                                }
                                else
                                {
                                    if(task.getException() instanceof FirebaseAuthEmailException)
                                    {
                                        Toast.makeText(getApplicationContext(),"User already registered",Toast.LENGTH_SHORT).show();
                                        return ;
                                    }
                                    else
                                    {
                                        String errorMessage = task.getException().getMessage();
                                        Toast.makeText(doSignUp.this,"Error: "+errorMessage,Toast.LENGTH_LONG);
                                        return;
                                    }

                                }
                            }
                        });*/
                        /*CompanyContact c = new CompanyContact();
                        c.setName(mUserFullName.getText().toString());
                        c.setUname(mUserName.getText().toString());
                        c.setUid(mUserId.getText().toString());
                        c.setEmailId(mUserEmailId.getText().toString());
                        c.setContactNo(mUserContactNo.getText().toString());
                        c.setPassword(mUserPassword.getText().toString());
                        DatabaseHelperCompany helper = new DatabaseHelperCompany(doSignUp.this);
                        helper.insertCompanyContact(c);
                        startActivity(new Intent(getApplicationContext(),loginCompany.class));*/
                        CompanyContact c = new CompanyContact();
                        c.setName(mUserFullName.getText().toString());
                        c.setUname(mUserName.getText().toString());
                        c.setUid(mUserId.getText().toString());
                        c.setEmailId(mUserEmailId.getText().toString());
                        c.setContactNo(mUserContactNo.getText().toString());
                        c.setPassword(mUserPassword.getText().toString());
                        DatabaseHelperCompany helper = new DatabaseHelperCompany(doSignUp.this);
                        helper.insertCompanyContact(c);
                        startActivity(new Intent(getApplicationContext(),loginCompany.class));
                    }
                    else if(s.equals("Admin"))
                    {
                        /*mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    FirebaseDatabase.getInstance().getReference().addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            if(dataSnapshot.hasChild("Admin"))
                                            {
                                                spinner.requestFocus();
                                                Toast.makeText(getApplicationContext(), "Admin already exists", Toast.LENGTH_LONG).show();
                                                return;
                                            }
                                            else
                                            {
                                                rootRef= FirebaseDatabase.getInstance().getReference().child("Admin");
                                    *//**//*DatabaseReference userRef = rootRef.child(mAuth.getCurrentUser().getUid());
                                    userRef.child("Email Id").setValue(email);*//**//*
                                                Intent i = new Intent(doSignUp.this,loginAdmin.class);
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
                                    if(task.getException() instanceof FirebaseAuthEmailException)
                                    {
                                        Toast.makeText(getApplicationContext(),"User already registered",Toast.LENGTH_SHORT).show();
                                        return ;
                                    }
                                    else
                                    {
                                        String errorMessage = task.getException().getMessage();
                                        Toast.makeText(doSignUp.this,"Error: "+errorMessage,Toast.LENGTH_LONG);
                                        return;
                                    }

                                }
                            }
                        });
                    }*/
                        /*AdminContact c = new AdminContact();
                        c.setName(mUserFullName.getText().toString());
                        c.setUname(mUserName.getText().toString());
                        c.setUid(mUserId.getText().toString());
                        c.setEmailId(mUserEmailId.getText().toString());
                        c.setContactNo(mUserContactNo.getText().toString());
                        c.setPassword(mUserPassword.getText().toString());
                        DatabaseHelperAdmin helper = new DatabaseHelperAdmin(doSignUp.this);
                        helper.insertAdminContact(c);
                        startActivity(new Intent(getApplicationContext(),loginAdmin.class));*/
                        AdminContact c = new AdminContact();
                        c.setName(mUserFullName.getText().toString());
                        c.setUname(mUserName.getText().toString());
                        c.setUid(mUserId.getText().toString());
                        c.setEmailId(mUserEmailId.getText().toString());
                        c.setContactNo(mUserContactNo.getText().toString());
                        c.setPassword(mUserPassword.getText().toString());
                        DatabaseHelperAdmin helper = new DatabaseHelperAdmin(doSignUp.this);
                        helper.insertAdminContact(c);
                        startActivity(new Intent(getApplicationContext(),loginAdmin.class));
                    }
                }
                else
                {
                    Toast.makeText(doSignUp.this, "Confirm Password & Password doesn't match",Toast.LENGTH_LONG).show();
                }

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        /*FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null)
        {
            // kuch to karenge
        }*/
    }
}
