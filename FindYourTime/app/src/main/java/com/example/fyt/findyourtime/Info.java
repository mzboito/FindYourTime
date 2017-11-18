package com.example.fyt.findyourtime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzboito on 18/11/17.
 */

public class Info implements Serializable {

    public enum task_type {
        hobby, duty
    }

    List<Task> tasks_array;
    int id;
    int notificationTime;

    public Info(String fileName){

    }

    public Info(){
        tasks_array = new ArrayList<Task>();
        //in the future we will have a schedule <3
        id = 0;
        notificationTime = 30000; //30 seconds for tests
    }

    public List<Task> getTasks_array() {
        return tasks_array;
    }

    public void add_task(String name, int priority, Info.task_type type){
        Task t = new Task(name, priority, type);
        tasks_array.add(t);
        resortList();
    }

    public void delete_task(String taskName){
        //TODO
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


    //TODO function to sort the TASK list

    //TODO function for reading a file with tasks and schedule

    //TODO function to upate the file with tasks and schedule
}
