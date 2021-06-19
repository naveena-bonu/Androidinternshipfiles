package com.example.exampledatabase.RDB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//table is necessary to fetch details easily in rows and columns searching.
@Entity //(Tablename= room table) can be given here
public class RTable {
    @NonNull
    @PrimaryKey//Should not be null
    String sroll;
    String sname, snumber;
    //primary key is unique for every data table. It is not repeatable. no redundance(no two times should not be there)
//alt +insert


    @NonNull
    public String getSroll() {
        return sroll;
    }

    public void setSroll(@NonNull String sroll) {
        this.sroll = sroll;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }
}
