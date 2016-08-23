package com.epam.eventrecorder.event.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.epam.eventrecorder.trial.domain.Trial;

@Entity
@Table
public class Event implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private Integer noInTrial;
    @Column(columnDefinition = "text")
    private String name;
    @Column
    private Boolean instant;
    @Column
    private Long startTime;
    @Column
    private Long endTime;
    @ManyToOne
    @JoinColumn
    private Trial trial;

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
