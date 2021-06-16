package com.example.agenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.StudentDAO;
import com.example.agenda.model.Student;

public class FormStudentActivity extends AppCompatActivity {

    private static final String APPBAR_TITLE = "Student Form";
    private Button btSave;
    private EditText etName, etPhone, etEmail;
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_aluno);
        setTitle(APPBAR_TITLE);
        setObjects();
        actionButtons();
    }

    private void actionButtons() {
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student newStudent = createStudent();
                saveStudent(newStudent);
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void saveStudent(Student newStudent) {
        dao.save(newStudent);
    }

    @org.jetbrains.annotations.NotNull
    private Student createStudent() {
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        String email = etEmail.getText().toString();
        Student newStudent = new Student(name,phone, email);
        return newStudent;
    }

    private void setObjects() {
        btSave = findViewById(R.id.activity_form_aluno_bt_save);
        etName = findViewById(R.id.activity_form_aluno_et_name);
        etPhone = findViewById(R.id.activity_form_aluno_et_phone);
        etEmail = findViewById(R.id.activity_form_aluno_et_email);
    }
}