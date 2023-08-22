package com.company.doc.listeners;

import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.company.doc.entity.Subdivisions;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component("doc_SubdivisionsCodeCreator")
public class SubdivisionsCodeCreator implements BeforeInsertEntityListener<Subdivisions> {
    @Inject
    protected UniqueNumbersAPI uniqueNumbersAPI;
    @Override
    public void onBeforeInsert(Subdivisions entity, EntityManager entityManager) {

        entity.setCode("КП " + uniqueNumbersAPI.getNextNumber("Code"));
    }
}