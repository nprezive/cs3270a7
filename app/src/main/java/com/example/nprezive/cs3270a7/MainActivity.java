package com.example.nprezive.cs3270a7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nprezive.cs3270a7.db.Course;

public class MainActivity extends AppCompatActivity
        implements FragmentCourseList.OnFragmentCourseListInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentCourseListInteraction(Course course) {

    }
}
