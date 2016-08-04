package com.epam.eventrecorder.dao;

import com.epam.eventrecorder.domain.Trial;

public interface TrialDao {

    public void deleteTrial(Trial trial);

    public void saveTrial(Trial trial);

}
