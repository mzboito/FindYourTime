package com.example.fyt.findyourtime;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DeleteScheduleActivity extends AppCompatActivity {
    Info info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_schedule);
        setTitle("Delete Schedule");
        info = MainActivity.info;

        showScheduleToDelete();
    }

    public void showScheduleToDelete(){

        if(!info.getSchedule_array().isEmpty()){
            List<String> spinnerArray =  new ArrayList<String>();

            for(Schedule s : info.getSchedule_array()){
                spinnerArray.add(s.getName());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, spinnerArray);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            final Spinner sItems = (Spinner) findViewById(R.id.spinner);
            sItems.setAdapter(adapter);

            Button button = (Button) findViewById(R.id.buttonDelete);

            info.printfSchedule();

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    try{
                        String selected = sItems.getSelectedItem().toString();
                        Log.d(selected, "msg");
                        Log.d("vamo deleta, partiu", "deleta tudo");
                        delete(selected);
                    }catch(Exception e){
                        int i = 2;
                    }

                }
            });
        }
    }

    public void delete(String selected){
        info.deleteSchedule(selected);
        info.printfSchedule();
        finish();
    }

    public void cancelDelete(View view){ finish();}

    @Override
    public void onBackPressed() { // I don't know if this is necessary
        super.onBackPressed();
        this.finish();
    }
}
