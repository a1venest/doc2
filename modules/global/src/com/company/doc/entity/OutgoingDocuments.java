package com.company.doc.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Table(name = "DOCS_OUTGOING_DOCUMENTS")
@Entity(name = "docs_OutgoingDocuments")
@NamePattern("%s|name")
public class OutgoingDocuments extends StandardEntity {
    private static final long serialVersionUID = -6307216874747412804L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DOC_TYPE_ID")
    private DocumentType docType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private FileDescriptor document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INITIATOR_ID")
    private Employees initiator;

    @OneToMany(mappedBy = "outgoingDocuments")
    private List<Subdivisions> subdivision;

    @JoinColumn(name = "EXECUTOR_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Employees executor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Employees divisionHead;

    @Column(name = "REG_NUMBER")
    private String regNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "REG_DATA")
    private Date regData;

    @Column(name = "WHOM")
    private String whom;

    @Column(name = "THEME")
    private String theme;

    @Column(name = "ADDRESSEE")
    private String addressee;

    @JoinColumn(name = "SIGNATORY")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employees signatory;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AUTHOR")
    private String author;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_CREATION")
    private Date dateOfCreation;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_CHANGE")
    private Date dateOfChange;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ACCEPTANCE_REQUIRED")
    protected Boolean acceptanceRequired = false;

    public FileDescriptor getDocument() {
        return document;
    }

    public void setDocument(FileDescriptor document) {
        this.document = document;
    }

    public void setDivisionHead(Employees divisionHead) {
        this.divisionHead = divisionHead;
    }

    public Employees getDivisionHead() {
        return divisionHead;
    }

    public void setExecutor(Employees executor) {
        this.executor = executor;
    }

    public Employees getExecutor() {
        return executor;
    }

    public void setSignatory(Employees signatory) {
        this.signatory = signatory;
    }

    public Employees getSignatory() {
        return signatory;
    }

    public Employees getInitiator() {
        return initiator;
    }

    public void setInitiator(Employees initiator) {
        this.initiator = initiator;
    }

    public void setAcceptanceRequired(Boolean acceptanceRequired) {
        this.acceptanceRequired = acceptanceRequired;
    }

    public Boolean getAcceptanceRequired() {
        return acceptanceRequired;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public List<Subdivisions> getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(List<Subdivisions> subdivision) {
        this.subdivision = subdivision;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){this.name = this.docType + " № " + this.regNumber + " от " +this.regData +
            " в " + this.addressee + " " + this.theme;}

    public Date getDateOfChange() {
        return dateOfChange;
    }

    public void setDateOfChange(Date dateOfChange) {
        this.dateOfChange = dateOfChange;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getWhom() {
        return whom;
    }

    public void setWhom(String whom) {
        this.whom = whom;
    }

    public Date getRegData() {
        return regData;
    }

    public void setRegData(Date regData) {
        this.regData = regData;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public DocumentType getDocType() {
        return docType;
    }

    public void setDocType(DocumentType docType) {
        this.docType = docType;
    }
}