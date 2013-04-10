package br.com.sca.persistencia;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author Anderson
 */

public class Factory{
     private static EntityManagerFactory entityManagerFactory ;
     public static EntityManager getEntityManager(){
         EntityManager entityManager;
         entityManagerFactory = Persistence.createEntityManagerFactory("scaPU");
         entityManager =  entityManagerFactory.createEntityManager();
         return  entityManager;
    }  
}
