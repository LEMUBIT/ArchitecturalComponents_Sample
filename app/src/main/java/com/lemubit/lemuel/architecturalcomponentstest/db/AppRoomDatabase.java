package com.lemubit.lemuel.architecturalcomponentstest.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Model.class}, version = 1)
public abstract class AppRoomDatabase extends RoomDatabase {
    public abstract RoomDao appRoomDao();


    private static AppRoomDatabase INSTANCE;

    public static synchronized AppRoomDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppRoomDatabase.class, "appDB").build();
        }
        return INSTANCE;
    }
}
