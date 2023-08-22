package com.company.doc.listeners;

import com.company.doc.entity.Employees;

import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import org.springframework.stereotype.Component;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.EntityManager;

import javax.inject.Inject;

@Component("doc_EmployeesNumberCreator")
public class EmployeesNumberCreator implements BeforeInsertEntityListener< Employees> {

    @Inject
    protected UniqueNumbersAPI uniqueNumbersAPI;

    @Override
    public void onBeforeInsert(Employees entity, EntityManager entityManager) {

        entity.setNumber("Таб. № " + uniqueNumbersAPI.getNextNumber("Number"));
    }
}



