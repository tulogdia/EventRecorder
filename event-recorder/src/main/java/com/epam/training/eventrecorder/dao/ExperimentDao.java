package com.epam.training.eventrecorder.dao;

import com.epam.training.eventrecorder.domain.Experiment;

public interface ExperimentDao {
    public void saveOrUpdateExperiment(Experiment experiment);

    public void deleteExperiment(Experiment exp);
}
