package com.example.fyt.findyourtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;

public class NewScheduleActivity extends AppCompatActivity {
    Info info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_schedule);
        setTitle("Adding a New Schedule");
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
        else{
            dateType = Info.schedule_date_type.weekend;
        }
        info.add_schedule(name, dateType, hourBegin, minuteBegin, hourEnd, minuteEnd);

        //Log.d(name,"name");

        finish();
    }

    public void cancelSchedule(View view){
        finish();
    }
}
