package com.epam.eventrecorder.dao;

import com.epam.eventrecorder.domain.Experiment;

public interface ExperimentDao {
    public void saveOrUpdateExperiment(Experiment experiment);

    public void deleteExperiment(Experiment exp);
}
