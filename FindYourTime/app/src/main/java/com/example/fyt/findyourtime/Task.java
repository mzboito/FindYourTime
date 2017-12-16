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

    public Task(String string2Task){
        String[] pieces = string2Task.split("@@@");
        if(pieces.length == 4){
            this.name = pieces[1];
            this.priority = Integer.parseInt(pieces[2]);
            switch (pieces[3]){
                case "DT": this.type = Info.task_type.duty;
                case "HB": this.type = Info.task_type.hobby;
            }
        }
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

    public String toString(){
        String str_type;
        if(this.type == Info.task_type.duty){
            str_type = "DT";
        }else{
            if(this.type == Info.task_type.hobby){
                str_type = "HB";
            }else{
                return "INV";
            }
        }
        return "T" + "@@@" + this.name + "@@@" + Integer.toString(this.priority) + "@@@" + str_type;
    }

}
