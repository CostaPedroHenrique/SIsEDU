package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.Subject;
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
public class SubjectController {
    private EntityManager em;
    
    public SubjectController(){
        em = Manager.getInstance().getEm();
    }
    
    public void save(Subject _subject){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        if(_subject.getRegistrationCode() != null){
            _subject = em.merge(_subject);
        }
        em.persist(_subject);
        em.getTransaction().commit();
    }
    
    public void delete(Subject _subject){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        em.remove(_subject);
        em.getTransaction().commit();
    }
    
    
    public List<Subject> list(){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Query search = em.createQuery("SELECT student FROM Student student");
        List<Subject> students = search.getResultList();
        
        return students; 
    }
    
    public List<Subject> findByClass(int classId){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Query search = em.createQuery("SELECT subject FROM Subject subject where fk_class = " + classId);
        List<Subject> subjects = search.getResultList();
        
        return subjects;
    }
    
    public Subject find( int id){
        Subject subject = em.find(Subject.class, id);
 
        return subject;
    }
}
