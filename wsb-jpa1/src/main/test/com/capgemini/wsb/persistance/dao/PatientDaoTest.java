package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    public void testFindByLastName() {
        List<PatientEntity> patients = patientDao.findByLastName("Maj");
        Assertions.assertFalse(patients.isEmpty());
        Assertions.assertEquals("Świątek", patients.get(0).getLastName());
    }

    @Test
    public void testFindPatientsWithMoreThanXVisits() {
        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanXVisits(2L);
        Assertions.assertFalse(patients.isEmpty());

    }

    @Test
    public void testFindPatientsBornAfter() {
        List<PatientEntity> patients = patientDao.findPatientsBornAfter(Date.valueOf("1988-01-01"));
        Assertions.assertFalse(patients.isEmpty());
        Assertions.assertTrue(patients.get(0).getDateOfBirth().after(Date.valueOf("1988-01-01")));
    }
}
