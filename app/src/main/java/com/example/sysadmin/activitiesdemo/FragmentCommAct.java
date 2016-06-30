package com.example.sysadmin.activitiesdemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentCommAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_comm);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,Frag1.newInstance("",""),Frag1.TAG).commit();
        }
    }
}
