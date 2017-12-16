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

    @Override
    public void onBackPressed() { // I don't know if this is necessary
        super.onBackPressed();
        this.finish();
    }

}
