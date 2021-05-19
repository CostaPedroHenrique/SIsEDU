/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sisedu.model;

import javax.persistence.Column;

/**
 *
 * @author pedrohenrique
 */
abstract class User {
    
    
    @Column(name="name")
    private String name;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
}
