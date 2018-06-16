package com.android.kumaratul.college_project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Greencard extends AppCompatActivity {

    private static final int CAMERA_PIC_REQUEST=1111;
    ImageView imageView;
    //private GoogleApiClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greencard);
        imageView=(ImageView)findViewById(R.id.image);
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAMERA_PIC_REQUEST);
        //client=new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==CAMERA_PIC_REQUEST)
        {
            Bitmap thumbnail=(Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(thumbnail);

            ByteArrayOutputStream bytes=new ByteArrayOutputStream();
            thumbnail.compress(Bitmap.CompressFormat.JPEG,100,bytes);

            Date date=new Date();
            String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(date.getTime());
            File file=new File(Environment.getExternalStorageDirectory() +File.separator+"image_"+timestamp+".jpg");
            try {
                file.createNewFile();
                FileOutputStream fo=new FileOutputStream(file);
                fo.write(bytes.toByteArray());
                fo.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        //super.onActivityResult(requestCode, resultCode, data);
    }
}
