package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.Teacher;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class TeacherController {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TeacherController(){
        emf = Persistence.createEntityManagerFactory("SisEDU");
        em = emf.createEntityManager();
    }
    
    public void save(Teacher _teacher){
        em.getTransaction().begin();
        em.persist(_teacher);
        em.getTransaction().commit();
    }
    
    public void delete(Teacher _teacher){
        em.getTransaction().begin();
        em.remove(_teacher);
        em.getTransaction().commit();
    }
    
    public void update(Teacher _teacher){
        em.getTransaction().begin();
        em.persist(_teacher);
        em.getTransaction().commit();
    }
    
    public List<Teacher> list(){
        em.getTransaction().begin();
        Query search = em.createQuery("SELECT teacher FROM Teacher teacher");
        List<Teacher> teachers = search.getResultList();
        
        return teachers; 
    }
    
//    Irei terminar algum dia
    public List<Teacher> find( String registration, String password){
        em.getTransaction().begin();
        String query = "SELECT teacher FROM Teacher teacher where  email=".concat(registration).concat("and password=").concat(password);
        Query search = em.createQuery(query);
        List<Teacher> teachers = search.getResultList();
        
        return teachers;
    }
    
    public Teacher find( int id){
        Teacher teacher = em.find(Teacher.class, id);
 
        return teacher;
    }
}
