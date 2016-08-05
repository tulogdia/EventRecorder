package com.epam.eventrecorder.event.dao;

import java.util.List;

import com.epam.eventrecorder.event.domain.Event;

public interface EventDao {
    public void saveEventList(List<Event> events);

}
