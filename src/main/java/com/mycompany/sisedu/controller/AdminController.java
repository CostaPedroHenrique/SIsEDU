package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.Admin;
import com.mycompany.sisedu.model.Teacher;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author pedrohenrique
 */
public class AdminController {
    EntityManagerFactory emf;
    EntityManager em;
    
    public AdminController(){
        emf = Persistence.createEntityManagerFactory("SisEDU");
        em = emf.createEntityManager();
    }
    
    public void save(Admin _admin){
        em.getTransaction().begin();
        em.persist(_admin);
        em.getTransaction().commit();
        emf.close();
    }
    
    public void delete(Admin _admin){
        em.getTransaction().begin();
        em.remove(_admin);
        em.getTransaction().commit();
        emf.close();
    }
    
    public void update(Admin _admin){
        em.getTransaction().begin();
        em.persist(_admin);
        em.getTransaction().commit();
        emf.close();
    }
    
    public List<Admin> list(){
        em.getTransaction().begin();
        Query search = em.createQuery("SELECT admin FROM Admin admin");
        List<Admin> admins = search.getResultList();
        emf.close();
        
        return admins; 
    }
    
    public List<Admin> find( String registration, String password){
        em.getTransaction().begin();
        String query = "SELECT admin FROM Admin admin where  email=".concat(registration).concat("and password=").concat(password);
        Query search = em.createQuery(query);
        List<Admin> admins = search.getResultList();
        
        return admins;
    }
    
    public Admin find( int id){
        Admin admin = em.find(Admin.class, id);
 
        return admin;
    }
}
