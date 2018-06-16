package com.android.kumaratul.college_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Viewmanagement extends AppCompatActivity {
    Button b1,b2,b3;TextView t1;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewrecord);
        b1=(Button)findViewById(R.id.button14);
        b2=(Button)findViewById(R.id.button15);
        b3=(Button)findViewById(R.id.button16);
        db=openOrCreateDatabase("atul",MODE_PRIVATE,null);
        t1=(TextView)findViewById(R.id.textView4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=db.rawQuery("select *from management",null);
                String data="Management record is:=.....";
                while (c.moveToNext())
                {
                    data=data+c.getString(0)+"  "+c.getString(1)+"  "+c.getString(2)+"\n";
                }
                t1.setText(data);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Viewmanagement.this,Updatemanagement.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Viewmanagement.this,Deletemanagement.class);
                startActivity(i);
            }
        });
    }
}
