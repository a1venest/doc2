package com.company.doc.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Listeners("doc_DocumentTypeCodeCreator")
@PublishEntityChangedEvents
@Table(name = "DOC_DOCUMENT_TYPE")
@Entity(name = "doc_DocumentType")
@NamePattern("%s|name")
public class DocumentType extends StandardEntity {
    private static final long serialVersionUID = -4179017954331132271L;

    @Column(name = "CODE")
    private String code;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

}