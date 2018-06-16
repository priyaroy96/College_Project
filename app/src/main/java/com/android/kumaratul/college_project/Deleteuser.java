package com.android.kumaratul.college_project;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Deleteuser extends AppCompatActivity {
    EditText e;
    Button b;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteuser);
        db=openOrCreateDatabase("Kolkata",MODE_PRIVATE,null);
        e=(EditText)findViewById(R.id.editText18);
        b=(Button)findViewById(R.id.button21);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=e.getText().toString();
                db.execSQL("delete from student where name='"+n+"'");
                Intent i=new Intent(Deleteuser.this,Viewrecord.class);
                startActivity(i);

            }
        });
    }
}
