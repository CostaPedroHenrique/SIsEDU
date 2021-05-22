package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author pedrohenrique
 */
public class StudentController {
    EntityManagerFactory emf;
    EntityManager em;
    
    public StudentController(){
        emf = Persistence.createEntityManagerFactory("SisEDU");
        em = emf.createEntityManager();
    }
    
    public void save(Student _students){
        em.getTransaction().begin();
        em.persist(_students);
        em.getTransaction().commit();
    }
    
    public void delete(Student _students){
        em.getTransaction().begin();
        em.remove(_students);
        em.getTransaction().commit();
    }
    
    public void update(Student _students){
        em.getTransaction().begin();
        em.persist(_students);
        em.getTransaction().commit();
    }
    
    public List<Student> list(){
        em.getTransaction().begin();
        Query search = em.createQuery("SELECT student FROM Student student");
        List<Student> students = search.getResultList();
        
        return students; 
    }
    
    public Student find( int id){
        Student student = em.find(Student.class, id);
 
        return student;
    }
}
