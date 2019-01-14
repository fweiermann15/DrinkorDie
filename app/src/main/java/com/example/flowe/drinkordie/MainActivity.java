package com.example.flowe.drinkordie;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationCompat.Builder notBuilder;
    private static final int MY_NOTIFICATION_ID = 12345;
    private static final int MY_REQUEST_CODE = 100;

    public int thirstLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thirstLevel = 0;

        this.notBuilder = new NotificationCompat.Builder(this);
        this.notBuilder.setAutoCancel(true);

        timeToDrink();
    }

    public void timeToDrink(){
        this.notBuilder.setSmallIcon(R.mipmap.ic_launcher);
        this.notBuilder.setLargeIcon(BitmapFactory.decodeResource(this.getResources(),R.mipmap.ic_launcher));
        this.notBuilder.setTicker("This is a ticker");

        this.notBuilder.setWhen(System.currentTimeMillis()+ 10* 1000);
        this.notBuilder.setContentTitle("Trinken Sie JETZT!");
        this.notBuilder.setContentText("Ein 200ml Glas Wasser.");

        Intent drinking_Intent = new Intent(this,Drink.class);
        drinking_Intent.putExtra("Drink","drinking");
        drinking_Intent.putExtra("thirstLevel",thirstLevel);

        PendingIntent drinking_pIntent = PendingIntent.getBroadcast(this,0,drinking_Intent,0);

        Intent ignore_Intent = new Intent(this,Ignore.class);
        ignore_Intent.putExtra("Ignore","ignoring");
        ignore_Intent.putExtra("thirstLevel",thirstLevel);

        PendingIntent ignoring_pIntent = PendingIntent.getBroadcast(this,0,ignore_Intent,0);

        this.notBuilder.addAction(R.drawable.ic_launcher_foreground,"Trinken",drinking_pIntent);
        this.notBuilder.addAction(R.drawable.ic_launcher_foreground,"Ignorieren",ignoring_pIntent  );

        Intent intent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, MY_REQUEST_CODE,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);


        this.notBuilder.setContentIntent(pendingIntent);

        NotificationManager notificationService  =
                (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification =  notBuilder.build();
        notificationService.notify(MY_NOTIFICATION_ID, notification);
    }



}
