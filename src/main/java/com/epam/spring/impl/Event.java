package com.epam.spring.impl;


import java.time.LocalDateTime;
import java.util.Date;

public class Event {

    private Integer id;
    private String message;
    private LocalDateTime date;

    public Event() {
    }

    public Event(Integer id, String message, LocalDateTime date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}' + '\n';
    }
}
