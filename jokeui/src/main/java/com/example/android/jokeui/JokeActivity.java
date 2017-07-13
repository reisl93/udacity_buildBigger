package com.example.android.jokeui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private String mJokeText = "No jokes available - actually this is an error. Welcome to bad user responses";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        if(getIntent().hasExtra(Intent.EXTRA_TEXT)){
            mJokeText = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        }

        ((TextView) findViewById(R.id.tv_jokeText)).setText(mJokeText);

    }
}
