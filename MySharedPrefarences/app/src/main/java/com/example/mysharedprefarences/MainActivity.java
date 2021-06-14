package com.example.mysharedprefarences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysharedprefarences.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    //we are binding all the views to a single one in java to refer in place of below comment lines
    //EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        //username=findViewById(R.id.username);
       // password=findViewById(R.id.password);
        sp= getSharedPreferences("apps",MODE_PRIVATE);

    }

    public void showdata(View view) {

       //Snackbar.make(view,binding.username.getText().toString()     +
               // binding.password.getText().toString(),Snackbar.LENGTH_LONG).show();
        //It is similar to toast message onlyyz
        Toast.makeText(this, "binding.username.getText().toString()+ binding.password.getText().toString() ", Toast.LENGTH_SHORT).show();
        editor=sp.edit();
        editor.putString("name",binding.username.getText().toString());
        editor.putString("password",binding.password.getText().toString());//ctr+D to copy duplicate
        editor.commit();

    }

    @Override
    protected void onPause() {//to store the data  in this application {life cycle- create start stop destroy....in this we are pausing this process
        super.onPause();
        editor=sp.edit();
        editor.putString("name",binding.username.getText().toString());
        editor.putString("password",binding.password.getText().toString());//ctr+D to copy duplicate
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String myName =sp.getString("name","");
        String myPassword =sp.getString("password","");
        binding.username.setText(myName);
        binding.password.setText(myPassword);
    }
}