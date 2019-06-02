package com.lemubit.lemuel.architecturalcomponentstest.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Model {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public int age;
}
