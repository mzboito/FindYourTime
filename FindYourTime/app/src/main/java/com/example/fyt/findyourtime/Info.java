package com.example.fyt.findyourtime;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mzboito on 18/11/17.
 */

public class Info implements Serializable {
<<<<<<< HEAD
    String user_info_file = "FYT.saved.info";
=======
    String dumpFileName = "FYT.dump.file";
>>>>>>> f67f447d1babb9ceb2eee1a3f3b7592e9fbe222b

    public enum task_type {
        hobby, duty
    }

    public enum schedule_date_type {
        weekdays, weekend
    }

    List<Task> tasks_array;
    List<Schedule> schedule_array;
    int id;
    int notificationTime;

    public Info(String fileName){
        //read from a file
    }

    public Info(){
        //try to read from the file
        //if there is no file, create these values above
        tasks_array = new ArrayList<Task>();
        schedule_array = new ArrayList<Schedule>();
        id = 0;
        notificationTime = 30000; //30 seconds for tests
    }

    public List<Task> getTasks_array() {
        return tasks_array;
    }

    public List<Schedule> getSchedule_array() {return schedule_array;}

    public void add_task(String name, int priority, Info.task_type type){
        Task t = new Task(name, priority, type);
        tasks_array.add(t);
        resortList();
    }

    public void add_schedule(String name, Info.schedule_date_type type, int hourBegin, int minuteBegin, int hourEnd, int minuteEnd){
        Schedule s = new Schedule(name, type, hourBegin, minuteBegin, hourEnd, minuteEnd);
        schedule_array.add(s);

    }


    public int getNotificationTime() {
        return notificationTime;
    }

    public int getId() {
        return id;
    }

    public void iterId() {
        id = id + 1;
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
    }

    public void deleteSchedule(String name){
        Schedule s = findSchedule(name);
        if(s != null){
            tasks_array.remove(s);
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

    public void saveNewInfo() throws IOException {
    public void updateFile(){
        //write in the file the new information gave by the user
        //try to read from our file
        //if not possible, create one

        /*EXAMPLE OF HOW TO WRITE A FILE*/
        /*String filename = "myfile";
        String string = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
            //setTitle("EU ESCREVI");
        } catch (Exception e) {
            e.printStackTrace();
            //setTitle("NEM ESCREVI");
        }*/
        /*

        FileInputStream inputStream = openFileInput(filename, Context.MODE_PRIVATE);
        String inputStreamString = new Scanner(inputStream,"UTF-8").useDelimiter("\\A").next();
        //setTitle(inputStreamString);
       */

    }
    private int read_file(){
        return -1;
    }

    private int write_file(){
        return -1;
    }

    public String toString(){
        return "I" + "$$$" + Integer.toString(this.id) + "$$$" + Integer.toString(this.notificationTime);
    }

}
