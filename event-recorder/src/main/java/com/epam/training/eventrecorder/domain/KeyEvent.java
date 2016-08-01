package com.epam.training.eventrecorder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "keyevent", catalog = "eventrecorder")
public class KeyEvent implements java.io.Serializable {

    public static final int EVENT_NAME_MAX_LENGTH = 20;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "keyset_id")
    private Keyset keyset;
    @Column(length = 1, name = "keystroke")
    private String keystroke;
    @Column(length = EVENT_NAME_MAX_LENGTH, name = "eventname")
    private String eventName;
    @Column(name = "instantaneous")
    private Boolean instantaneous;

    public KeyEvent() {
    }

    public KeyEvent(Keyset keyset, String keystroke, String eventname, Boolean instantaneous) {
        this.keyset = keyset;
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

    public Keyset getKeyset() {
        return keyset;
    }

    public void setKeyset(Keyset keyset) {
        this.keyset = keyset;
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
