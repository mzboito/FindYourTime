package com.example.fyt.findyourtime;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TasksActivity extends AppCompatActivity {
    Info infoTasks;
    List<Task> tasks_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        setTitle("Tasks");
        infoTasks = MainActivity.info;
    }

    public void sendNewTaskActivity(View view) {
        Intent intent = new Intent(this, NewTaskActivity.class);
        startActivity(intent);
    }

    public void notifyTask(View view){

        if(!infoTasks.getTasks_array().isEmpty()){
            tasks_array = infoTasks.getTasks_array();
            Task task = tasks_array.get(0);
<<<<<<< HEAD
=======
            /*TextView textView = new TextView(this);
            textView.setTextSize(40);
            textView.setText(task.getName());
            ViewGroup layout = (ViewGroup) findViewById(R.id.activity_tasks);
            layout.addView(textView);*/
>>>>>>> 0fba17c039227bd8953a890bba92894ef3654762

            NotificationCompat.Builder mBuilder;
            PendingIntent resultPendingIntent;

            mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
                    .setContentTitle("Let's do something nice!")
                    .setContentText("How about " + task.getName());
            //.setVibrate(new long[]{500, 500})
            //.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            // Builds the notification and issues it.
            mNotifyMgr.notify(0, mBuilder.build());
            infoTasks.resortList();
        }
    }
}
