package com.android.kumaratul.college_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity2 extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2,b3,b4;SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        db=openOrCreateDatabase("Kolkata",MODE_PRIVATE,null);
        db.execSQL("create table IF NOT EXISTS student(name varchar(25),email varchar(40),pass varchar(20),mobile varchar(15),address varchar(100))");
        e1=(EditText)findViewById(R.id.editText7);
        e2=(EditText)findViewById(R.id.editText8);
        b1=(Button)findViewById(R.id.button4);
        b2=(Button)findViewById(R.id.button5);
        b3=(Button)findViewById(R.id.button6);
        b4=(Button)findViewById(R.id.button7);

       // db.execSQL("create table IF NOT EXISTS student(email varchar(40),pass varchar(20))");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = e1.getText().toString();
                String p= e2.getText().toString();
                Cursor c=db.rawQuery("Select email,pass from student where email='"+e+"' and pass='"+p+"'",null);
                if (c.moveToNext())
                {
                    Intent i=new Intent(LoginActivity2.this,Viewrecord.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login fail please enter the correct password",Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(LoginActivity2.this,Usersignup.class);
                startActivity(i2);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(LoginActivity2.this,Email.class);
                startActivity(i3);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:8409946881"));
                startActivity(I1);
            }
        });


    }
}
