package com.example.agenda.dao;

import com.example.agenda.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final static List<Student> students = new ArrayList<>();

    public void save(Student student){
        students.add(student);
    }

    public List<Student> todos() {
        return new ArrayList<>(students);
    }
}
