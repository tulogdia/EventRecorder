package com.epam.training.eventrecorder.dao;

import com.epam.training.eventrecorder.domain.KeyEvent;

public interface KeyEventDao {
    public void deleteKeyEvent(KeyEvent ke);

    public void saveOrUpdateKeyEvent(KeyEvent ke);
}
