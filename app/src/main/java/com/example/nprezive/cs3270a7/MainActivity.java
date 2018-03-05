package com.example.nprezive.cs3270a7;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nprezive.cs3270a7.db.Course;

public class MainActivity extends AppCompatActivity
        implements FragmentCourseList.OnFragmentCourseListInteractionListener {

    FragmentManager fm;
    FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tbMainActivity);
        setSupportActionBar(toolbar);
        fm = getSupportFragmentManager();

        //main view of the app: course list
        fm.beginTransaction()
                .replace(R.id.frameMainActivity, new FragmentCourseList(), "fragCourseList")
                .commit();

        //fabAdd onclicklistener
        fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .add(android.R.id.content,
                                new FragmentCourseEdit())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public void onFragmentCourseListInteraction(Course course) {
        fm.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .add(android.R.id.content, new FragmentCourseView())
                .addToBackStack(null)
                .commit();
    }
}
