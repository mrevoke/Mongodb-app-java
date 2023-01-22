package com.example.mongo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;

public class SignUpActivity extends AppCompatActivity {

    EditText signupEmail, signupPassword;
     Button signupButton;
     TextView loginRedirectText;

    String Apid = "mongo-dvatp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Realm.init(this);
        App app = new App(new AppConfiguration.Builder(Apid).build());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupEmail = findViewById(R.id.signup_email);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
app.getEmailPassword().registerUserAsync(signupEmail.getText().toString(),signupPassword.getText().toString(),it->{
    if (it.isSuccess()) {
    Log.v("user","yessss");

        Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
        startActivity(intent);
    }
    else {
        Log.v("user","ohhh no");

    }
});

//                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                Toast.makeText(SignUpActivity.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
//                            } else {
//                                Toast.makeText(SignUpActivity.this, "SignUp Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    })
                    ;
                }

        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        }); }
}