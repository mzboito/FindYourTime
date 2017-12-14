package com.example.fyt.findyourtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewScheduleActivity extends AppCompatActivity {
    Info info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_schedule);
        info = MainActivity.info;
    }

    public void registerSchedule(View view){

    }

    public void cancelSchedule(View view){
        finish();
    }
}
