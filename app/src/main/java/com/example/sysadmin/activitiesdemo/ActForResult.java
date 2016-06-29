package com.example.sysadmin.activitiesdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActForResult extends AppCompatActivity {

    public static final String DATA_KEY ="data" ;
    private EditText edt;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_for_result);

        edt = (EditText) findViewById(R.id.editText);
        submit = (Button) findViewById(R.id.submit);

    }

    public void returnToMain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        String str = edt.getText().toString();
        if(!str.equalsIgnoreCase("")){
            intent.putExtra(DATA_KEY,str);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }else
        {
            Toast.makeText(this,"You didn't entered any text",Toast.LENGTH_SHORT).show();
        }
    }
}
