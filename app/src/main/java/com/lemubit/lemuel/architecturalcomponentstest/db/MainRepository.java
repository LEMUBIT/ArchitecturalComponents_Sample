package com.lemubit.lemuel.architecturalcomponentstest.db;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

public class MainRepository {
    private Context context;

    public MainRepository(Application application) {
        this.context = application.getApplicationContext();
    }

    public void insertNewUser(Model model)
    {
       AsyncTask.execute(()-> AppRoomDatabase.getInstance(context).appRoomDao().insertAll(model));
    }

    /**Room doesn't allow you to issue database queries on the main thread. LiveData applies this rule by automatically running the query asynchronously on a background thread**/
    public LiveData<Integer> getCount()
    {
       return AppRoomDatabase.getInstance(context).appRoomDao().countAll();
    }
}
