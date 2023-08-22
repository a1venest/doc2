package com.company.doc.listeners;

import com.company.doc.entity.DocumentType;
import com.haulmont.cuba.core.app.UniqueNumbersAPI;


import org.springframework.stereotype.Component;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.EntityManager;

import javax.inject.Inject;

@Component("doc_DocumentTypeCodeCreator")
public class DocumentTypeCodeCreator implements BeforeInsertEntityListener<DocumentType> {

    @Inject
    protected UniqueNumbersAPI uniqueNumbersAPI;


    @Override
    public void onBeforeInsert(DocumentType entity, EntityManager entityManager) {

        entity.setCode("ВД00000" + uniqueNumbersAPI.getNextNumber("Code"));

    }
}
