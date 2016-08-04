package com.epam.eventrecorder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "keyevent", catalog = "eventrecorder")
public class KeyEvent implements java.io.Serializable {

    public static final int EVENT_NAME_MAX_LENGTH = 20;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 1, name = "keystroke")
    private String keystroke;
    @Column(length = EVENT_NAME_MAX_LENGTH, name = "eventname")
    private String eventName;
    @Column(name = "instantaneous")
    private Boolean instantaneous;

    public KeyEvent() {
    }

    public KeyEvent(String keystroke, String eventname, Boolean instantaneous) {
        this.keystroke = keystroke;
        this.eventName = eventname;
        this.instantaneous = instantaneous;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeystroke() {
        return keystroke;
    }

    public void setKeystroke(String keystroke) {
        this.keystroke = keystroke;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Boolean isInstantaneous() {
        return instantaneous;
    }

    public void setInstantaneous(Boolean instantaneous) {
        this.instantaneous = instantaneous;
    }

    @Override
    public String toString() {
        return eventName;
    }
}
