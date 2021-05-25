package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.Teacher;
import com.mycompany.sisedu.services.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class TeacherController {
    private EntityManager em;
    
    public TeacherController(){
        em = Manager.getInstance().getEm();
    }
    
    public void save(Teacher _teacher){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        if(_teacher.getId() != null){
            _teacher = em.merge(_teacher);
        }
        em.persist(_teacher);
        em.getTransaction().commit();
    }
    
    public void delete(Teacher _teacher){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        em.remove(_teacher);
        em.getTransaction().commit();
    }
    
    public List<Teacher> list(){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Query search = em.createQuery("SELECT teacher FROM Teacher teacher");
        List<Teacher> teachers = search.getResultList();
        
        return teachers; 
    }
    
//    Irei terminar algum dia
    public List<Teacher> find( String registration, String password){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        String query = "SELECT teacher FROM Teacher teacher where  email=".concat(registration).concat("and password=").concat(password);
        Query search = em.createQuery(query);
        List<Teacher> teachers = search.getResultList();
        
        return teachers;
    }
    
    public Teacher find( int id){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Teacher teacher = em.find(Teacher.class, id);
 
        return teacher;
    }
}
