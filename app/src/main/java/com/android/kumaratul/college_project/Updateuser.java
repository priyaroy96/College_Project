package com.android.kumaratul.college_project;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Updateuser extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner sp;
    String ar[]={"Delhi","Patna","Ranchi","dhanbad","Kolkata","Mumbai","Biharsharif","Chennai","Jaipur","Kanpur","Bangaleru","Hyderabad","Burdwan"};
    TextView t;
    EditText e1,e2,e3,e4,e5;Button b1;SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateuser);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);
        e5=(EditText)findViewById(R.id.editText5);
        //e6=(EditText)findViewById(R.id.editText6);
        sp=(Spinner)findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);
        final ArrayAdapter aa =
                new ArrayAdapter(this,android.R.layout.simple_spinner_item,ar);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);
        db=openOrCreateDatabase("Kolkata",MODE_PRIVATE,null);
        //db.execSQL("create table IF NOT EXISTS student(name varchar(25),email varchar(40),pass varchar(20),mo varchar(15),address varchar(200))");
        b1=(Button)findViewById(R.id.button8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=e1.getText().toString();
                String e=e2.getText().toString();
                //String Pass=e6.getText().toString();
                String p=e3.getText().toString();
                String m=e4.getText().toString();
                String a=e5.getText().toString();
                db.execSQL("update student set email='"+e+"',mo='"+m+"',pass='"+p+"',address='"+a+"' where name='"+n+"'");
                Intent i1=new Intent(Updateuser.this,Viewrecord.class);
                startActivity(i1);
                Toast.makeText(getApplicationContext(),"You are successfully submitted",Toast.LENGTH_SHORT);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(getApplicationContext(),ar[position],Toast.LENGTH_LONG).show();
        t=(TextView)findViewById(R.id.textView);
        t.setText(ar[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
