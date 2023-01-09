package com.example.werenotreallystrangers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class ListEditorActivity extends AppCompatActivity {

    static ArrayAdapter arrayAdapter;

    SharedPreferences sharedPreferences;

    public void addQuestionView(View view) {
        Intent intent = new Intent(getApplicationContext(), AddQuestionActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_editor);

        sharedPreferences = getApplicationContext().getSharedPreferences("com.example.werenotreallystrangers", Context.MODE_PRIVATE);
        ListView questionsListView = findViewById(R.id.questionsListView);

        arrayAdapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, PersonalActivity.personalQuestions);

        questionsListView.setAdapter(arrayAdapter);

        questionsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), AddQuestionActivity.class);
                intent.putExtra("questionId", position);
                startActivity(intent);
            }
        });

        questionsListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                new AlertDialog.Builder(ListEditorActivity.this)
                        .setIcon(R.drawable.wearenotreallystrangers1)
                        .setTitle("Are you sure ?")
                        .setMessage("Do you want to delete this question ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                PersonalActivity.personalQuestions.remove(position);
                                PersonalActivity.arrayAdapter.notifyDataSetChanged();
                                arrayAdapter.notifyDataSetChanged();

                                HashSet<String> set = new HashSet<>(PersonalActivity.personalQuestions);
                                sharedPreferences.edit().putStringSet("personalQuestions", set).apply();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();

                return true;
            }
        });
    }
}