package com.example.sysadmin.activitiesdemo;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int ACT_FOR_RESULT_CODE = 1 ;
    private TextView result;
    private Button toAct1button,act4rslt,photoCapActb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);
        toAct1button = (Button) findViewById(R.id.toAct1);
        act4rslt = (Button) findViewById(R.id.toAct4R);
        photoCapActb = (Button) findViewById(R.id.toPhotoAct);
        toAct1button.setOnClickListener(this);
        act4rslt.setOnClickListener(this);
        photoCapActb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id==R.id.toAct1){
            Intent intent = new Intent(this,Activity1.class);
            startActivity(intent);
        }
        if(id==R.id.toAct4R){
            Intent intent = new Intent(this,ActForResult.class);
            startActivityForResult(intent,ACT_FOR_RESULT_CODE);
        }
        if(id==R.id.toPhotoAct){
            Intent intent = new Intent(this,PhotoCaptureActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ACT_FOR_RESULT_CODE){
            if(resultCode == RESULT_OK){
                String str = data.getStringExtra(ActForResult.DATA_KEY);
                result.setText(str);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("lifecycle","onSavedInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy");
    }
}
