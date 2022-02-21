package com.example.microsoft_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationComplete extends AppCompatActivity {
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_complete);
        //get and put data here
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String name = bundle.getString("message");
            String website = bundle.getString("message2");
            String mail = bundle.getString("message3");
            TextView nameplace = findViewById(R.id.tv_logo);
            TextView webplace = findViewById(R.id.web_placeholder);
            TextView emailaddress = findViewById(R.id.mail_placeholder);
            TextView name2 = findViewById(R.id.name_placeholder);
            emailaddress.setText(mail);
            name2.setText(name);
            if(name.isEmpty()) nameplace.setText("Hello, null!");
            else nameplace.setText("Hello, "  + name + "!");
            webplace.setText(website);
        }

        signin = findViewById(R.id.btn_register);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent(RegistrationComplete.this,loginScreen.class);
                startActivity(intent);*/
                Toast.makeText(RegistrationComplete.this,
                        "This button does nothing!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}