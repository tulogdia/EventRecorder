package com.epam.eventrecorder.domain;

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
@Table(name = "event", catalog = "eventrecorder")
public class Event implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nointrial")
    private Integer noInTrial;
    @Column(length = KeyEvent.EVENT_NAME_MAX_LENGTH, name = "name")
    private String name;
    @Column(name = "instant")
    private Boolean instant;
    @Column(name = "starttime")
    private Long startTime;
    @Column(name = "endtime")
    private Long endTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trial_id", nullable = false)
    private Trial trial;

    public Event() {
    }

    // use the following constructor for instantaneous events (either in
    // "OVERLAP", "ATEND" or "ATSTART" mode) and for non-instantaneous events in
    // "ATEND" or "ATSTART" mode
    // for non-instantaneous "OVERLAP" events see the next constructor
    public Event(String name, Boolean instant, Long time, Trial trial) {
        this.noInTrial = noInTrial;
        this.name = name;
        this.instant = instant;
        if (instant) {
            this.startTime = time;
            this.endTime = time;
        } else {
            switch (trial.getExperiment().getEventMode()) {
            case "ATEND":
                this.startTime = null;
                this.endTime = time;
                break;
            case "ATSTART":
                this.startTime = time;
                this.endTime = null;
                break;
            }
        }
        this.trial = trial;
    }

    // use the following constructor for overlapping events, which are not
    // instantaneous
    public Event(String name, Long startTime, Long endTime, Trial trial) {
        this.noInTrial = noInTrial;
        this.name = name;
        this.instant = false;
        this.startTime = startTime;
        this.endTime = endTime;
        this.trial = trial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoInTrial() {
        return noInTrial;
    }

    public void setNoInTrial(Integer noInTrial) {
        this.noInTrial = noInTrial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getInstant() {
        return instant;
    }

    public void setInstant(Boolean instant) {
        this.instant = instant;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Trial getTrial() {
        return trial;
    }

    public void setTrial(Trial trial) {
        this.trial = trial;
    }

}
