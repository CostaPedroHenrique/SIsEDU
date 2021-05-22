package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.Subject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author pedrohenrique
 */
public class SubjectController {
    EntityManagerFactory emf;
    EntityManager em;
    
    public SubjectController(){
        emf = Persistence.createEntityManagerFactory("SisEDU");
        em = emf.createEntityManager();
    }
    
    public void save(Subject _subject){
        em.getTransaction().begin();
        em.persist(_subject);
        em.getTransaction().commit();
    }
    
    public void delete(Subject _subject){
        em.getTransaction().begin();
        em.remove(_subject);
        em.getTransaction().commit();
    }
    
    public void update(Subject _subject){
        em.getTransaction().begin();
        em.persist(_subject);
        em.getTransaction().commit();
    }
    
    public List<Subject> list(){
        em.getTransaction().begin();
        Query search = em.createQuery("SELECT student FROM Student student");
        List<Subject> students = search.getResultList();
        
        return students; 
    }
    
    public Subject find( int id){
        Subject subject = em.find(Subject.class, id);
 
        return subject;
    }
}
