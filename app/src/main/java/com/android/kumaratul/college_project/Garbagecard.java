package com.android.kumaratul.college_project;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Garbagecard extends AppCompatActivity {

    CheckBox c,p,b,t;TextView t1;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garbagecard);
        c=(CheckBox)findViewById(R.id.checkBox);
        p=(CheckBox)findViewById(R.id.checkBox2);
        b=(CheckBox)findViewById(R.id.checkBox3);
        t=(CheckBox)findViewById(R.id.checkBox4);
        b1=(Button)findViewById(R.id.button22);
        b2=(Button)findViewById(R.id.button23);
        t1=(TextView)findViewById(R.id.textView3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalamount = 0;
                StringBuilder result = new StringBuilder();
                result.append("\n"+"your waste products and points: "+"\n");
                if (p.isChecked()) {
                    result.append("INDUSTRIAL 100 POINTS"+"\n");
                    totalamount += 100;
                }
                if (c.isChecked())
                {
                    result.append("PLASTICS 20 POINTS"+"\n");
                    totalamount += 20;
                }
                if (b.isChecked())
                {
                    result.append("ORGANIC 50 POINTS"+"\n");
                    totalamount +=50;
                }
                if (t.isChecked())
                {
                    result.append("METALLIC 125 POINTS"+"\n");
                    totalamount +=125;
                }
                result.append("\nTotal: "+totalamount +"POINTS");
                String data="WELL YOU HAVE COLLECTED SO MUCH POINTS";
                String data1="\n"+"        THANK YOU SO MUCH     "+"\n"+"Terms & conditions :-"+"\n"
                        +"1.you can give 10kg of similar type of garbage at a time."+"\n"
                        +"2.you can give max30kg total garbage."+"\n"
                        +"3.After your garbage collected by staffs we will reflect the points in your card within 24 hours."+"\n"
                        +"4.If you have more query then you can call us at morning 6:00 am to 6:00 pm."+"\n"
                        +"5.please give your registered number to our staffs and message us by your registered number"+"\n";
                data=data+result.toString()+data1;
                t1.setText(data);




            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplication()).setSmallIcon(R.drawable.pic1)
                        .setContentTitle("Goo green").setContentText("Collect the points and have more benefits");
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent contentIntent=PendingIntent.getActivity(getApplicationContext(),0,i,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(contentIntent);
                NotificationManager manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0,builder.build());
                Intent I2=new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:8409946881"));
                I2.putExtra("sms_body","I had sent garbage by your staff ...please update my points");
                startActivity(I2);
            }
        });

    }
}
