package com.epam.eventrecorder.keyset.dao;

import java.util.List;

import com.epam.eventrecorder.keyset.domain.Keyset;

public interface KeysetDao {

    public List<Keyset> getKeysetByUserId(Integer userId);

    public void deleteKeyset(Keyset ks);

    public void saveOrUpdateKeyset(Keyset ks);
}
