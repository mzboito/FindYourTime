package com.example.fyt.findyourtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class NewTaskActivity extends AppCompatActivity {
    Info info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        setTitle("Adding a New Task");
        info = MainActivity.info;
    }

    public void tester(String message){
        //Intent i = getIntent();
        //Info infoTasks = (Info)i.getSerializableExtra("InfoClass");
        //infoTasks.add_task("teste",5,Info.task_type.hobby);
        //Task t = infoTasks.getTasks_array().get(0);
        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setText(message);
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_new_task);
        layout.addView(textView);
    }

    public void cancel(View view){
        finish();
    }

    public void register(View view){
        // register and then finish
        EditText editText = (EditText)findViewById(R.id.nt_editText);
        String name = editText.getText().toString();
        if(name.equals("Task Name")){ //no name was given
            name = "task0" + String.valueOf(info.getId());
            info.iterId();
        }else{
            if(info.alreadyUsed(name)){
                //then add something to the end
            }
        }
        SeekBar seekBar = (SeekBar)findViewById(R.id.nt_seekBar);
        int priority = seekBar.getProgress();
        Switch nt_switch = (Switch)findViewById(R.id.nt_switch);
        Info.task_type type;
        if(nt_switch.isChecked()){ // then it's a duty
            type = Info.task_type.duty;
        }
        else{
            type = Info.task_type.hobby;
        }
        tester(name);
        info.add_task(name, priority, type);
        finish();
    }


    @Override
    public void onBackPressed() { // I don't know if this is necessary
        super.onBackPressed();
        this.finish();
    }
}
