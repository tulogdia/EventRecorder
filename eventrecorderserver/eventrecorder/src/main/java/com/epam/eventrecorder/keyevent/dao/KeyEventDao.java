package com.epam.eventrecorder.keyevent.dao;

import com.epam.eventrecorder.keyevent.domain.KeyEvent;

public interface KeyEventDao {
    public void deleteKeyEvent(KeyEvent ke);

    public void saveOrUpdateKeyEvent(KeyEvent ke);
}
