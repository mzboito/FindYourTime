package com.example.fyt.findyourtime;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class TasksActivity extends AppCompatActivity {
    Info infoTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        setTitle("Tasks");

        Intent i = getIntent();
        infoTasks = (Info)i.getSerializableExtra("InfoClass");

    }

    public void sendNewTaskActivity(View view) {
        Intent intent = new Intent(this, NewTaskActivity.class);
        intent.putExtra("InfoClass", infoTasks);
        startActivity(intent);
    }

    public void notifyTask(View view){

        NotificationCompat.Builder mBuilder;
        PendingIntent resultPendingIntent;

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

        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(0, mBuilder.build());
    }
}
