package com.example.student.ns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import database.DBHelper;

public class MainActivity extends AppCompatActivity {

    EditText txt_userName,txt_password;
    String userNameUI,passwordUI;
    DBHelper db;
    Button deleteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_userName = findViewById(R.id.txtUserName);
        txt_password = findViewById(R.id.txtPassword);


        db = new DBHelper(this);
        deleteBtn = findViewById(R.id.btnDelete);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = db.deleteUser(txt_userName.getText().toString());
                if (result == 1) {
                    Toast.makeText(getApplicationContext(), "Delete Success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Delete Error", Toast.LENGTH_LONG).show();
                }
            }
        });

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
    public void getAllUsers(){
        List usernames = db.readAllInfor();
        for (int i=0; i<usernames.size(); i++){
            Log.i("AAAA","user "+i+ " : "+ usernames.get(i));
        }
    }
    public void updateUser (View view){
        userNameUI = txt_userName.getText().toString();
        passwordUI = txt_password.getText().toString();

        //Continued
    }
}
