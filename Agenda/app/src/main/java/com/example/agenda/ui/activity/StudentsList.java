package com.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.StudentDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StudentsList extends AppCompatActivity {
    private FloatingActionButton fabAddStudent;
    private static final String APPBAR_TITLE = "Students List";
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        setTitle(APPBAR_TITLE);
        setObjects();
        actionButtons();
    }

    @Override
    protected void onResume() {
        super.onResume();
        createList();
    }

    private void createList() {
        ListView listStudents = findViewById(R.id.activity_main_listView_Students);
        listStudents.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.todos()));
    }

    private void actionButtons() {
        fabAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentsList.this, FormStudentActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setObjects() {
        fabAddStudent = findViewById(R.id.activity_main_fab_addStudent);
    }
}