package com.epam.eventrecorder.keyevent.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class KeyEvent implements java.io.Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1)
    private String keystroke;
    @Column(columnDefinition = "text")
    private String eventName;
    @Column
    private Boolean instantaneous;

    public KeyEvent() {
    }

    public KeyEvent(String keystroke, String eventname, Boolean instantaneous) {
        this.keystroke = keystroke;
        this.eventName = eventname;
        this.instantaneous = instantaneous;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
