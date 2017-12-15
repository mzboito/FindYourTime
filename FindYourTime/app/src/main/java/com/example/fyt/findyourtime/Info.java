package com.example.fyt.findyourtime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzboito on 18/11/17.
 */

public class Info implements Serializable {
    String dumpFileName = "FYT.dump.file";

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

    public void updateFile(){
        //write in the file the new information gave by the user
    }

    public String toString(){
        return "I" + "$$$" + Integer.toString(this.id) + "$$$" + Integer.toString(this.notificationTime);
    }

}
