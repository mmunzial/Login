package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    public EditText firstname,lastname,dob,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final Button submit = (Button) findViewById(R.id.submit_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname = findViewById(R.id.firstname_text);
                lastname = findViewById(R.id.lastname_text);
                dob = findViewById(R.id.dob_text);
                email = findViewById(R.id.email_text);
                password = findViewById(R.id.pass_text);

                String firstname_string = firstname.getText().toString();
                String lastname_string = lastname.getText().toString();
                String dob_string = dob.getText().toString();
                String email_string = email.getText().toString();
                String password_string = password.getText().toString();

                String email_regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                String dob_regex =  "^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d$";

                int count = 0;

                if (firstname_string.length()<3 || firstname_string.length()> 30) {
                    Toast.makeText(getApplicationContext(), "First name invalid", Toast.LENGTH_SHORT).show();
                }else{count++;}

                if (lastname_string.length()<2 || lastname_string.length()> 30) {
                    Toast.makeText(getApplicationContext(), "Last name invalid", Toast.LENGTH_SHORT).show();
                }else{count++;}

                if (!dob_string.matches(dob_regex)){
                    Toast.makeText(getApplicationContext(), "Date of Birth invalid", Toast.LENGTH_SHORT).show();

                }else{count++;}


                if (!email_string.matches(email_regex)){
                    Toast.makeText(getApplicationContext(), "Email invalid", Toast.LENGTH_SHORT).show();

                }else{count++;}

                if (password_string.length()<3 || password_string.length()>30){
                    Toast.makeText(getApplicationContext(), "Password Invalid", Toast.LENGTH_SHORT).show();

                }else{count++;}

                if (count == 5){
                    Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_SHORT).show();
                    openMain();

                }
                count = 0;



                }






        });
    }
    public void openMain(){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);

    }

}