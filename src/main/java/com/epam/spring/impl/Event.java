package com.epam.spring.impl;


import javax.swing.event.HyperlinkEvent;
import java.time.LocalDateTime;
import java.util.Date;

public class Event {

    private Integer id;
    private String message;
    private LocalDateTime date;
    private EvenType type;

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

    public LocalDateTime getDate() {
        return date;
    }

    public EvenType getType() {
        return type;
    }

    public void setType(EvenType type) {
        this.type = type;
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
