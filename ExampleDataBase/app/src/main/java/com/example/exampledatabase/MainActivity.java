package com.example.exampledatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exampledatabase.RDB.RTable;
import com.example.exampledatabase.RDB.RViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText roll, name, number;
    RecyclerView rv;
    public static RViewModel rViewModel;//imp

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll= findViewById(R.id.roll);
        name=findViewById(R.id.name);
        number=findViewById(R.id.phone);
        rv= findViewById(R.id.rv);
        rViewModel=new ViewModelProvider(this).get(RViewModel.class); //imp

        ////To read the data we need to use observer
        rViewModel.readData().observe(this, new Observer<List<RTable>>() {
            @Override
            public void onChanged(List<RTable> rTables) {
                //ctr+space we get suggestions
                MyAdapter adapter=new MyAdapter(MainActivity.this,rTables);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });
    }

    public void save(View view) {
        /* In this method we implemented Insert operation on RDB*/
        RTable rTable= new RTable();
        rTable.setSroll(roll.getText().toString());
        rTable.setSname(name.getText().toString());
        rTable.setSnumber(number.getText().toString());
        rViewModel.insert(rTable);
        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
    }
}