package com.example.student.ns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import database.DBHelper;

public class MainActivity extends AppCompatActivity {

    EditText txt_userName,txt_password;
    String userNameUI,passwordUI;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_userName = findViewById(R.id.txtUserName);
        txt_password = findViewById(R.id.txtPassword);

        db = new DBHelper(this);
    }
    public void addInfor(View view){
        userNameUI = txt_userName.getText().toString();
        passwordUI = txt_password.getText().toString();

        boolean result =  db.addUser(userNameUI,passwordUI);

        if(result == true){
            Toast.makeText(getApplicationContext(),"Adding Success",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(getApplicationContext(),"Error in Adding User",Toast.LENGTH_LONG).show();
        }
    }
}
