package com.lemubit.lemuel.architecturalcomponentstest.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RoomDao {
    @Query("SELECT * FROM model")
    List<Model> getAll();

    @Query("SELECT * FROM model WHERE id = :userId")
    Model loadAllByIds(int userId);

    @Query("SELECT COUNT(*) from model")
    LiveData<Integer> countAll();

    @Insert
    void insertAll(Model... models);

    @Delete
    void delete(Model user);
}
