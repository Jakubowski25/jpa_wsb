package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.impl.VisitService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class VisitServiceTest {

    @Autowired
    public VisitService visitService;

    @Test
    public void testFindVisitsByPatientId() {
        List<VisitEntity> visits = visitService.findVisitsByPatientId(1L);
        Assertions.assertFalse(visits.isEmpty());
        Assertions.assertEquals(1L, visits.get(0).getPatient().getId());
    }
}

