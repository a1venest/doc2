package com.company.doc.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Listeners({"doc_SubdivisionsCodeCreator"})
@PublishEntityChangedEvents
@Table(name = "DOC_SUBDIVISIONS")
@Entity(name = "doc_Subdivisions")
@NamePattern("%s|name")
public class Subdivisions extends StandardEntity {
    private static final long serialVersionUID = -2399479284696886815L;

    @Column(name = "CODE")
    private String code;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @JoinColumn(name = "DIVISION_HEAD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employees divisionHead;

    @JoinColumn(name = "LEAD_DIVISION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Subdivisions leadDivision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OUTGOING_DOCUMENTS_ID")
    private OutgoingDocuments outgoingDocuments;


    public void setLeadDivision(Subdivisions leadDivision) {
        this.leadDivision = leadDivision;
    if (this.name == leadDivision.name) this.leadDivision = null;}


    public Subdivisions getLeadDivision() {
        return leadDivision;
    }


    public OutgoingDocuments getOutgoingDocuments() {
        return outgoingDocuments;
    }

    public void setOutgoingDocuments(OutgoingDocuments outgoingDocuments) {
        this.outgoingDocuments = outgoingDocuments;
    }

    public Employees getDivisionHead() {
        return divisionHead;
    }

    public void setDivisionHead(Employees divisionHead) {
        this.divisionHead = divisionHead;
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

    public void setCode(String code) {
        this.code = code;
    }


    public boolean equals(Subdivisions leadDivision){
        if(this == leadDivision) return  true;
        if (leadDivision == null || getClass() != leadDivision.getClass()) return false;

        Subdivisions that = (Subdivisions) leadDivision;
        return leadDivision.equals(that.leadDivision);
    }

}