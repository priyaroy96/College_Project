package com.android.kumaratul.college_project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends AppCompatActivity {
    EditText to,subject,message;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        to=(EditText)findViewById(R.id.editText9);
        subject=(EditText)findViewById(R.id.editText10);
        message=(EditText)findViewById(R.id.editText11);
        b=(Button)findViewById(R.id.button9);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=to.getText().toString();
                String s=subject.getText().toString();
                String m=message.getText().toString();

                Intent email=new Intent(Intent.ACTION_SENDTO);
                String uriText="mailto:"+t+
                        "?subject=" + Uri.encode(s) +
                        "&body=" + Uri.encode(m);
                Uri uri =Uri.parse(uriText);

                email.setData(uri);
                startActivity(Intent.createChooser(email,"Send Email"));
            }
        });
    }
}
