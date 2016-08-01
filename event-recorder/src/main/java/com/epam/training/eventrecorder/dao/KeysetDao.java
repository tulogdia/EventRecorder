package com.epam.training.eventrecorder.dao;

import com.epam.training.eventrecorder.domain.Keyset;

public interface KeysetDao {

    public void deleteKeyset(Keyset ks);

    public void saveOrUpdateKeyset(Keyset ks);
}
