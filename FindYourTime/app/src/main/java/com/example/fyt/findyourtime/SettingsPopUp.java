package com.example.fyt.findyourtime;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by mzboito on 16/12/17.
 */

public class SettingsPopUp extends Activity {
    Info info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_popup);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = (int) Math.round(dm.widthPixels *0.9) ;
        int height = (int) Math.round(dm.heightPixels *0.5) ;
        getWindow().setLayout(width, height);

        info = MainActivity.info;
    }

    public void apply(View view){
        EditText editHourBegin = (EditText)findViewById(R.id.textHour3);
        EditText editMinuteBegin = (EditText)findViewById(R.id.textHour4);
        int hourBegin = Integer.parseInt(editHourBegin.getText().toString());
        int minuteBegin = Integer.parseInt(editMinuteBegin.getText().toString());

        int new_not = (hourBegin * 360000) + (minuteBegin * 60000);
        //notification time is in milliseconds

        info.setNotificationTime(new_not);
        Log.d("APPLY", Integer.toString(info.notificationTime));
        finish();
    }

    @Override
    public void onBackPressed() { // I don't know if this is necessary
        super.onBackPressed();
        this.finish();
    }
}
