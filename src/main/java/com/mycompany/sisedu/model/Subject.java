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
@Table(name="subject")
public class Subject {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer registrationCode;
    
    @Column(name="workload")
    private int workload;
    
    @Column(name="name")
    private String name;
    
    @Column(name="menu")
    private String menu;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_class",nullable=false)
    private Class classId;

    public Integer getRegistrationCode() {
        return registrationCode;
    }

    public int getWorkload() {
        return workload;
    }

    public String getName() {
        return name;
    }

    public String getMenu() {
        return menu;
    }

    public Class getClassId() {
        return classId;
    }


    public void setRegistrationCode(Integer registrationCode) {
        this.registrationCode = registrationCode;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void setClassId(Class classId) {
        this.classId = classId;
    }

    
    
    @Override
    public String toString() {
        return getName();
    }

}
