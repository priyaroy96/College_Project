package com.android.kumaratul.college_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    EditText e;TextView t;CalendarView c;TextClock p;
    Button b;Calendar c1= Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e=(EditText)findViewById(R.id.editText);
        t=(TextView)findViewById(R.id.textView);
        c=(CalendarView)findViewById(R.id.calendarView);
        p=(TextClock)findViewById(R.id.textClock);

        b=(Button)findViewById(R.id.butt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=c1.get(Calendar.HOUR_OF_DAY); String s2="";
                if ( i>=0 && i<12)
                {
                    s2="Good Morning   ";
                }
                else if (i>=12 && i<16)
                {
                    s2="Good Afternoon  ";
                }
                else if (i>=16 && i<19)
                {
                    s2="Good Evening  ";
                }
                else if (i>=19 && i<23)
                {
                    s2="Good Night ";
                }

                String s3=e.getText().toString();
                String s4="\n"+"It's "+c1.get(Calendar.HOUR_OF_DAY)+"'o clock";
                String s=s2+s3+s4;
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                Intent C=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(C);

            }
        });


    }
}
