package com.epam.eventrecorder.keyset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.eventrecorder.keyset.dao.KeysetDao;
import com.epam.eventrecorder.keyset.domain.Keyset;

@Service
public class KeysetListService {

    @Autowired
    KeysetDao keysetDao;

    public List<Keyset> getKeysetByUserId(Long userId) {
        return keysetDao.getKeysetByUserId(userId);
    }

}
