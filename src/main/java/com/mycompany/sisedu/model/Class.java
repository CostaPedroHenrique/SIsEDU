package com.mycompany.sisedu.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author pedrohenrique
 */
@Entity
@Table(name="class")
public class Class {
    @Id
    private Integer registrationCode;

    @Column(name="shift")
    private String shift;
    
    @Column(name="active")
    private boolean active;
    
    @Column(name="classroom")
    private String classroom;
    
    @Column(name="capacityStudents")
    private int capacityStudents;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_school",nullable=false)
    private School school;

    public Integer getRegistrationCode() {
        return registrationCode;
    }

    public String getShift() {
        return shift;
    }

    public boolean isActive() {
        return active;
    }

    public String getClassroom() {
        return classroom;
    }

    public int getCapacityStudents() {
        return capacityStudents;
    }

    public School getSchool() {
        return school;
    }

    public void setRsegistrationCode(Integer registrationCode) {
        this.registrationCode = registrationCode;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setRegistrationCode(Integer registrationCode) {
        this.registrationCode = registrationCode;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setCapacityStudents(int capacityStudents) {
        this.capacityStudents = capacityStudents;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return getClassroom();
    }
}
