package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> alunos = new ArrayList<>(
                Arrays.asList("José", "Zeca", "Jozeca"));
        ListView listAlunos = findViewById(R.id.activity_main_listView_alunos);
        listAlunos.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_list_item_1, alunos));

    }
}