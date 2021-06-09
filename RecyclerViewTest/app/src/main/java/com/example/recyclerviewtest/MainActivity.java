package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv= findViewById(R.id.recyclerview);

        int[] images ={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,
        R.drawable.i,R.drawable.j};

        String[] itemnames ={"Chicken Biriyani","Chicken Lolypop","Egg fried rice","Chicken 65","Mutton curry","Mutton biriyani",
                "Noodles","Manchuria", "Prawns Curry","Veg biriyani"};

        String[] price ={"300","200","100","250","500","650","100","150","350","150"};
        rv.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapter adapter=new ItemAdapter(this,images,itemnames,price);
        rv.setAdapter(adapter);




    }

}