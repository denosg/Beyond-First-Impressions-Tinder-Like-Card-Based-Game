package com.example.werenotreallystrangers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class PersonalActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    static MyCustomAdapter arrayAdapter;

    static ArrayList<String> personalQuestions = new ArrayList<>();

    int[] currentIndex = {0};

    //Choose a random question in the list
    public void randomQuestionView (View view) {
            Random random = new Random();
            int randomQuestion = random.nextInt(personalQuestions.size());

            currentIndex[0] = randomQuestion;
            arrayAdapter.setPosition(currentIndex[0]);
            arrayAdapter.notifyDataSetChanged();
    }

    public void manageListView (View view) {
        Intent intent = new Intent(getApplicationContext(), ListEditorActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        //Set the screen orientation to portrait all the time
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        sharedPreferences = getApplicationContext().getSharedPreferences("com.example.werenotreallystrangers", Context.MODE_PRIVATE);

        HashSet<String> questionsSet = (HashSet<String>) sharedPreferences.getStringSet("personalQuestions", null);

        if (questionsSet == null){
            personalQuestions.add("Your questions will show here");
        }else{
            personalQuestions = new ArrayList<>(questionsSet);
        }

        Intent intent = getIntent();

        //Gets the color for each level
        String cardColor = intent.getStringExtra("cardColorBackground");

        //Sets the title text received from MainActivity.class
        String titleText = intent.getStringExtra("titleText");
        TextView titleTextView = findViewById(R.id.titleTextView);
        titleTextView.setText(titleText);

        SwipeFlingAdapterView swipeFlingAdapterView = (SwipeFlingAdapterView) findViewById(R.id.card);

        arrayAdapter = new MyCustomAdapter(this, R.layout.details, R.id.card_text, personalQuestions, Color.parseColor(cardColor));

        swipeFlingAdapterView.setAdapter(arrayAdapter);

        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                currentIndex[0]++;
                //If position is equal to the amount of questions (1, 2, 3, ... .size() counts from 1) in the list,it resets the position to show the first (0) card since the user swiped left
                if (currentIndex[0] == personalQuestions.size()) {
                    currentIndex[0] = 0;
                }
                arrayAdapter.setPosition(currentIndex[0]);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                currentIndex[0]--;
                //If position is -1 resets the position to show the last card since the user swiped right
                if (currentIndex[0] == -1){
                    currentIndex[0] = personalQuestions.size()-1;
                }
                arrayAdapter.setPosition(currentIndex[0]);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
            }
        });

        swipeFlingAdapterView.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                //Gets the index of the card shown
                itemPosition = currentIndex[0];
                //Copies the text on the card when clicked
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Card Text", personalQuestions.get(itemPosition));
                clipboard.setPrimaryClip(clip);
                //The phone already shows that the content has been saved in the clipboard
                //Toast.makeText(LevelsActivity.this, "Text copied !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}