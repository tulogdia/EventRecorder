package com.epam.eventrecorder.dao;

import com.epam.eventrecorder.domain.Keyset;

public interface KeysetDao {

    public void deleteKeyset(Keyset ks);

    public void saveOrUpdateKeyset(Keyset ks);
}
