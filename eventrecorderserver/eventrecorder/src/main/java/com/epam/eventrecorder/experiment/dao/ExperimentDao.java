package com.epam.eventrecorder.experiment.dao;

import com.epam.eventrecorder.experiment.domain.Experiment;

public interface ExperimentDao {
    public void saveOrUpdateExperiment(Experiment experiment);

    public void deleteExperiment(Experiment exp);
}
