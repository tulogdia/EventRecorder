package com.epam.eventrecorder.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "experiment", catalog = "eventrecorder")
public class Experiment implements java.io.Serializable {

    public static final int NAME_MAX_LENGTH = 200;
    public static final int DESCR_MAX_LENGTH = 500;
    public static final int EVENT_MODE_MAX_LENGTH = 10;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = NAME_MAX_LENGTH, name = "name")
    private String name;
    @Column(length = DESCR_MAX_LENGTH, name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "keyset_id")
    private Keyset keyset;
    @Column(name = "triallength")
    private Long trialLength;
    @Column(length = EVENT_MODE_MAX_LENGTH, name = "eventmode")
    private String eventMode;
    @OneToMany
    private List<Trial> trials;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Keyset getKeyset() {
        return keyset;
    }

    public void setKeyset(Keyset keyset) {
        this.keyset = keyset;
    }

    public Long getTrialLength() {
        return trialLength;
    }

    public void setTrialLength(Long trialLength) {
        this.trialLength = trialLength;
    }

    public String getEventMode() {
        return eventMode;
    }

    public void setEventMode(String eventMode) {
        this.eventMode = eventMode;
    }

    public List<Trial> getTrials() {
        return trials;
    }

    public void setTrials(List<Trial> trials) {
        this.trials = trials;
    }

    @Override
    public String toString() {
        return name;
    }
}
