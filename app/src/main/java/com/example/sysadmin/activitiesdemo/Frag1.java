package com.example.sysadmin.activitiesdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag1 extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG = "frag1" ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String data;
    private EditText edt;
    private TextView tv;
    private String str; //to store data from frag2;

    public Frag1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag1.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag1 newInstance(String param1, String param2) {
        Frag1 fragment = new Frag1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.d("frag1","onCreate");
        if(savedInstanceState!=null)
        {
            tv.setText(str);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag1, container, false);
        edt = (EditText) v.findViewById(R.id.frag1_edt);
        tv = (TextView) v.findViewById(R.id.frag1_tv);
        Log.d("frag1","sis=null");
        if(savedInstanceState!=null){
            Log.d("sis!null",str);
            tv.setText(str);
        }
        v.setOnClickListener(this);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv.setText(str);
    }


    @Override
    public void onClick(View view) {
        Frag2 f2;
        f2 = Frag2.newInstance("","");
        f2.setTargetFragment(this,1);

        getFragmentManager().beginTransaction().replace(R.id.container,f2,Frag2.TAG).addToBackStack(null).commit();
    }

    public String getData(){
        data = edt.getText().toString();
        return data;
    }
    public void setToTextView(String s){
        str = s;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("frag1","onSaveInstanceState");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("frag1","onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("frag1","onDestroy");
    }
}
