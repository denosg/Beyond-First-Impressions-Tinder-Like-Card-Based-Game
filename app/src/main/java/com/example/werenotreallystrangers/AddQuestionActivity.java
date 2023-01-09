package com.example.werenotreallystrangers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

public class AddQuestionActivity extends AppCompatActivity {

    int questionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        EditText card_text = findViewById(R.id.card_text);

        Intent intent = getIntent();

        questionId = intent.getIntExtra("questionId", -1);

        if (questionId != -1){
            card_text.setText(PersonalActivity.personalQuestions.get(questionId));
        }else{
            PersonalActivity.personalQuestions.add("");
            questionId = PersonalActivity.personalQuestions.size()-1;
        }

        card_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                PersonalActivity.personalQuestions.set(questionId, String.valueOf(s));
                PersonalActivity.arrayAdapter.notifyDataSetChanged();
                ListEditorActivity.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.werenotreallystrangers", Context.MODE_PRIVATE);
                HashSet<String> questionSet = new HashSet<>(PersonalActivity.personalQuestions);
                sharedPreferences.edit().putStringSet("personalQuestions", questionSet).apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}