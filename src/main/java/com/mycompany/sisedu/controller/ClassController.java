package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.Class;
import com.mycompany.sisedu.services.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author pedrohenrique
 */
public class ClassController {
    private EntityManager em;
    
    public ClassController(){
        em = Manager.getInstance().getEm();
    }
    
    public void save(Class _class){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        if(_class.getRegistrationCode() != null){
            _class = em.merge(_class);
        }
        em.persist(_class);
        em.getTransaction().commit();
    }
    
    public void delete(Class _class){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        em.remove(_class);
        em.getTransaction().commit();
    }
    
    public List<Class> list(){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Query search = em.createQuery("SELECT turma FROM Class turma");
        List<Class> classes = search.getResultList();
        
        return classes; 
    }
    
    public Class findByTeacher(int idTeacher){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Query search = em.createQuery("SELECT turma FROM Class turma where fk_teacher = "+idTeacher);
        List<Class> classes = search.getResultList();
        
        return classes.get(0); 
    }
    
    public Class find( int id){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Class _class = em.find(Class.class, id);
 
        return _class;
    }
}
