package com.example.fyt.findyourtime;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mzboito on 18/11/17.
 */

public class Info implements Serializable {
    String dumpFileName = "FYT.dump.file";
    Context context;
    //final String TAG = Info.class.getName();
    String path;

    public enum task_type {
        hobby, duty
    }

    public enum schedule_date_type {
        weekdays, weekend, both
    }

    List<Task> tasks_array;
    List<Schedule> schedule_array;
    int id;
    int notificationTime;

    public Info(Context context){
        this.context = context;
        this.path = this.context.getExternalCacheDir().getPath();
        tasks_array = new ArrayList<Task>();
        schedule_array = new ArrayList<Schedule>();
        id = 0;
        notificationTime = 30000; //30 seconds for tests

        try {
            read_file();
        } catch (FileNotFoundException e){
            try {
                write_file();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("INFO", Integer.toString(tasks_array.size()));
        //try to read from the file
        //if there is no file, create these values above

    }

    public List<Task> getTasks_array() {
        return tasks_array;
    }

    public List<Schedule> getSchedule_array() {return schedule_array;}

    public void add_task(String name, int priority, Info.task_type type){
        Task t = new Task(name, priority, type);
        tasks_array.add(t);
        resortList();
        try {
            write_file();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add_schedule(String name, Info.schedule_date_type type, int hourBegin, int minuteBegin, int hourEnd, int minuteEnd){
        Schedule s = new Schedule(name, type, hourBegin, minuteBegin, hourEnd, minuteEnd);
        schedule_array.add(s);
        try {
            write_file();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int getNotificationTime() {
        return notificationTime;
    }

    public int getId() {
        return id;
    }

    public void iterId() {
        id = id + 1;
        try {
            write_file();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resortList() {
        if(!tasks_array.isEmpty()){
            Task removedTask = tasks_array.get(0);
            tasks_array.remove(0);
            tasks_array.add(removedTask);
        }
    }

    public void deleteTask(String name){
        Task t = findTask(name);
        if(t != null){
            tasks_array.remove(t);
        }
        try {
            write_file();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteSchedule(String name){
        Schedule s = findSchedule(name);
        if(s != null){
            schedule_array.remove(s);
            Log.d(s.getName(), "deletei");
        }
    }

    public Schedule findSchedule(String name){
        for(Schedule s : schedule_array){
            if(s.name.equals(name)){
                return s;
            }
        }
        return null;
    }

    public void printfSchedule(){
        for(Schedule s : schedule_array)
            Log.d(s.getName(), "prit schedule");
    }

    public Task findTask(String name){
        for(Task t : tasks_array){
            if(t.name.equals(name)){
                return t;
            }
        }
        return null;
    }

    public boolean alreadyUsed(String name){
        for(Task t : tasks_array){
            if(t.name.equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean alreadyUsedSchedule(String name){
        for(Schedule s : schedule_array){
            if(s.name.equals(name)){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return "I" + "@@@" + Integer.toString(this.id) + "@@@" + Integer.toString(this.notificationTime);
    }

    /********************************************************************/

    private void read_file() throws FileNotFoundException, IOException {
        String content = null;
        FileInputStream fstream = new FileInputStream(new File(path + this.dumpFileName));
        InputStreamReader ireader = new InputStreamReader(fstream);
        BufferedReader breader = new BufferedReader(ireader);
        StringBuilder stringBuilder = new StringBuilder();
        while((content = breader.readLine()) != null){
            stringBuilder.append(content + System.getProperty("line.separator"));
        }
        fstream.close();
        content = stringBuilder.toString();
        for(String line : content.split(System.getProperty("line.separator"))){
            String[] piece = line.split("@@@");
            if(piece[0].equals("I")){
                this.id = Integer.parseInt(piece[1]);
                this.notificationTime = Integer.parseInt(piece[2]);
            }else{
                if(piece[0].equals("T")){
                    Task t = new Task(line);
                    if(t != null){
                        this.tasks_array.add(t);
                        Log.d("TASK", t.getName() + " ");
                    }
                }else{
                    if(piece[0].equals("S")){
                        Schedule s = new Schedule(line);
                        if(s != null){
                            this.schedule_array.add(s);
                            Log.d("SCHED", s.getName() + " ");
                            Log.d("SCHED", piece[1] + " ");
                        }
                    }
                }
            }

            Log.d("READ", line);
            Log.d("PIECE[0]", piece[0]);
            Log.d("SIZE", Integer.toString(this.tasks_array.size()));
        }
        breader.close();
    }

    private void write_file() throws FileNotFoundException, IOException {
        File file = new File(path+ this.dumpFileName);
        if (!file.exists()) {
            file.createNewFile();
        }else{
            FileOutputStream fostream = new FileOutputStream(file, false);
            fostream.write((this.toString() + System.getProperty("line.separator")).getBytes()); //write id and notificationTime
            for(Task t : this.tasks_array){ //write all tasks
                if(t != null){
                    fostream.write((t.toString()+ System.getProperty("line.separator")).getBytes());
                    Log.d("WRITE", t.toString()+ "AAA");
                }
            }
            for(Schedule s : this.schedule_array){ //write all schedules
                if(s != null){
                    fostream.write((s.toString()+ System.getProperty("line.separator")).getBytes());
                    Log.d("WRITE", s.toString() + "AAA");
                }

            }
        }
    }

    public boolean scheduleConfict(){
        for(Schedule s : this.schedule_array){

        }
        //TODO CHECK IF CAN DO THE NOTIFICATION OR NOT
        return false;
    }

    public String getGreeting(){
        return "BOM DIA!!";
    }
}
