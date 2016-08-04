package com.epam.eventrecorder.dao;

import java.util.List;

import com.epam.eventrecorder.domain.Event;

public interface EventDao {
    public void saveEventList(List<Event> events);

}
