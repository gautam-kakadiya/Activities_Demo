package com.example.sysadmin.activitiesdemo;



import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhotoDisplayFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotoDisplayFrag extends Fragment {
    ImageView imgview;
    OnActivityCreatedSuccessfully intface;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;


    public PhotoDisplayFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment PhotoDisplayFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static PhotoDisplayFrag newInstance(String param1) {
        PhotoDisplayFrag fragment = new PhotoDisplayFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        intface = (OnActivityCreatedSuccessfully)context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v;
        v = inflater.inflate(R.layout.fragment_photo_display, container, false);
        imgview = (ImageView) v.findViewById(R.id.photoview);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        intface.callsetImageFromPath();
    }

    public void setImageFromPath(String photopath) {
        int widthV = (int)getResources().getDimension(R.dimen.image_width);
        Log.d("View Width",widthV +" ");
        int heightV = (int)getResources().getDimension(R.dimen.image_height);
        Log.d("View Height",heightV +" ");

        BitmapFactory.Options bmoptions = new BitmapFactory.Options();
        bmoptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(photopath,bmoptions);

        int photoW = bmoptions.outWidth;
        int photoH = bmoptions.outHeight;

        int scaleFactor = Math.min(photoH/heightV,photoW/widthV);

        bmoptions.inJustDecodeBounds=false;
        bmoptions.inSampleSize = scaleFactor;
        Bitmap bmp = BitmapFactory.decodeFile(photopath,bmoptions);
        imgview.setImageBitmap(bmp);
    }

    public interface OnActivityCreatedSuccessfully {
            public void callsetImageFromPath();
    }

}
