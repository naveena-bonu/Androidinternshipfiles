package com.example.exampledatabase.RDB;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

//in android we have architectures
//this model class just binds the data
public class RViewModel extends AndroidViewModel {
    RRepository rRepository;
    LiveData<List<RTable>> list;
    public RViewModel(@NonNull  Application application) {
        super(application);
        rRepository=new RRepository(application);
        list= rRepository.readAllAData();
    }
    //============================creating methods=========================================

    //This method is to insert data
    public void insert(RTable rTable){
        rRepository.insert(rTable);
    }
    //This method is to read the data
    public LiveData<List<RTable>> readData(){
        return list;
    }
    //update data
    public void update(RTable rTable){
        rRepository.update(rTable);

    }
    //delete data
    public void delete(RTable rTable){
        rRepository.delete(rTable);
    }
}
