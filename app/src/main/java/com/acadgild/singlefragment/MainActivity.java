package com.acadgild.singlefragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.EditText;


public class MainActivity extends Activity {
    String txt;//Declaring String txt
    EditText editText;//Declaring editText

    DataFromActivityToFragment dataFromActivityToFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//loading main layout
    }



    public void selectFrag(View view) {
        editText=(EditText)findViewById(R.id.editText);//
        txt=editText.getText().toString();
        SimpleAddition fr = new SimpleAddition();//Initialising main fragment
        FragmentManager fm = getFragmentManager();//Getting fragment manager
        dataFromActivityToFragment = (DataFromActivityToFragment) fr;
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

        //Using handler to pass the data
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                dataFromActivityToFragment.sendData(txt);
            }
        };
        handler.postDelayed(r,1);


    }

    public interface DataFromActivityToFragment {
        void sendData(String data);
    }
}