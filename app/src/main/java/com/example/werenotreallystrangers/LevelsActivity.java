package com.example.werenotreallystrangers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class LevelsActivity extends AppCompatActivity implements Serializable {
    Button randomButton;

    private MyCustomAdapter arrayAdapter;

    int[] currentIndex = {0};

    ArrayList <String>  questionsList;

    //choose a random question in the list
    public void randomQuestionView (View view) {
        Random random = new Random();
        int randomQuestion = random.nextInt(questionsList.size()-1);

        currentIndex[0] = randomQuestion;
        arrayAdapter.setPosition(currentIndex[0]);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        //set the screen orientation to portrait all the time
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //find randomButton in levelsActivity
        randomButton = findViewById(R.id.randomButton);

        Intent intent = getIntent();

        //gets the color for each level
        String cardColor = intent.getStringExtra("cardColorBackground");

        //sets the title text received from MainActivity.class
        String titleText = intent.getStringExtra("titleText");
        TextView titleTextView = findViewById(R.id.titleTextView);
        titleTextView.setText(titleText);

        //questions from the MainActivity.class
        questionsList = (ArrayList<String>) intent.getSerializableExtra("levelList");

        SwipeFlingAdapterView swipeFlingAdapterView = (SwipeFlingAdapterView) findViewById(R.id.card);

        arrayAdapter = new MyCustomAdapter(this, R.layout.details, R.id.card_text, questionsList, Color.parseColor(cardColor));

        swipeFlingAdapterView.setAdapter(arrayAdapter);

        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                currentIndex[0]++;
                //if position is equal to the amount of questions (1, 2, 3, ... .size() counts from 1) in the list,it resets the position to show the first (0) card since the user swiped left
                if (currentIndex[0] == questionsList.size()) {
                    currentIndex[0] = 0;
                }
                arrayAdapter.setPosition(currentIndex[0]);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                currentIndex[0]--;
                //if position is -1 resets the position to show the last card since the user swiped right
                if (currentIndex[0] == -1){
                    currentIndex[0] = questionsList.size()-1;
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
               //Copies the text on the card when clicked
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Card Text", questionsList.get(itemPosition));
                clipboard.setPrimaryClip(clip);

                Toast.makeText(LevelsActivity.this, "Text copied !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}