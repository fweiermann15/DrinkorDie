package com.example.flowe.drinkordie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ignore extends AppCompatActivity {

    public int thirstLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ignore);

        Bundle bundle = getIntent().getExtras();
        thirstLevel = (int) bundle.get("thirstLevel") +1;
    }
}
