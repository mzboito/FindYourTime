package com.example.fyt.findyourtime;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import java.util.Calendar;
import android.widget.TextView;
import android.widget.TimePicker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Info info;

    CountDownTimer timer;
    NotificationCompat.Builder mBuilder;
    PendingIntent resultPendingIntent;
    boolean clickedFirstTime = true;
    boolean canDisturb = true; // Controls if the app is already counting some time


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // initial activity setup
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendNotifications();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    public void sendNotifications() {
        if (canDisturb)
            buildNotification();

        // Current celphone time
        Calendar currentTime = Calendar.getInstance();
        int currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
        int currentMinute = currentTime.get(Calendar.MINUTE);

        // Test if it's getting right hour and minute

        /* String currentHourStr = Integer.toString(currentHour);
        String currentMinStr = Integer.toString(currentMinute);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(currentMinStr);
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_main);
        layout.addView(textView);*/
    }

    public void buildNotification()
    {
       mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
                    .setContentTitle("FUNCIONAAAAAAAAAAA")
                    .setContentText("Para de olhar pro teto criatura");
                //.setVibrate(new long[]{500, 500})
        //.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

        Intent resultIntent = new Intent(this, MainActivity.class);

        //Clicking the notification opens mainMenu activity
        resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        setTitle("Find Your Time");
        info = new Info(); //in the future we will open a file for this

        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(0, mBuilder.build());

    }

    public void sendTasksActivity(View view) {
        Intent intent = new Intent(this, TasksActivity.class);
        intent.putExtra("InfoClass", info);
        startActivity(intent);
    }

    public void sendScheduleActivity(View view) {
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }
}
