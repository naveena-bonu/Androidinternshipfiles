package com.example.exampledatabase;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exampledatabase.RDB.RTable;

import java.util.List;
//to get all the properties we are getting the adapter features from recycler view.
//recycler view------is a view holder,
//list view data can be displayed but cannot hold he data easily
//inflating---java class and xml file to connect them adding those both.

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.HoldView> {
    Context ct;
    List<RTable> list;

    public MyAdapter(Context ct, List<RTable> list) {
        this.ct = ct;
        this.list = list;
    }

    @NonNull
    @Override
    public HoldView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create
        return new HoldView(LayoutInflater.from(ct)
                .inflate(R.layout.row,parent,false));
        //attachto root should be false only
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.HoldView holder, int position) {
        holder.tv.setText(list.get(position).getSroll());
        holder.tv1.setText(list.get(position).getSname());
        holder.tv2.setText(list.get(position).getSnumber());
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.rViewModel.delete(list.get(position));
                Toast.makeText(ct, "Data Deleted",
                        Toast.LENGTH_SHORT).show();
                //creating custom dialogue
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder b = new AlertDialog.Builder(ct);
                View view =
                        LayoutInflater.from(ct).inflate(R.layout.update,null,false);
                EditText roll = view.findViewById(R.id.uroll);
                EditText name = view.findViewById(R.id.uname);
                EditText phone = view.findViewById(R.id.uphone);

                b.setView(view);
                b.setCancelable(false);//popups if we tap on any screen it doesn't close it

                roll.setText(list.get(position).getSroll());
                roll.setEnabled(false);//we cannot change roll number as it is rimary key unique
                name.setText(list.get(position).getSname());
                phone.setText(list.get(position).getSnumber());

                b.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        RTable rTable = new RTable();
                        rTable.setSroll(roll.getText().toString());
                        rTable.setSname(name.getText().toString());
                        rTable.setSnumber(phone.getText().toString());
                        MainActivity.rViewModel.update(rTable);
                        Toast.makeText(ct, "Data Updated",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                b.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                b.show();

            }
        });
    }

    @Override
    public int getItemCount() {//how much should be displayed
        return list.size();
    }

    public class HoldView extends RecyclerView.ViewHolder {
        TextView tv,tv1,tv2;
        ImageButton edit,del;
        public HoldView(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.roll);
            tv1 = itemView.findViewById(R.id.name);
            tv2 = itemView.findViewById(R.id.number);
            edit = itemView.findViewById(R.id.update);
            del = itemView.findViewById(R.id.delete);
        }
    }
}