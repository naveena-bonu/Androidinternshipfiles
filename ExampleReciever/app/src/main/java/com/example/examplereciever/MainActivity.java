package com.example.examplereciever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv= findViewById(R.id.iv);
        receiver =new MyReceiver(iv);//construtor that pases to other class
        IntentFilter filter= new IntentFilter();//this filter will store what we want actions or icons.
        filter.addAction(Intent.ACTION_POWER_CONNECTED); //default calls we want to register among diff default calls in system
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        this.registerReceiver(receiver,filter);

    }
}