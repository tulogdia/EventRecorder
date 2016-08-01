package com.epam.training.eventrecorder.dao.jpaimpl;

import com.epam.training.eventrecorder.dao.ExperimentDao;
import com.epam.training.eventrecorder.domain.Experiment;

public class JpaExperimentDao extends GenericJpaDao implements ExperimentDao {

    @Override
    public void saveOrUpdateExperiment(Experiment experiment) {
        entityManager.persist(experiment);
    }

    @Override
    public void deleteExperiment(Experiment experiment) {
        entityManager.remove(experiment);
    }

}
