package com.epam.eventrecorder.dao;

import com.epam.eventrecorder.domain.KeyEvent;

public interface KeyEventDao {
    public void deleteKeyEvent(KeyEvent ke);

    public void saveOrUpdateKeyEvent(KeyEvent ke);
}
