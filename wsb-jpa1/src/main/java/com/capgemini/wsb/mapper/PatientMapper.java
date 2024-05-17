package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.stream.Collectors;

public class PatientMapper {

    public static PatientTO mapToTO(PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }
        PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setDateOfRegistration(patientEntity.getDateOfRegistration());
        // Mapowanie listy wizyt
        if (patientEntity.getVisits() != null) {
            patientTO.setVisits(patientEntity.getVisits().stream()
                    .map(VisitMapper::mapToTO) //VisitMapper ma metodę mapToTO
                    .collect(Collectors.toList()));
        }
        return patientTO;
    }


    public static PatientEntity mapToEntity(PatientTO patientTO) {
        if (patientTO == null) {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setDateOfRegistration(patientTO.getDateOfRegistration());
        return patientEntity;
    }

    public static PatientTO toTO(PatientEntity patient) {
        return null;
    }
}


