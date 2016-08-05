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
@Table(name = "keyset", catalog = "eventrecorder")
public class Keyset implements java.io.Serializable {

    public static final int NAME_MAX_LENGTH = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(length = NAME_MAX_LENGTH, name = "name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    private List<KeyEvent> keyEvents;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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