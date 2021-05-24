package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.Studant;
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
    EntityManagerFactory emf;
    EntityManager em;
    
    public StudantController(){
        emf = Persistence.createEntityManagerFactory("SisEDU");
        em = emf.createEntityManager();
    }
    
    public void save(Studant _studants){
        em.getTransaction().begin();
        em.persist(_studants);
        em.getTransaction().commit();
    }
    
    public void delete(Studant _students){
        em.getTransaction().begin();
        em.remove(_students);
        em.getTransaction().commit();
    }
    
    public void update(Studant _students){
        em.getTransaction().begin();
        em.persist(_students);
        em.getTransaction().commit();
    }
    
    public List<Studant> list(){
        em.getTransaction().begin();
        Query search = em.createQuery("SELECT studant FROM Studant studant");
        List<Studant> students = search.getResultList();
        
        return students; 
    }
    
    public Studant find( int id){
        Studant student = em.find(Studant.class, id);
 
        return student;
    }
}
