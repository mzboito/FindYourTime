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
        Intent i = getIntent();
        info = (Info)i.getSerializableExtra("InfoClass");

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
        Switch nt_switch = (Switch)findViewById(R.id.nt_switch);
        Info.task_type type;
        if(nt_switch.isChecked()){ // then it's a duty
            type = Info.task_type.duty;
        }
        else{
            type = Info.task_type.hobby;
        }
        info.add_task(name, priority, type);
        //popup();
        finish();
    }

    public void popup(){
        // get a reference to the already created main layout
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.activity_new_task);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() { // I don't know if this is necessary
        super.onBackPressed();
        this.finish();
    }
}
