package com.epam.eventrecorder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
@Table(name = "keyset", catalog = "eventrecorder")
public class Keyset implements java.io.Serializable {

    public static final int NAME_MAX_LENGTH = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(length = NAME_MAX_LENGTH, name = "name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "keyset")
    private Set<KeyEvent> keyEvents = new HashSet<>(0);
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "keyset")
    private Set<Experiment> experiments = new HashSet<>(0);
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Keyset() {
    }

    public Keyset(User user) {
        this.user = user;
    }

    public Keyset(String name) {
        this.name = name;
    }

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

    public Set<KeyEvent> getKeyEvents() {
        return keyEvents;
    }

    public void setKeyEvents(Set<KeyEvent> keyEvents) {
        this.keyEvents = keyEvents;
    }

    public Set<Experiment> getExperiments() {
        return experiments;
    }

    public void setExperiments(Set<Experiment> experiments) {
        this.experiments = experiments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<KeyEvent> getKeyEventList() {
        if (getKeyEvents() == null) {
            return null;
        }
        List<KeyEvent> keyEventList = new ArrayList(getKeyEvents());
        Collections.sort(keyEventList, new Comparator<KeyEvent>() {
            @Override
            public int compare(KeyEvent ke1, KeyEvent ke2) {
                return (ke1.getId() - ke2.getId() < 0L) ? -1 : ((ke1.getId() - ke2.getId() > 0L) ? 1 : 0);
            }
        });
        return keyEventList;
    }

    @Override
    public String toString() {
        return name;
    }

}
