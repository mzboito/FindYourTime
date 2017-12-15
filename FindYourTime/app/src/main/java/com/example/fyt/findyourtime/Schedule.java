package com.example.fyt.findyourtime;

import java.util.List;

/**
 * Created by mzboito on 18/11/17.
 */

public class Schedule {

    String name;
    Info.schedule_date_type type;
    // ver como ajeitar a hora
    int hourBegin;
    int minuteBegin;
    int hourEnd;
    int minuteEnd;
    List<String> l;

    public Schedule(String name, Info.schedule_date_type type, int hourBegin, int minuteBegin, int hourEnd, int minuteEnd){
        this.name = name;
        this.type = type;
        this.hourBegin = hourBegin;
        this.minuteBegin = minuteBegin;
        this.hourEnd = hourEnd;
        this.minuteEnd = minuteEnd;
    }

    public Schedule(String string2Schedule){
        String[] pieces = string2Schedule.split("$$$");
            if(pieces.length == 6){
                this.name = pieces[0];
                switch (pieces[1]){
                    case "WE": this.type = Info.schedule_date_type.weekend;
                    case "WD": this.type = Info.schedule_date_type.weekdays;
                }
                this.hourBegin = Integer.parseInt(pieces[2]);
                this.minuteBegin = Integer.parseInt(pieces[3]);
                this.hourEnd = Integer.parseInt(pieces[4]);
                this.minuteEnd = Integer.parseInt(pieces[5]);
            }
    }

    public String getName() {
        return name;
    }

    public Info.schedule_date_type getType() {
        return type;
    }

    public String toString(){
        String str_type;
        if(this.type == Info.schedule_date_type.weekdays){
            str_type = "WD";
        }else{
            if(this.type == Info.schedule_date_type.weekend){
                str_type = "WE";
            }else{
                return "INV";
            }
        }
        return "S" + "$$$" + this.name + "$$$" + str_type + "$$$" + Integer.toString(this.hourBegin) +
                "$$$" + Integer.toString(this.minuteBegin) + "$$$" + Integer.toString(this.hourEnd) + "$$$" + Integer.toString(this.minuteEnd);
    }
}
