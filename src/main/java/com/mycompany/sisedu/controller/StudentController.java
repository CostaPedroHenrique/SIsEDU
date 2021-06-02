package com.mycompany.sisedu.controller;

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
public class StudentController {
    private EntityManager em;
    
    public StudentController(){
        em = Manager.getInstance().getEm();
    }
    
    public void save(Student _studant){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        if(_studant.getRegistrationCode() != null){
            _studant = em.merge(_studant);
        }
        em.persist(_studant);
        em.getTransaction().commit();
    }
    
    public void delete(Student _students){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        em.remove(_students);
        em.getTransaction().commit();
    }
    
    public List<Student> list(){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Query search = em.createQuery("SELECT studant FROM Student studant");
        List<Student> students = search.getResultList();
        
        return students; 
    }
    
    public List<Student> list(int classId){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Query search = em.createQuery("SELECT studant FROM Student studant where fk_class = 1");
        List<Student> students = search.getResultList();
        
        return students; 
    }
    
    public List<Student> find( String registration, String password) {
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        String jpql = "SELECT student FROM Student student where email= '".concat(registration).concat("' and password= '").concat(password).concat("'");
        System.out.println(jpql);
        TypedQuery<Student> typedQuery =  em.createQuery(jpql, Student.class);
        List<Student> students = typedQuery.getResultList();

        return students;
    }
    
    public List<Student> findByClass(int classId){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Query search = em.createQuery("SELECT studant FROM Student studant where fk_class = "+classId);
        List<Student> students = search.getResultList();
        
        return students; 
    }
    
    public Student find( int id){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Student student = em.find(Student.class, id);
 
        return student;
    }
}
