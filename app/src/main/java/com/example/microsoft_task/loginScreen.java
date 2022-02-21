package com.example.microsoft_task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginScreen extends AppCompatActivity {
    EditText mail,pwd;
    Button btn;
    //just a standard copy paste
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        mail = findViewById(R.id.et_signin_email);
        pwd = findViewById(R.id.et_signin_password);
        btn = findViewById(R.id.btn_login2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(loginScreen.this,
                        "This button does nothing!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}