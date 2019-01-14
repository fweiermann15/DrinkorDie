package com.example.flowe.drinkordie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Kalibrierungsinterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalibrierungsinterface);
        Button btnSpeichern=findViewById(R.id.btnSpeichern);


        btnSpeichern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSpeichernClicked();
            }
        });



    }
    public void btnSpeichernClicked(){
        boolean firstRun=true;
        EditText eTextName=findViewById(R.id.eTextName);
        EditText eTextAge=findViewById(R.id.eTextAge);
        Intent i=new Intent(this,MainActivity.class);
        i.putExtra("NAME",eTextName.getText());
        i.putExtra("WEIGHT", Integer.parseInt(eTextAge.getText().toString()));
        i.putExtra("FIRSTRUN",firstRun);
        setResult(Activity.RESULT_OK,i);
        finish();
    }
}