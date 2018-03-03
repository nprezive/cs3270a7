package com.example.nprezive.cs3270a7.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by nprezive on 3/3/18.
 */

@Dao
public interface CourseDAO {

    @Query("SELECT * FROM course")
    LiveData<List<Course>> getAll();

    @Update
    void update(Course course);

    @Insert
    void insertAll(Course... courses);

    @Delete
    void delete(Course course);
}
