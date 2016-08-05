package com.epam.eventrecorder.keysetlist.view.model;

import java.util.List;

import com.epam.eventrecorder.keyevent.domain.KeyEvent;

public class KeysetSummary {
    private Integer id;
    private String name;
    private List<KeyEvent> keyEvents;

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

    public List<KeyEvent> getKeyEvents() {
        return keyEvents;
    }

    public void setKeyEvents(List<KeyEvent> keyEvents) {
        this.keyEvents = keyEvents;
    }

}
