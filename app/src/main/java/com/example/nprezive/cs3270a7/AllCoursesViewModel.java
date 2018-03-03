package com.example.nprezive.cs3270a7;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.nprezive.cs3270a7.db.AppDatabase;
import com.example.nprezive.cs3270a7.db.Course;

import java.util.List;

/**
 * Created by nprezive on 3/3/18.
 */

public class AllCoursesViewModel extends ViewModel {
    private LiveData<List<Course>> courseList;

    public LiveData<List<Course>> getAllCourses(Context context) {
        if (courseList == null)
            courseList = AppDatabase.getInstance(context).courseDAO().getAll();

        return courseList;
    }
}
