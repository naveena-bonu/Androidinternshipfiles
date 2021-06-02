package com.example.examplelife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

            Log.i("APSSDC","Second Activity created");
        }

        @Override
        protected void onStart() {
            super.onStart();
            Log.i("APSSDC", "Second Activity started");
        }

        @Override
        protected void onResume() {
            super.onResume();
            Log.i("APSSDC","Second Activity resumed");

        }

        @Override
        protected void onPause() {
            super.onPause();
            Log.i("APSSDC","Second Activity Paused");

        }

        @Override
        protected void onStop() {
            super.onStop();
            Log.i("APSSDC","Second Activity stopped");
        }

        @Override
        protected void onRestart() {
            super.onRestart();
            Log.i("APSSDC","Second Activity restarted");
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.i("APSSDC","Second Activity destroyed");
        }
    }
