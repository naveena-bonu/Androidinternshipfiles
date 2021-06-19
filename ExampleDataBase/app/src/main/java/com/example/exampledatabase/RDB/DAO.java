package com.example.exampledatabase.RDB;
// TO fetch data and to get queires.get , post,path


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao  //DAO- DATA ACCESS OBJECT CRED: Create,read,update,delete
public interface DAO {
    @Insert
    void insert(RTable rTable); //inserting the data, creating the data at first then inserting
    @Query("Select * from RTable")
    LiveData<List<RTable>> readAll();

    // -------------------Live Data-----------------------
     //

    @Update
    void update(RTable rTable);

    @Delete
    void delete(RTable rTable);
}
