package com.epam.eventrecorder.keyset.domain;

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

import com.epam.eventrecorder.keyevent.domain.KeyEvent;
import com.epam.eventrecorder.user.domain.User;

@Entity
@Table
public class Keyset implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(columnDefinition = "text")
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    private List<KeyEvent> keyEvents;
    @ManyToOne
    @JoinColumn
    private User user;

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

    public List<KeyEvent> getKeyEvents() {
        return keyEvents;
    }

    public void setKeyEvents(List<KeyEvent> keyEvents) {
        this.keyEvents = keyEvents;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return name;
    }

}
