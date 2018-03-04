package com.example.nprezive.cs3270a7;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        fm = getSupportFragmentManager();
        fabAdd = findViewById(R.id.fabAdd);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .add(R.id.frameMainActivity,
                                new FragmentCourseEdit(),
                                "fragCourseEdit")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public void onFragmentCourseListInteraction(Course course) {
        //TODO: Show course detail view
    }
}
