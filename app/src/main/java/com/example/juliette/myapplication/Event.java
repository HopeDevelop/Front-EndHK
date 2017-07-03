package com.example.juliette.myapplication;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONObject;

public class Event {

    private Date date;
    private String events;

    public Event(Date date, String events) {
        this.date = date;
        this.events = events;

    }

    public Date getDate() {
        return date;
    }

    public String getEvents() {
        return events;
    }
}