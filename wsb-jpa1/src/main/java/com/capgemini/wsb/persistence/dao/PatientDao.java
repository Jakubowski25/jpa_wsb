package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientDao extends JpaRepository<PatientEntity, Long> {


    Optional<PatientEntity> findById(Long id);

    List<PatientEntity> findAll();

    PatientEntity save(PatientEntity patient);

    @Override
    void delete(PatientEntity patient);

    List<PatientEntity> findByLastName(String lastName);

    @Query("SELECT p FROM PatientEntity p WHERE (SELECT COUNT(v) FROM VisitEntity v WHERE v.patient.id = p.id) > :numberOfVisits")
    List<PatientEntity> findPatientsWithMoreThanXVisits(@Param("numberOfVisits") long numberOfVisits);

    @Query("SELECT p FROM PatientEntity p WHERE p.dateOfBirth > :date")
    List<PatientEntity> findPatientsBornAfter(@Param("date") Date date);
}
