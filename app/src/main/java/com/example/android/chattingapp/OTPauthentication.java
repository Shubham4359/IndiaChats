package com.example.android.chattingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.api.Authentication;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OTPauthentication extends AppCompatActivity {
    TextView mchangenumber;
    EditText mgetotp;
    android.widget.Button mverifyotp;
    String enteredotp;

    FirebaseAuth firebaseAuth;
    ProgressBar mprogressbarofotpauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpauthentication);
        mchangenumber=findViewById(R.id.changenumber);
        mgetotp=findViewById(R.id.enterotp);
        mverifyotp=findViewById(R.id.verifyotp);
        firebaseAuth=FirebaseAuth.getInstance();
        mprogressbarofotpauth=findViewById(R.id.progressbarofotpauth);
        mchangenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(OTPauthentication.this,MainActivity.class);
                startActivity(intent);
            }
        });
        mverifyotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            enteredotp=mgetotp.getText().toString();
            if(enteredotp.isEmpty()){
                Toast.makeText(getApplicationContext(),"Enter The OTP first",Toast.LENGTH_SHORT).show();
            }
            else{
                mprogressbarofotpauth.setVisibility(View.VISIBLE);
                String coderecieved=getIntent().getStringExtra("otp");
                //as both text are in different formats so we need to check are the same use firebase authentical crendential function
                PhoneAuthCredential credential= PhoneAuthProvider.getCredential(coderecieved,enteredotp);
                signInWithPhoneAuthCredential(credential);
            }
            }
        });
    }
    //if the credential or otp sent and received same the task is succesfull so move from otp acticvity to setprofile activity
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential)
    {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    mprogressbarofotpauth.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(),"Login sucess",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(OTPauthentication.this,setprofile.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    if(task.getException() instanceof FirebaseAuthInvalidCredentialsException)
                    {
                        mprogressbarofotpauth.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




    }
}