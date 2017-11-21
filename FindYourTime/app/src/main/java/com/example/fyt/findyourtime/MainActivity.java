package com.example.fyt.findyourtime;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
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
import android.util.Log;
import android.view.View;
import java.util.Calendar;
import android.widget.TextView;
import android.widget.TimePicker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    //Info info;
    public static Info info;

    CountDownTimer timer;
    NotificationCompat.Builder mBuilder;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // initial activity setup
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Find Your Time");
        info = new Info(); //in the future we will open a file for this
        handler = new Handler();
        handler.post(runnableCode);

    }

    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            buildNotification();
            // Do something here on the main thread
            Log.d("Handlers", "Called on main thread");
            // Repeat this the same runnable code block again another 2 seconds
            // 'this' is referencing the Runnable object
            handler.postDelayed(this, info.getNotificationTime());
        }
    };

    public void buildNotification() {
        List<Task> tasks = info.getTasks_array();
        if(!tasks.isEmpty()){
            Task t = info.getTasks_array().get(0);
            info.resortList();
            mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
                    .setContentTitle("How about doing something nice?")
                    .setContentText("I was thinking about "+t.name);
            //.setVibrate(new long[]{500, 500})
            //.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // Builds the notification and issues it.
            mNotifyMgr.notify(0, mBuilder.build());
        }
    }

    public void sendTasksActivity(View view) {
        Intent intent = new Intent(this, TasksActivity.class);
        startActivity(intent);
    }

    public void sendScheduleActivity(View view) {
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }
}
