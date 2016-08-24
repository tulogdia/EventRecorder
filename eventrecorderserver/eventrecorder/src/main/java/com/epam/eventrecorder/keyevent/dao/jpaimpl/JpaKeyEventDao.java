package com.epam.eventrecorder.keyevent.dao.jpaimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.eventrecorder.keyevent.dao.KeyEventDao;
import com.epam.eventrecorder.keyevent.dao.repository.KeyEventRepository;
import com.epam.eventrecorder.keyevent.domain.KeyEvent;

@Repository("keyEventDao")
public class JpaKeyEventDao implements KeyEventDao {

    @Autowired
    private KeyEventRepository keyEventRepository;

    @Override
    public void deleteKeyEvent(KeyEvent keyEvent) {
        keyEventRepository.delete(keyEvent);
    }

    @Override
    public void saveOrUpdateKeyEvent(KeyEvent keyevent) {
        keyEventRepository.save(keyevent);

    }

}
