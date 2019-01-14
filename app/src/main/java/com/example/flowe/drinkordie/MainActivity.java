package com.example.flowe.drinkordie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import java.sql.Timestamp;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public boolean firstRun = false;
    public static final int REQUESTCODE = 666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(firstRun == false) {
            Intent kalibrierungOeffnen = new Intent(this, Kalibrierungsinterface.class);
            startActivityForResult(kalibrierungOeffnen, REQUESTCODE);
        }

        Timestamp timestamp = new Timestamp(new Date().getTime());
        TextView view = findViewById(R.id.view);
        view.setText("" + timestamp);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle extras = data.getExtras();
        firstRun = (boolean) extras.get("FIRSTRUN");
    }
}
