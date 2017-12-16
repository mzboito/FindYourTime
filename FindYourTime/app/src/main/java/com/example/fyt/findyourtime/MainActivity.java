package com.example.fyt.findyourtime;

import android.content.Context;
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

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import android.widget.TextView;
import android.widget.TimePicker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
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
        info = new Info(this); //in the future we will open a file for this
        handler = new Handler();
        handler.post(runnableCode);
    }

    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            buildNotification(false);
            // Do something here on the main thread
            Log.d("Handlers", "Called on main thread");
            // Repeat this the same runnable code block again another 2 seconds
            // 'this' is referencing the Runnable object
            handler.postDelayed(this, info.getNotificationTime());
        }
    };


    public void buildNotification(boolean ignore) {
        if(ignore){
            user_notify();
        }else{
            if(!info.scheduleConfict()){
                user_notify();
            }
        }
    }

    public void user_notify(){
        List<Task> tasks = info.getTasks_array();
        if(!tasks.isEmpty()){
            Task t = info.getTasks_array().get(0);
            info.resortList();
            mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
                    .setContentTitle("Find your time!")
                    .setContentText("Time to "+t.name)//;
                    .setVibrate(new long[]{500, 500})
                    .setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

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

    // mudar o criterio de notificar tarefa, só pode notificar quando não coincidir com o schedule
    public void notifyTask(View view){
        buildNotification(true);
    }

    public void setGreetingsText(){
        /*TextView textView = new TextView(this);
            textView.setTextSize(40);
            textView.setText(task.getName());
            ViewGroup layout = (ViewGroup) findViewById(R.id.activity_tasks);
            layout.addView(textView);
        */

    }
}
