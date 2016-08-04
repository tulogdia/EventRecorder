package com.epam.eventrecorder.dao;

import java.util.List;

import com.epam.eventrecorder.domain.Keyset;

public interface KeysetDao {

    public List<Keyset> getKeysetByUserId(Integer userId);

    public void deleteKeyset(Keyset ks);

    public void saveOrUpdateKeyset(Keyset ks);
}
