package com.epam.training.eventrecorder.dao;

import java.util.List;

import com.epam.training.eventrecorder.domain.Event;

public interface EventDao {
    public void saveEventList(List<Event> events);

}
