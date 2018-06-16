package com.android.kumaratul.college_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Benefits extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benefits);
        t1=(TextView)findViewById(R.id.textView6);
        String data="Benefits:-"+"\n"+"1.benefits of green card is 5% discount on the hospitals."+"\n"
                +"2.benefits of garbage card is purchase anything from our store worth(4points =Re.1)"+"\n"
                +"3.you will have clean environment(HEALTH IS WEALTH)"+"\n"
                +"4.No extra charges to receive the garbage"+"\n"+"\n"
                +"Instructions:-"+"\n"
                +"1.For green card you have to do sapling and you have to purchase one  plant health device from our store and device should be connected to plant."+"\n"
                +"2.Our staffs will visit on plant site on the regular basis and you have to take the photographs and submit it on the whatsapp no.8409946881."+"\n"
                +"3.If plant found in the bad circumstances,there would be deduction in the points from garbage card."+"\n"
                +"4.For garbage card you have to call us or email us,our staffs would be there within 2 hours and collect the garbage from you."+"\n"
                +"5.You can give max of 30kg garbage at a time.you have to give 10kg from one garbage type(INDUSTRIAL,PLASTICS,ORGANIC,METALLIC)"+"\n"
                +"6.Garbage types would be decided by our staffs only.points(garbage card) will updated within 24 hours after submission and the message to us.";
        t1.setText(data);
    }
}
