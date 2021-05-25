package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.Studant;
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
public class StudantController {
    private EntityManager em;
    
    public StudantController(){
        em = Manager.getInstance().getEm();
    }
    
    public void save(Studant _studant){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        if(_studant.getRegistrationCode() != null){
            _studant = em.merge(_studant);
        }
        em.persist(_studant);
        em.getTransaction().commit();
    }
    
    public void delete(Studant _students){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        em.remove(_students);
        em.getTransaction().commit();
    }
    
    public List<Studant> list(){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Query search = em.createQuery("SELECT studant FROM Studant studant");
        List<Studant> students = search.getResultList();
        
        return students; 
    }
    
    public Studant find( int id){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Studant student = em.find(Studant.class, id);
 
        return student;
    }
}
