package com.example.fyt.findyourtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DeleteScheduleActivity extends AppCompatActivity {
    Info info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_schedule);
        setTitle("Delete schedule");
        info = MainActivity.info;
    }
}
