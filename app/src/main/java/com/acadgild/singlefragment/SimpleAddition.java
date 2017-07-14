package com.acadgild.singlefragment;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleAddition extends Fragment implements MainActivity.DataFromActivityToFragment {

    TextView text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view, null);//inflating fragment layout
        text = (TextView) rootView.findViewById(R.id.textView1);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void sendData(String data) {
        if(data != null)
            Toast.makeText(getActivity(),"MainActivity :: Fragment Transaction"+data,Toast.LENGTH_SHORT).show();
            text.setText(data);
    }

}