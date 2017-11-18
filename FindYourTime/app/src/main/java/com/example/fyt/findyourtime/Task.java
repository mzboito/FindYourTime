package com.example.fyt.findyourtime;

import com.example.fyt.findyourtime.Info;

/**
 * Created by mzboito on 18/11/17.
 */


public class Task {
    String name;
    int priority;
    Info.task_type type;

    public Task(String name, int priority, Info.task_type type){
        this.name = name;
        this.priority = priority;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public Info.task_type getType() {
        return type;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
