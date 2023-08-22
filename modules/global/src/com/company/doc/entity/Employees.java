package com.company.doc.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;

@Table(name = "DOC_EMPLOYEES")
@Entity(name = "doc_Employees")
@Listeners("doc_EmployeesNumberCreator")
@PublishEntityChangedEvents
@NamePattern("%s|user")
public class Employees extends StandardEntity {
    private static final long serialVersionUID = 4211176996350799080L;

    @Column(name = "NUMBER_")
    private String number;

    @JoinColumn(name = "USER_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "PHONE")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBDIVISION_ID")
    private Subdivisions subdivision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PHOTO_ID")
    private FileDescriptor photo;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Subdivisions getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(Subdivisions subdivision) {
        this.subdivision = subdivision;
    }

    public FileDescriptor getPhoto() {
        return photo;
    }

    public void setPhoto(FileDescriptor photo) {
        this.photo = photo;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}