package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.service.PatientService;

public class PatientServiceImplBuilder {
    private PatientDao pPatientDao;

    public PatientServiceImplBuilder setpPatientDao(PatientDao pPatientDao) {
        this.pPatientDao = pPatientDao;
        return this;
    }

    public PatientService.PatientServiceImpl createPatientServiceImpl() {
        return new PatientService.PatientServiceImpl(pPatientDao);
    }
}