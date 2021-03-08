package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    public EditText email_text,pass_text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button login_button = (Button) findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email_text = findViewById(R.id.email_text);
                pass_text2 = findViewById(R.id.pass_text2);

                String email2_string = email_text.getText().toString();
                String pass_text2_string = pass_text2.getText().toString();

                if (email2_string.equals("mmunzial@gmail.com") && (pass_text2_string.equals("password"))){
                    Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                    loggedin();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public void loggedin(){
        Intent loginsuccess = new Intent(this, LoggedIn.class);
        startActivity(loginsuccess);
    }
}