package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.Admin;
import com.mycompany.sisedu.model.Teacher;
import com.mycompany.sisedu.services.Manager;
import java.io.UnsupportedEncodingException;
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
public class AdminController {   

    private EntityManager em;
    
    public AdminController(){
        em = Manager.getInstance().getEm();
    }
    
    public void save(Admin _admin){
        em.getTransaction().begin();
        if(_admin.getId()>0){
            _admin = em.merge(_admin);
        }
        em.persist(_admin);
        em.getTransaction().commit();

    }
    
    public void delete(Admin _admin){
        em.getTransaction().begin();
        em.remove(_admin);
        em.getTransaction().commit();

    }
    
    
    public List<Admin> list(){
        em.getTransaction().begin();
        Query search = em.createQuery("SELECT admin FROM Admin admin");
        List<Admin> admins = search.getResultList();

        return admins; 
    }
    
    public List<Admin> find( String registration, String password) throws UnsupportedEncodingException{
        em.getTransaction().begin();
        String jpql = "SELECT admin FROM Admin admin where email= '".concat(registration).concat("' and password= '").concat(password).concat("'");
        System.out.println(jpql);
        TypedQuery<Admin> typedQuery =  em.createQuery(jpql, Admin.class);
        List<Admin> admins = typedQuery.getResultList();

        return admins;
    }
    
    public Admin find( int id){
        Admin admin = em.find(Admin.class, id);
 
        return admin;
    }
}
