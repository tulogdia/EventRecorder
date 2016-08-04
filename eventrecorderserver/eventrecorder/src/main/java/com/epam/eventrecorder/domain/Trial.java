package com.epam.eventrecorder.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trial", catalog = "eventrecorder")
public class Trial implements java.io.Serializable {

    public static final int NAME_MAX_LENGTH = 50;
    public static final int COMMENT_MAX_LENGTH = 100;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = NAME_MAX_LENGTH, name = "name")
    private String name;
    @Column(length = COMMENT_MAX_LENGTH, name = "comment")
    private String comment;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "trial")
    private List<Event> events;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return name + (comment == null ? "" : " (" + comment + ")");
    }

    // public long getLatency(KeyEvent ke) {
    // if (getEvents() == null || getEvents().size() < 1) {
    // return 0;
    // }
    // for (Event e : getEventsList()) {
    // if (e.getName().equals(ke.getEventName())) {
    // if (e.getInstant()) {
    // return e.getEndTime();
    // } else {
    // int lastNonInstantIndex = e.getNoInTrial() - 1;
    // while (0 <= lastNonInstantIndex &&
    // getEventsList().get(lastNonInstantIndex).getInstant()) {
    // lastNonInstantIndex--;
    // }
    // if (lastNonInstantIndex == -1) {
    // return 0;
    // } else {
    // return getEventsList().get(lastNonInstantIndex).getEndTime();
    // }
    // }
    // }
    // }
    // return getEventsList().get(getEventsList().size() - 1).getEndTime();
    // }
    //
    // public int getFrequency(KeyEvent ke) {
    // int fr = 0;
    // for (Event e : getEventsList()) {
    // if (e.getName().equals(ke.getEventName())) {
    // fr++;
    // }
    // }
    // return fr;
    // }
    //
    // public double getTime(KeyEvent ke) {
    // if (ke.isInstantaneous()) {
    // return 0;
    // } else {
    // double time = 0;
    // for (Event e : getEventsList()) {
    // if (e.getName().equals(ke.getEventName())) {
    // int lastNonInstantIndex = e.getNoInTrial() - 1;
    // while (0 <= lastNonInstantIndex &&
    // getEventsList().get(lastNonInstantIndex).getInstant()) {
    // lastNonInstantIndex--;
    // }
    // double currTime;
    // if (lastNonInstantIndex == -1) {
    // currTime = e.getEndTime();
    // } else {
    // currTime = e.getEndTime() -
    // getEventsList().get(lastNonInstantIndex).getEndTime();
    // }
    // time += currTime;
    // }
    // }
    // return time;
    // }
    // }
    //
    // public double getTimePC(KeyEvent ke) {
    // if (getEvents() == null || getEvents().size() < 1) {
    // return 0.0;
    // } else {
    // long totalTime = getEventsList().get(getEventsList().size() -
    // 1).getEndTime();
    // return getTime(ke) / totalTime * 100;
    // }
    // }

}
