package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;

public interface VisitService {
    List<VisitEntity> findVisitsByPatientId(long patientId);

}
