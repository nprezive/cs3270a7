package com.example.nprezive.cs3270a7;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nprezive.cs3270a7.db.AppDatabase;
import com.example.nprezive.cs3270a7.db.Course;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCourseEdit extends DialogFragment {

    public FragmentCourseEdit() {
        // Required empty public constructor
    }

    private View root;
    TextInputEditText id, name, courseCode, startAt, endAt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_course_edit, container, false);

        id = root.findViewById(R.id.edtID);
        name = root.findViewById(R.id.edtName);
        courseCode = root.findViewById(R.id.edtCourseCode);
        startAt = root.findViewById(R.id.edtStartAt);
        endAt = root.findViewById(R.id.edtEndAt);

        FloatingActionButton fabSave = root.findViewById(R.id.fabSave);
        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check that edt fields are not null
                if (id.getText().toString().equals("")
                        || name.getText().toString().equals("")
                        || courseCode.getText().toString().equals("")
                        || startAt.getText().toString().equals("")
                        || endAt.getText().toString().equals("")) {
                    Toast.makeText(getContext(),
                                    getString(R.string.fields_cannot_be_blank),
                                    Toast.LENGTH_SHORT)
                            .show();
                    return;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AppDatabase.getInstance(getContext())
                                .courseDAO()
                                .insertAll(new Course(
                                        id.getText().toString(),
                                        name.getText().toString(),
                                        courseCode.getText().toString(),
                                        startAt.getText().toString(),
                                        endAt.getText().toString()));
                    }
                }).start();

                dismiss();
            }
        });

        return root;
    }

}
