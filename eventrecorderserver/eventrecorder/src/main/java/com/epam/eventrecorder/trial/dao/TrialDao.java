package com.epam.eventrecorder.trial.dao;

import com.epam.eventrecorder.trial.domain.Trial;

public interface TrialDao {

    public void deleteTrial(Trial trial);

    public void saveTrial(Trial trial);

}
