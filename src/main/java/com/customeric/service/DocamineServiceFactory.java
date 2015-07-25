/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customeric.service;

import com.customeric.WicketApplication;
import com.customeric.entity.AccountsJpaController;
import com.customeric.entity.ContactsJpaController;
import com.customeric.entity.LeadsJpaController;

import com.customeric.entity.UsersJpaController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.shiro.SecurityUtils;
import org.apache.wicket.protocol.http.WebApplication;
import ui.com.bc.wicket.utils.Constants;

/**
 *
 * @author ranjanp
 */
public final class DocamineServiceFactory {
    
    private DocamineServiceFactory() {
    }
    
    public  final static DocamineServiceFactory getInstance() {
        return DocamineServiceFactoryHolder.INSTANCE;
    }    
    private  final static class DocamineServiceFactoryHolder {
        private static final DocamineServiceFactory INSTANCE = new DocamineServiceFactory();
    }
    
    public final  static EntityManager getEntityManager(){        
        return getEntityManagerFactory().createEntityManager();               
    }
    public final  static EntityManagerFactory getEntityManagerFactory(){
        return Persistence.createEntityManagerFactory(Constants.PU);        
    }
    public final  static UsersJpaController getUsersJpaController(){
        return new UsersJpaController(getEntityManagerFactory());
    }
    public final static LeadsJpaController getLeadsJpaController(){
        return new LeadsJpaController((getEntityManagerFactory()));
    }
  
    public final  static ContactsJpaController getContactsJpaController(){
        return new ContactsJpaController(getEntityManagerFactory());
    }
    public final  static AccountsJpaController getAccountsJpaController(){
        return new AccountsJpaController(getEntityManagerFactory());
    }
   public final  static DocamineService getDocamineService(){
         
        return WicketApplication.getDocamineService();    
   } 
  
   
}
