package com.android.kumaratul.college_project;

import android.Manifest;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.MapView;

public class MainActivity extends AppCompatActivity{

    Button b1,b2,b3;MapView m;TextView t1;LocationManager lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        t1=(TextView)findViewById(R.id.textView2);
        m=(MapView)findViewById(R.id.mapView);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,LoginActivity2.class);
                startActivity(i1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(MainActivity.this,Management.class);
                startActivity(i2);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(MainActivity.this,MapsActivity.class);
                startActivity(i3);
            }
        });
        MyListener l = new MyListener();
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lm.requestLocationUpdates(lm.GPS_PROVIDER, 0, 0, l);
    }
    class  MyListener implements LocationListener
    {

        @Override
        public void onLocationChanged(Location location) {
            t1.setText("Longitude="+location.getLongitude()+"\nLattitude="+location.getLatitude());

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            //Toast.makeText(getApplicationContext(),"GPS unable to fetch location",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderEnabled(String provider) {
            Toast.makeText(getApplicationContext(),"GPS ENABLED",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(getApplicationContext(),"GPS DISABLED",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.red:
                Intent i4=new Intent(MainActivity.this,Garbagecard.class);
                startActivity(i4);
                break;
            case R.id.green:
                Intent i5=new Intent(MainActivity.this,Greencard.class);
                Toast.makeText(getApplicationContext(),"TAKE A SELFIE WITH PLANT AND OUR STAFF",Toast.LENGTH_LONG).show();
                startActivity(i5);
                break;
            case R.id.black:
                Intent i6=new Intent(MainActivity.this,Benefits.class);
                startActivity(i6);
                break;
            case R.id.brown:
                Intent i7=new Intent(MainActivity.this,Aboutus.class);
                startActivity(i7);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
