package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.School;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author pedrohenrique
 */
public class SchoolController {
    EntityManagerFactory emf;
    EntityManager em;
    
    public SchoolController(){
        emf = Persistence.createEntityManagerFactory("SisEDU");
        em = emf.createEntityManager();
    }
    
    public void save(School _school){
        em.getTransaction().begin();
        em.persist(_school);
        em.getTransaction().commit();
    }
    
    public void delete(School _school){
        em.getTransaction().begin();
        em.remove(_school);
        em.getTransaction().commit();
    }
    
    public void update(School _school){
        em.getTransaction().begin();
        em.persist(_school);
        em.getTransaction().commit();
    }
    
    public List<School> list(){
        em.getTransaction().begin();
        Query search = em.createQuery("SELECT school FROM School school");
        List<School> schools = search.getResultList();
        
        return schools; 
    }
    
    public School find( int id){
        School school = em.find(School.class, id);
        return school;
    }
}
