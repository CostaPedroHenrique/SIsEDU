package com.mycompany.sisedu.model;

import java.util.Date;
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
@Table(name="frequency")
public class Frequency {
    public Frequency() {
        this.present = false;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_student",nullable=false)
    private Student student;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_subject",nullable=false)
    private Subject subject;
    
    @Column(name="present")
    private boolean present;
    
    @Column(name="date")
    private Date date;

    public Integer getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public boolean isPresent() {
        return present;
    }
    
    public boolean presentProperty(){
        return present;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
