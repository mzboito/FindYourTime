package com.example.fyt.findyourtime;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by mzboito on 16/12/17.
 */

public class NewSchedulePopUp extends Activity {
    Info info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.newschedule_popup);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = (int) Math.round(dm.widthPixels *0.9) ;
        int height = (int) Math.round(dm.heightPixels *0.7) ;
        getWindow().setLayout(width, height);

        info = MainActivity.info;

    }

    public void registerSchedule(View view){
        EditText editText = (EditText)findViewById(R.id.editText);
        String name = editText.getText().toString();
        if(name.equals("Sechedule Name")){ //no name was given
            name = "schedule0" + String.valueOf(info.getId());
            info.iterId();
        }else{
            int i = 1;
            if(info.alreadyUsedSchedule(name)){
                name = name + "copy1";
            }
            int iter = 2;
            while(info.alreadyUsedSchedule(name)){
                name = name.replace(name.substring(name.length()-1), String.valueOf(i));
                name = name.substring(0, name.length() - 1) + String.valueOf(iter);
                //tester(name);
                //name.replace(name.substring(name.length()-1), String.valueOf(i));
                //name = name + String.valueOf(i);
                iter = iter + 1;
                //then add something to the end
            };
        }

        CheckBox checkWeekdays = (CheckBox) findViewById(R.id.checkBox);
        CheckBox checkWeekends = (CheckBox) findViewById(R.id.checkBox4);
        Info.schedule_date_type dateType;
        EditText editHourBegin = (EditText)findViewById(R.id.textHour);
        EditText editMinuteBegin = (EditText)findViewById(R.id.textMin);
        EditText editHourEnd = (EditText)findViewById(R.id.textHour2);
        EditText editMinuteEnd = (EditText)findViewById(R.id.textMin2);
        int hourBegin = Integer.parseInt(editHourBegin.getText().toString());
        int minuteBegin = Integer.parseInt(editMinuteBegin.getText().toString());
        int hourEnd = Integer.parseInt(editHourEnd.getText().toString());
        int minuteEnd = Integer.parseInt(editMinuteEnd.getText().toString());

        if(checkWeekdays.isChecked()){ // then it's a duty
            dateType = Info.schedule_date_type.weekdays;
        }
        else if(checkWeekends.isChecked()){
            dateType = Info.schedule_date_type.weekend;
        }
        else
            dateType = Info.schedule_date_type.daily;

        info.add_schedule(name, dateType, hourBegin, minuteBegin, hourEnd, minuteEnd);

        //Log.d(name,"name");
        //Log.d(name, "name");
        //Log.d(dateType.toString(), "date");
        //Log.d("oi", "ooooooooooi");
        finish();
    }

    public void cancelSchedule(View view){
        finish();
    }

    @Override
    public void onBackPressed() { // I don't know if this is necessary
        super.onBackPressed();
        this.finish();
    }


}
