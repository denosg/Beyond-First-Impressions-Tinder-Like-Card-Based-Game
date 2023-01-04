package com.example.werenotreallystrangers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

/*TODO -make personalQuestionsView() work. It should open a new activity where you can add and save your own personal questions in the app
  TODO -make the cards shareable to insta story / snapchat (like spotify does it). It probably saves it as a picture and thats how the app (insta/ snap) receives it to share
 */

public class MainActivity extends AppCompatActivity implements Serializable {

    ArrayList <String> levelOne = new ArrayList();
    ArrayList <String> levelTwo = new ArrayList();
    ArrayList <String> levelThree = new ArrayList();

    String titleText;

    String cardColorBackground;

    Intent listIntent;

    Intent personalIntent;

    public void levelOneView (View view) {
        Log.i("Button click", "True");

        titleText = "Getting to know each other";

        cardColorBackground = "#8a45b0";

        listIntent.putExtra("cardColorBackground", cardColorBackground);
        listIntent.putExtra("titleText", titleText);
        listIntent.putExtra("levelList", levelOne);

        startActivity(listIntent);
    }

    public void levelTwoView (View view) {
        Log.i("Button click", "True");

        titleText = "Going deeper";

        cardColorBackground = "#460B23";

        listIntent.putExtra("cardColorBackground", cardColorBackground);
        listIntent.putExtra("titleText", titleText);
        listIntent.putExtra("levelList", levelTwo);

        startActivity(listIntent);
    }

    public void levelThreeView (View view) {
        Log.i("Button click", "True");

        titleText = "Spiritual connection";

        cardColorBackground = "#840D39";

        listIntent.putExtra("cardColorBackground", cardColorBackground);
        listIntent.putExtra("titleText", titleText);
        listIntent.putExtra("levelList", levelThree);

        startActivity(listIntent);
    }

    public void personalQuestionsView (View view) {
        Log.i("Button click", "True");

        titleText = "Personal Questions";

        //luminous yellow
        cardColorBackground = "#53522A";

        personalIntent.putExtra("cardColorBackground", cardColorBackground);
        personalIntent.putExtra("titleText", titleText);

        startActivity(personalIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //no dark mode access (the app is already dark)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //set the screen orientation to portrait all the time
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        personalIntent = new Intent(getApplicationContext(), PersonalActivity.class);

        listIntent = new Intent(getApplicationContext(), LevelsActivity.class);

        //level one questions
        levelOne.add("What do you think is the hardest part of what I do for a living ?");
        levelOne.add("What's the first thing you noticed about me ?");
        levelOne.add("What is the one song that would describe me ?");
        levelOne.add("If you were to buy me a present, knowing nothing about me other than what I look like, what would it be ?");
        levelOne.add("On a scale of 1-10, how messy do you think my car is? 1 being the cleanest 10 complete disaster, explain.");
        levelOne.add("Do I look kind ? Explain.");
        levelOne.add("Do I seem like more of a creative or analytical type ? Explain.");
        levelOne.add("Do I seem like someone who would get a name tattooed on myself ? Why or why not ?");
        levelOne.add("Finish the sentence: Just by looking at you I'd think _____________.");
        levelOne.add("What do my shoes tell you about me ?");
        levelOne.add("Do you think I've ever been fired from a job ? If so, what for ?");
        levelOne.add("What was your first impression of me ?");
        levelOne.add("How would you describe what you think my type is in three words ?");
        levelOne.add("What did you think about my first message ?");
        levelOne.add("Between the two of us, who seems like the better texter ? Explain.");
        levelOne.add("What does my Instagram tell you about me ?");
        levelOne.add("Make an assumption about me.");
        levelOne.add("What about me intrigues you ?");
        levelOne.add("What do you think I'm most likely to splurge on ?");
        levelOne.add("As a child, what do you think I wanted to be ?");
        levelOne.add("Finish the sentence: just by looking at you I'd think ...");
        levelOne.add("Do you think I was popular in school ? Explain.");
        levelOne.add("How many speeding tickets do you think I've gotten in my life ?");
        levelOne.add("Do you think I fall in love easily ?");
        levelOne.add("What compliment do you think I hear the most ?");
        levelOne.add("Do you think I ever checked an Ex phone for evidence ?");
        levelOne.add("What subject do you think I thrived at in school and did I fail any ?");
        levelOne.add("Do I seem like a coffee or tea person - sweetened or unsweetened ?");
        levelOne.add("Do I seem like a morning person or a night owl ?");
        levelOne.add("Do you think I'm usually early on time or late to events ?");
        levelOne.add("Do I remind you of anyone you know ?");
        levelOne.add("Am I someone you typically connect with ?");
        levelOne.add("Do I intimidate you ?");
        levelOne.add("What's your favorite song lyric that comes to your mind from the top of your head ?");
        levelOne.add("Write down your number one goal for the next month. Compare.");

        //level two questions
        levelTwo.add("What's been your happiest memory this past year ?");
        levelTwo.add("Have you changed your mind about anything recently ?");
        levelTwo.add("What has been your earliest recollection of happiness ?");
        levelTwo.add("What lesson took you the longest to un-learn ?");
        levelTwo.add("Are you lying to yourself about anything ?");
        levelTwo.add("What questions are you trying to answer most in your life right now ?");
        levelTwo.add("When was the last time you surprised yourself ?");
        levelTwo.add("What title would you give this chapter in your life ?");
        levelTwo.add("What do you crave more of ?");
        levelTwo.add("Finish the sentence: Strangers would describe me as ______ only I know that I am _______");
        levelTwo.add("What's the worst pain you have ever been in that wasn't physical ?");
        levelTwo.add("Has a stranger ever changed your life ?");
        levelTwo.add("What would your younger self not believe about your life today ?");
        levelTwo.add("How would you describe the feeling of being in love with one word ?");
        levelTwo.add("What are you more afraid of: failure or success and why ?");
        levelTwo.add("What is a dream you let go of ?");
        levelTwo.add("If you could get to know someone in your life on a deeper level who would it be and why ?");
        levelTwo.add("What's your mom's name and what is the most beautiful thing about her ?");
        levelTwo.add("What part of your life works what part of your life hurts ?");
        levelTwo.add("How can you become a better person ?");
        levelTwo.add("Do you think the image you have of yourself matches the image other people see you as ?");
        levelTwo.add("What fast food restaurant do you think I'm most likely to drive through? What's my order ?");
        levelTwo.add("Do you think I intimidate others ? Why or why not ?");
        levelTwo.add("When you are asked how are you, how often do you answer truthfully ?");
        levelTwo.add("How are you, really ?");
        levelTwo.add("What's the most unexplainable thing that happened to you ?");
        levelTwo.add("What's your father's name ? And tell me one thing about him.");
        levelTwo.add("If you could have it your way: who would you be with?\nWhere would you be?\nWhat would you be doing?");
        levelTwo.add("What would mean a perfect day for you ?");
        levelTwo.add("What dating advice would you give your younger self ?");
        levelTwo.add("How old do you feel emotionally ?");
        levelTwo.add("What's the most embarrassing thing that happened to you on a date ?");
        levelTwo.add("What could you have done better in previous relationships ?");
        levelTwo.add("Is there an image of yourself you try to project on a first date you wish you could let go of ?");
        levelTwo.add("Finish the sentence: Dating is ____________ (both players)");
        levelTwo.add("What did the people who raised you teach you about love ?");
        levelTwo.add("Describe your perfect date.");
        levelTwo.add("What has being single taught you about yourself ?");
        levelTwo.add("What's your least favorite question to be asked on a date?\nWhat do you wish you would be asked more?");
        levelTwo.add("What are you most passionate about ?");
        levelTwo.add("What are you not currently giving enough time to ?");
        levelTwo.add("Write down the three most important things to you in a relationship (30 sec) Compare.");
        levelTwo.add("Draw your current mood. Compare.");

        //level three questions
        levelThree.add("Based on what you learned about me what would you recommend I read ?");
        levelThree.add("What about me surprised you ?");
        levelThree.add("Based on what you know about me, do you have a movie/show recommendation?");
        levelThree.add("What do you think my superpower is ?");
        levelThree.add("What do you think our most important similarities are ?");
        levelThree.add("What do you think is one thing I could do that would drastically improve my life ?");
        levelThree.add("What would be the perfect gift for me ?");
        levelThree.add("How would you describe me to a stranger ?");
        levelThree.add("What do I need to hear right now ?");
        levelThree.add("Based on what you've learned about me, does my social media portray me accurately ?");
        levelThree.add("What is a lesson you will take away from our conversation ?");
        levelThree.add("What can I help you with ?");
        levelThree.add("What do you think do I fear the most ?");
        levelThree.add("Where am I most qualified to give advice about ?");
        levelThree.add("What about me is the hardest for you to understand ?");
        levelThree.add("If we were a band what would be our name ?");
        levelThree.add("Admit something.");
        levelThree.add("What parts of yourself do you see in me ?");
        levelThree.add("How does one earn your vulnerability ?");
        levelThree.add("Dare your partner to do something out of their comfort zone next week.");
        levelThree.add("What do you recommend I should let go of ?");
        levelThree.add("What has this conversation taught you about yourself ?");
        levelThree.add("What do you think my defining characteristic is ?");
        levelThree.add("What question were you most afraid to answer ?");
        levelThree.add("Why do you think we met ?");
        levelThree.add("What do you think my weakness is ?");
        levelThree.add("How do our personalities compliment each other ?");
        levelThree.add("What do you think I should know about myself that perhaps I'm unaware of ?");
        levelThree.add("What would make you feel closer to me ?");
        levelThree.add("What do you admire most about me ?");
        levelThree.add("In one word, describe how you feel right now.");
        levelThree.add("Do you believe everyone has a calling ?\nIf so, do you think I've found mine ?");
        levelThree.add("What can we create together ?");
        levelThree.add("What answer of mine made you light up ?");
        levelThree.add("What's the most attractive quality about me that isn't physical ?");
        levelThree.add("Am I like you expected me to be ?");
        levelThree.add("Tell me your favorite memory with me.");
    }
}