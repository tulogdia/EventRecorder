package com.epam.eventrecorder.keyset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.eventrecorder.keyset.dao.KeysetDao;
import com.epam.eventrecorder.keyset.domain.Keyset;

@Service
public class AddKeysetService {

    @Autowired
    private KeysetDao keysetDao;

    public void addKeyset(Keyset keyset) {
        keysetDao.saveKeyset(keyset);
    }
}
