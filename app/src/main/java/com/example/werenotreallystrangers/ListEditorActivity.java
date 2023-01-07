package com.example.werenotreallystrangers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ListEditorActivity extends AppCompatActivity {

    public void addQuestionView(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_editor);

        ListView questionsListView = findViewById(R.id.questionsListView);


    }
}