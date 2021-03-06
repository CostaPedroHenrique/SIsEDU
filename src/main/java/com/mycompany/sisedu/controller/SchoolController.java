package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.School;
import com.mycompany.sisedu.services.Manager;
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
    private EntityManager em;
    
    public SchoolController(){
        em = Manager.getInstance().getEm();
    }
    
    public void save(School _school){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        if(_school.getId() != null){
            _school = em.merge(_school);
        }
        em.persist(_school);
        em.getTransaction().commit();
    }
    
    public void delete(School _school){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        em.remove(_school);
        em.getTransaction().commit();
    }
    
    public List<School> list(){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Query search = em.createQuery("SELECT school FROM School school");
        List<School> schools = search.getResultList();
        
        return schools; 
    }
    
    public School find( int id){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        School school = em.find(School.class, id);
        return school;
    }
}
