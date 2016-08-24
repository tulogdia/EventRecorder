package com.epam.eventrecorder.keyevent.dao.repository;

import org.springframework.data.repository.CrudRepository;

import com.epam.eventrecorder.keyevent.domain.KeyEvent;

public interface KeyEventRepository extends CrudRepository<KeyEvent, Long> {

}
