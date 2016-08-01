package com.epam.training.eventrecorder.dao;

import com.epam.training.eventrecorder.domain.Trial;

public interface TrialDao {

    public void deleteTrial(Trial trial);

    public void saveTrial(Trial trial);

}
