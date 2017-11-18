package com.example.fyt.findyourtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class NewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        setTitle("Adding a New Task");
        //onBackPressed();
        //finish();

    }

    public void tester(){
        Intent i = getIntent();
        Info infoTasks = (Info)i.getSerializableExtra("InfoClass");
        infoTasks.add_task("teste",5,Info.task_type.hobby);
        Task t = infoTasks.getTasks_array().get(0);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(t.name);
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
        SeekBar seekBar = (SeekBar)findViewById(R.id.nt_seekBar);
        int priority = Integer.valueOf(seekBar.toString());
        Switch Switch = (Switch)findViewById(R.id.nt_switch);
        

        finish();
    }

    @Override
    public void onBackPressed() { // I don't know if this is necessary
        super.onBackPressed();
        this.finish();
    }
}
