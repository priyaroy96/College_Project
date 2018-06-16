package com.android.kumaratul.college_project;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Updatemanagement extends AppCompatActivity {

    EditText et1,et2,et3;
    Button b;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatemanagement);
        db=openOrCreateDatabase("atul",MODE_PRIVATE,null);
        et1=(EditText)findViewById(R.id.editText14);
        et2=(EditText)findViewById(R.id.editText15);
        et3=(EditText)findViewById(R.id.editText16);
        b=(Button)findViewById(R.id.button13);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=et1.getText().toString();
                String p=et2.getText().toString();
                String a=et3.getText().toString();

                db.execSQL("update management set pass='"+p+"',address='"+a+"' where name='"+n+"'");
                Intent i=new Intent(Updatemanagement.this,Viewmanagement.class);
                startActivity(i);

            }
        });

    }
}
