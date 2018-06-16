package com.android.kumaratul.college_project;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Aboutus extends AppCompatActivity {
    TextView t1,t2;RatingBar r;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        t1=(TextView)findViewById(R.id.textView7);
        t2=(TextView)findViewById(R.id.textView8);
        String data="Goo green is the initiative taken to clean our environment and" +
                " today we are living in one of worst polluted areas...Government is not the responsible one to clean the environment," +
                "we all are the responsible to this worst scenario.So,this is our one step initiated by me to clean our country." +
                "LET'S COME AND JOIN 'Goo green' ";
        t1.setText(data);
        r=(RatingBar)findViewById(R.id.ratingBar);
        b=(Button)findViewById(R.id.button24);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=String.valueOf(r.getRating());
                s="Your rating is:-"+s+"\n"+"THANK YOU SO MUCH";
                t2.setText(s);
                android.support.v4.app.NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplication()).setSmallIcon(R.drawable.pic1)
                        .setContentTitle("Goo green").setContentText("Thanks for the rating,collect the points ,enjoy benefits and make india clean with Goo green");
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent contentIntent=PendingIntent.getActivity(getApplicationContext(),0,i,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(contentIntent);
                NotificationManager manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0,builder.build());
            }
        });
    }
}
