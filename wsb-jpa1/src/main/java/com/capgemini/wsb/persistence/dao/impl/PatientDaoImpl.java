package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public abstract class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{
    @Override
    public Optional<PatientEntity> findById(Long id) {
        return null;
    }

    @Override
    public PatientEntity save(PatientEntity entity) {
        return super.save(entity);
    }
}
