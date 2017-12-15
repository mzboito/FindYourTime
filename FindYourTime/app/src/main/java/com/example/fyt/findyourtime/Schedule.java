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

    public String getName() {
        return name;
    }

    public Info.schedule_date_type getType() {
        return type;
    }

}
