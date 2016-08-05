package com.epam.eventrecorder.keyset.dao.jpaimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.eventrecorder.keyset.dao.KeysetDao;
import com.epam.eventrecorder.keyset.dao.repository.KeysetRepository;
import com.epam.eventrecorder.keyset.domain.Keyset;

@Repository("keysetDao")
public class JpaKeysetDao implements KeysetDao {

    @Autowired
    private KeysetRepository keysetRepository;

    @Override
    public List<Keyset> getKeysetByUserId(Integer userId) {
        return keysetRepository.findAllByUser_Id(userId);
    }

    @Override
    public void deleteKeyset(Keyset ks) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveOrUpdateKeyset(Keyset ks) {
        // TODO Auto-generated method stub

    }

}
