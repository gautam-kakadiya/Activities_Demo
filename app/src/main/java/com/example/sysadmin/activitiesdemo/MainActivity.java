package com.example.sysadmin.activitiesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int ACT_FOR_RESULT_CODE = 1 ;
    private TextView result;
    private Button toAct1button,act4rslt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);
        toAct1button = (Button) findViewById(R.id.toAct1);
        act4rslt = (Button) findViewById(R.id.toAct4R);
        toAct1button.setOnClickListener(this);
        act4rslt.setOnClickListener(this);
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

}
