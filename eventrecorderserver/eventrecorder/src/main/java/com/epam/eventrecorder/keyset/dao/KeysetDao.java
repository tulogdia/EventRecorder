package com.epam.eventrecorder.keyset.dao;

import java.util.List;

import com.epam.eventrecorder.keyset.domain.Keyset;

public interface KeysetDao {

    public List<Keyset> getKeysetByUserId(Long userId);

    public void deleteKeyset(Keyset keyset);

    public void saveKeyset(Keyset keyset);
}
