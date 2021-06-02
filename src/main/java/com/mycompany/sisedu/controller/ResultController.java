/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sisedu.controller;

import com.mycompany.sisedu.model.Result;
import com.mycompany.sisedu.services.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author pedrohenrique
 */
public class ResultController {
    private EntityManager em;
    
    public ResultController(){
        em = Manager.getInstance().getEm();
    }
    
    public void save(Result result){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        if(result.getId() != null){
            result = em.merge(result);
        }
        em.persist(result);
        em.getTransaction().commit();
    }
    
    public void delete(Result result){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        em.remove(result);
        em.getTransaction().commit();
    }
    
    public List<Result> list(){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Query search = em.createQuery("SELECT result FROM Result result");
        List<Result> results = search.getResultList();
        
        return results; 
    }
    
    
    public Result find( int id){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
        Result result = em.find(Result.class, id);
 
        return result;
    }
}
