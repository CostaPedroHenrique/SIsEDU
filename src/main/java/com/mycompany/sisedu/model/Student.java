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
@Table(name="studant")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer registrationcode;
    
    @Column(name="name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name="active")
    private boolean active;

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public Integer getRegistrationcode() {
        return registrationcode;
    }

    public void setRegistrationcode(Integer registrationcode) {
        this.registrationcode = registrationcode;
    }
    
    @Column(name = "password")
    private String password;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_class", nullable=false)
    private Class classId;

    public void setClassId(Class classId) {
        this.classId = classId;
    }

    public Integer getRegistrationCode() {
        return registrationcode;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Class getClassId() {
        return classId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return getName();
    }
  
}
