package com.epam.eventrecorder.experiment.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.epam.eventrecorder.keyset.domain.Keyset;
import com.epam.eventrecorder.trial.domain.Trial;

@Entity
@Table
public class Experiment implements java.io.Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "text")
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @ManyToOne
    @JoinColumn
    private Keyset keyset;
    @Column
    private Long trialLength;
    @Column(columnDefinition = "text")
    private String eventMode;
    @OneToMany
    private List<Trial> trials;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
