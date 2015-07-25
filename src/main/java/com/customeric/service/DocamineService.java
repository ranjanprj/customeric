/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customeric.service;

import com.customeric.entity.Users;
import java.util.List;
import javax.persistence.EntityManager;
import org.apache.shiro.SecurityUtils;

/**
 *
 * @author ranjanp
 */
public final class DocamineService {


    public DocamineService() {

    }

    public final  Users getCurrentUser() {
        String userName = getCurrentUserName();
        EntityManager em = DocamineServiceFactory.getEntityManager();
        return em.createNamedQuery("findUserFromUserName", Users.class).setParameter("userName", userName).getSingleResult();

    }

    public final  String getCurrentUserSessionId(String userName) {

        EntityManager em = DocamineServiceFactory.getEntityManager();
        return em.createNamedQuery("findUserFromUserName", Users.class).setParameter("userName", userName).getSingleResult().getSessionId();

    }

    public final  List<Users> getUserSearchResults(String userName) {
        EntityManager em = DocamineServiceFactory.getEntityManager();
        return em.createNamedQuery("searchUserFromUserName", Users.class).setParameter("userName", "%" + userName + "%").getResultList();

    }
     public final  static String getCurrentUserName(){
       return SecurityUtils.getSubject().getPrincipal().toString();
   }   
}
