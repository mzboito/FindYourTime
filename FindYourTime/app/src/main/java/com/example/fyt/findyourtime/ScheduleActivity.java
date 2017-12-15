package com.example.fyt.findyourtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        setTitle("Schedule");
    }

    public void sendNewScheduleActivity(View view) {
        Intent intent = new Intent(this, NewScheduleActivity.class);
        startActivity(intent);
    }

    public void deleteAScheduleActivity(View view){
        Intent intent = new Intent(this, DeleteScheduleActivity.class);
        startActivity(intent);
    }
}
