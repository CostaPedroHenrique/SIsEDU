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
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer registrationCode;
    
    @Column(name="name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_school",nullable=false)
    private School school;

    public Integer getRegistrationCode() {
        return registrationCode;
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

    public School getSchool() {
        return school;
    }

    public void setRegistrationCode(Integer registrationCode) {
        this.registrationCode = registrationCode;
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

    public void setSchool(School school) {
        this.school = school;
    }
  
}
