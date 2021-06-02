package com.example.examplelife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("APSSDC","Activity created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("APSSDC", "Activity started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("APSSDC","Activity resumed");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("APSSDC","Activity Paused");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("APSSDC","Activity stopped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("APSSDC","Activity restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("APSSDC","Activity destroyed");
    }

    public void next(View view) {
     startActivity(new Intent(this,SecondActivity.class));
    }
}
