package com.example.fyt.findyourtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Calendar;

import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getCurrentTime();

    }

    private void getCurrentTime()
    {
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
}
