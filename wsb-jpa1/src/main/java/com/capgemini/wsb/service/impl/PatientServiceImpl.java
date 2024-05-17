package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientTO findByID(Long id) {
        PatientEntity patient = patientDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        return PatientMapper.toTO(patient);
    }

    @Override
    public PatientTO addPatient(PatientTO patientTO) {
        PatientEntity patient = PatientMapper.mapToEntity(patientTO);
        patient = patientDao.save(patient);
        return PatientMapper.toTO(patient);
    }

    @Override
    public PatientTO updatePatient(PatientTO patientTO) {
        PatientEntity patient = patientDao.findById(patientTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        patient.setFirstName(patientTO.getFirstName());
        patient.setLastName(patientTO.getLastName());
        patient = patientDao.save(patient);
        return PatientMapper.toTO(patient);
    }

    @Override
    public void deletePatient(Long id) {
        PatientEntity patient = patientDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        patientDao.delete(patient);

    }

    @Override
    public PatientTO findById(Long id) {
        return null;
    }
}
