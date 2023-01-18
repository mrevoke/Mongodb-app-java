package com.example.mongo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;

public class LoginActivity extends AppCompatActivity {
    String Apid = "mongo-dvatp";







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Realm.init(this);
        App app = new App(new AppConfiguration.Builder(Apid).build());
        EditText email = findViewById(R.id.login_email);
        EditText pass = findViewById(R.id.login_password);
        Button lbut = findViewById(R.id.login_button);
        TextView fpw = findViewById(R.id.signUpRedirectText);
        fpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

       lbut.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Credentials credentials = Credentials.emailPassword(email.getText().toString(),pass.getText().toString());
               app.loginAsync(credentials, new App.Callback<User>() {


                   @Override
                   public void onResult(App.Result<User> result) {
                       if (result.isSuccess()){
                           Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                           startActivity(intent);
                           Log.v("user","okkkk");
                       }
                       else {
                           Log.v("user","ohhhhh");

                       }
                   }   });
           }


});
    }
}