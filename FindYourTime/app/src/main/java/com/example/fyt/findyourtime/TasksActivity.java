package com.example.fyt.findyourtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
