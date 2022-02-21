package com.example.microsoft_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NoNameRegister extends AppCompatActivity {

    Button signin;
    //active if no name recieved
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_name_register);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String website = bundle.getString("message2");
            String mail = bundle.getString("message3");
            TextView webplace = findViewById(R.id.web_placeholder);
            TextView emailaddress = findViewById(R.id.mail_placeholder);
            emailaddress.setText(mail);
            webplace.setText(website);
        }

        signin = findViewById(R.id.btn_register);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent(NoNameRegister.this,loginScreen.class);
                startActivity(intent);*/
                Toast.makeText(NoNameRegister.this,
                        "This button does nothing!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}