package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.Class;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author pedrohenrique
 */
public class ClassController {
    EntityManagerFactory emf;
    EntityManager em;
    
    public ClassController(){
        emf = Persistence.createEntityManagerFactory("SisEDU");
        em = emf.createEntityManager();
    }
    
    public void save(Class _class){
        em.getTransaction().begin();
        em.persist(_class);
        em.getTransaction().commit();
    }
    
    public void delete(Class _class){
        em.getTransaction().begin();
        em.remove(_class);
        em.getTransaction().commit();
    }
    
    public void update(Class _class){
        em.getTransaction().begin();
        em.persist(_class);
        em.getTransaction().commit();
    }
    
    public List<Class> list(){
        em.getTransaction().begin();
        Query search = em.createQuery("SELECT turma FROM Class turma");
        List<Class> classes = search.getResultList();
        
        return classes; 
    }
    
    public Class find( int id){
        Class _class = em.find(Class.class, id);
 
        return _class;
    }
}
