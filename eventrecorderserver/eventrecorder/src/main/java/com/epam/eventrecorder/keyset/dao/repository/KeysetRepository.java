package com.epam.eventrecorder.keyset.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.eventrecorder.keyset.domain.Keyset;

public interface KeysetRepository extends CrudRepository<Keyset, Integer> {

    @Override
    Keyset findOne(Integer Id);

    List<Keyset> findAllByUser_Id(Integer userId);
}
