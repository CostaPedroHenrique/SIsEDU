/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name="result")
public class Result {
    public Result(){
        this.mean = 0;
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
    
    @Column(name="nota1")
    private double nota1;
    
    @Column(name="nota2")
    private double nota2;
    
    @Column(name="nota3")
    private double nota3;
    
    @Column(name="nota4")
    private double nota4;
    
    @Column(name="mean")
    private double mean;
    
    @Column(name="final")
    private double finalResult;

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getMean() {
        return mean;
    }

    public Integer getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public double getFinalResult() {
        return finalResult;
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

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public void setFinalResult(double finalResult) {
        this.finalResult = finalResult;
    }
}

