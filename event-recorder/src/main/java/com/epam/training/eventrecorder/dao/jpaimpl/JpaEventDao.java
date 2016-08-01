package com.epam.training.eventrecorder.dao.jpaimpl;

import java.util.List;

import com.epam.training.eventrecorder.dao.EventDao;
import com.epam.training.eventrecorder.domain.Event;

public class JpaEventDao extends GenericJpaDao implements EventDao {

    @Override
    public void saveEventList(List<Event> events) {
        for (Event event : events) {
            entityManager.persist(event);
        }
    }

}
