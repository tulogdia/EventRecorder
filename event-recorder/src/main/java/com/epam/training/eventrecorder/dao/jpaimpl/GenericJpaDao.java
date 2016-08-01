package com.epam.training.eventrecorder.dao.jpaimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericJpaDao {

	@PersistenceContext
	protected EntityManager entityManager;

	
}
