package com.android.kumaratul.college_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Management extends AppCompatActivity {
    SQLiteDatabase db;
    EditText e1,e2;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
        db=openOrCreateDatabase("atul",MODE_PRIVATE,null);
        db.execSQL("create table IF NOT EXISTS management(name varchar(20),pass varchar(20),address varchar(20))");
        e1=(EditText)findViewById(R.id.editText12);
        e2=(EditText)findViewById(R.id.editText13);
        b1=(Button)findViewById(R.id.button11);
        b2=(Button)findViewById(R.id.button12);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=e1.getText().toString();
                String p=e2.getText().toString();
                Cursor c=db.rawQuery("Select name,pass from management where name='"+n+"' and pass='"+p+"'",null);
                if (c.moveToNext())
                {
                    Intent i=new Intent(Management.this,Viewmanagement.class);
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
                Intent i1=new Intent(Management.this,Reg.class);
                startActivity(i1);

            }
        });

    }
}
