package com.example.exampledatabase.RDB;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RRepository {

    //all repository are unique and it gives the path where files are visisble and run
     RDatabase rDatabase;
     LiveData<List<RTable>> list;

     public RRepository(Application application){
         rDatabase=RDatabase.getrDatabase(application);
         list=rDatabase.rDao().readAll(); //repository is like an index for all topics
     }
     //background work is done but also gives details about the task in easy and understandable way-------async task
    //worker thread-- user cannot see
    //UO THREAD-- process can be seen by user
    // async task holds until the app fetches data and not shows error to the user.
    //in 16ms if the application doesn't open it says "error not opening"
    //---------------------creating classes------------------------
    class InsertTask extends AsyncTask<RTable,Void,Void>{

         @Override
         protected Void doInBackground(RTable... rTables) {   //'...'  ---- says as an array, bulk data
             for (int i=0;i<rTables.length;i++){
                 rDatabase.rDao().insert(rTables[i]);
             }
             return null;
         }
     }
     class UpdateTask extends AsyncTask<RTable,Void,Void>{

         @Override
         protected Void doInBackground(RTable... rTables) {
             for (int i=0;i<rTables.length;i++){
                 rDatabase.rDao().update(rTables[i]);
             }
             return null;
         }
     }
     class DeleteTask extends AsyncTask<RTable,Void,Void>{

         @Override
         protected Void doInBackground(RTable... rTables) {
             for (int i=0;i<rTables.length;i++){
                 rDatabase.rDao().delete(rTables[i]);
             }
             return null;
         }
     }
     public void insert(RTable rTable){
         new InsertTask().execute(rTable);//Execute is a must to run the program
     }
     public void update(RTable rTable){
         new UpdateTask().execute(rTable);
     }
     public void delete(RTable rTable){
         new DeleteTask().execute(rTable);
     }
     public LiveData<List<RTable>> readAllAData(){
         return list;
     }
}
