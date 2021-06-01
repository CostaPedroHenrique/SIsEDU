package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.Frequency;
import com.mycompany.sisedu.model.Student;
import com.mycompany.sisedu.services.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author pedrohenrique
 */
public class FrequencyController {
    private EntityManager em;
    
    public FrequencyController(){
        em = Manager.getInstance().getEm();
    }
    
    public void save(Frequency frequency){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        if(frequency.getId() != null){
            frequency = em.merge(frequency);
        }
        em.persist(frequency);
        em.getTransaction().commit();
    }
    
    public void delete(Frequency frequency){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        em.remove(frequency);
        em.getTransaction().commit();
    }
    
    public List<Frequency> list(){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Query search = em.createQuery("SELECT studant FROM Student studant");
        List<Frequency> frequencys = search.getResultList();
        
        return frequencys; 
    }
    
    
    public Frequency find( int id){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Frequency frequency = em.find(Frequency.class, id);
 
        return frequency;
    }
}
