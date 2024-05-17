package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface PatientService {

    PatientTO findByID(Long id);

    PatientTO addPatient(PatientTO patientTO);

    PatientTO updatePatient(PatientTO patientTO);

    void deletePatient(Long id);

    PatientTO findById(Long id);

    @Service
    public class PatientServiceImpl implements PatientService {

        private final PatientDao patientDao;

        @Autowired
        public PatientServiceImpl(PatientDao patientDao) {
            this.patientDao = patientDao;
        }

        @Override
        public PatientTO findByID(Long id) {
            return null;
        }

        @Override
        public PatientTO addPatient(PatientTO patientTO) {
            return null;
        }

        @Override
        public PatientTO updatePatient(PatientTO patientTO) {
            return null;
        }

        @Override
        public void deletePatient(Long id) {

        }

        @Override
        public PatientTO findById(Long id) {
            return null;
        }
    }
}
