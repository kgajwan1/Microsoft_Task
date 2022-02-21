package com.example.microsoft_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText website,email,pwd,name;
    Button bt;
    TextView moveme;
    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_REGEX);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.et_name);
        website = findViewById(R.id.et_website);
        email = findViewById(R.id.et_email);
        bt = findViewById(R.id.btn_submit);
        pwd = findViewById(R.id.et_password);
        //moveme = findViewById(R.id.move_me);
        //regexes to validate email and password. I can do them via code, but this is more efficient and quicker
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        // an email must be of form a@b.com
        //password must be between 8-20 chars have 1 capital, 1 special and 1 numeric character
        bt.setOnClickListener(view -> {
            //passing multiple lines of data with bundle
            Bundle bundle = new Bundle();
            String message_name = name.getText().toString().trim();
            String message_site = website.getText().toString().trim();
            String message_email = email.getText().toString().trim();
            String pswd = pwd.getText().toString();
            bundle.putString("message", message_name);
            bundle.putString("message2", message_site);
            bundle.putString("message3", message_email);
            Intent intent = new Intent(MainActivity.this,
                    RegistrationComplete.class);
            intent.putExtras(bundle);
            //circumventing billion dollar mistake (nullpointer on name, I could check it on receiver activity, this felt better)
            if(message_name.isEmpty()){
                    if(!pswd.isEmpty() && !message_email.isEmpty() && message_email.matches(emailPattern) && isValidPassword(pswd) ){
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("message2", message_site);
                        bundle2.putString("message3", message_email);
                        Intent intent1 = new Intent(MainActivity.this,
                                NoNameRegister.class);
                        intent1.putExtras(bundle2);
                        startActivity(intent1);
                    }
                    else {
                        Toast.makeText(MainActivity.this,
                                "Valid E-Mail and Password are required !", Toast.LENGTH_SHORT).show();
                    }
            }
            else if(pswd.isEmpty() || message_email.isEmpty()  || !message_email.matches(emailPattern) ||( pswd.length() < 8 &&  !isValidPassword(pswd))){
                Toast.makeText(MainActivity.this,
                        "Valid E-Mail and Password are required !", Toast.LENGTH_SHORT).show();
            }
            else {
                startActivity(intent);
            }
            });

        /*moveme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent temp = new Intent(MainActivity.this,
                        loginScreen.class);
                startActivity(temp);
            }
        });*/
    }
}