package com.example.fyt.findyourtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class DeleteTaskActivity extends AppCompatActivity {

    Info info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_task);
        setTitle("Delete Task");
        info = MainActivity.info;

        showTaskToDelete();
    }


    public void showTaskToDelete(){

        if(!info.getTasks_array().isEmpty()){
            List<String> spinnerArray =  new ArrayList<String>();

            for(Task s : info.getTasks_array()){
                spinnerArray.add(s.getName());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, spinnerArray);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            final Spinner sItems = (Spinner) findViewById(R.id.spinner2);
            sItems.setAdapter(adapter);

            Button button = (Button) findViewById(R.id.buttonDelete2);

            info.printfSchedule();

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    try{
                        String selected = sItems.getSelectedItem().toString();
                        //Log.d(selected, "msg");
                        //Log.d("vamo deleta, partiu", "deleta tudo");
                        delete(selected);
                    }catch(Exception e){
                        int i = 2;
                    }
                }
            });

        }
    }

    public void delete(String selected){
        info.deleteTask(selected);
        //info.printfSchedule();
        finish();
    }

    public void cancelDelete(View view){ finish();}

    @Override
    public void onBackPressed() { // I don't know if this is necessary
        super.onBackPressed();
        this.finish();
    }
}

