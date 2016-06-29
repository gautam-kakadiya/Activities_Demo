package com.example.sysadmin.activitiesdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhotoCaptureActivity extends AppCompatActivity implements PhotoDisplayFrag.OnActivityCreatedSuccessfully {
    private static final int PHOTO_REQUEST_CODDE = 1 ;
    private static final String PHOTO_FRAG_TAG = "photofrag";
    String mCurrentPhotoPath;
    Button takephoto;
    PhotoDisplayFrag photofrag=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_capture);
        takephoto = (Button) findViewById(R.id.takepic);
    }

    public void takePicture(View v){
        File photoFile = null;
        try {
            photoFile=createImageFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Uri photoUri = FileProvider.getUriForFile(this,"com.example.sysadmin.activitiesdemo",photoFile);
        Uri photoUri = Uri.fromFile(photoFile);
        Intent photoCaptureintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(photoCaptureintent.resolveActivity(getPackageManager())!=null) {
            photoCaptureintent.putExtra(MediaStore.EXTRA_OUTPUT ,photoUri);
            startActivityForResult(photoCaptureintent, PHOTO_REQUEST_CODDE);
        }
    }

    public File createImageFile() throws IOException {
        String timestamp = new SimpleDateFormat("ddMMyy_HHmmss").format(new Date());
        String filename = "Photo_" + timestamp + ".jpg";
        File image = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),filename);
        mCurrentPhotoPath =image.getAbsolutePath();
        Log.d("here",mCurrentPhotoPath);
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PHOTO_REQUEST_CODDE){
            if(resultCode==RESULT_OK){
                setPicOnFrag();
            }
        }
    }

    private void setPicOnFrag() {
        if(photofrag!=null){
            Log.d("frag","not-null");
            photofrag.setImageFromPath(mCurrentPhotoPath);
        }else{
            Log.d("frag","null");
            photofrag = PhotoDisplayFrag.newInstance("");
            getSupportFragmentManager().beginTransaction().add(R.id.photofrag_container,photofrag).commit();

        }
    }

    @Override
    public void callsetImageFromPath() {
        photofrag.setImageFromPath(mCurrentPhotoPath);
        Log.d("PhotoPath",mCurrentPhotoPath);
    }
}
