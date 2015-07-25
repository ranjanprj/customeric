/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.com.bc.wicket.utils;


import com.customeric.entity.Users;
import com.customeric.entity.UsersJpaController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 *
 * @author ranjanp
 */
public class DataCreationUtility {

    public static List<String> specialityList = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
       loadTestUsers();

    }

    public static EntityManager getEntityManager() {
        
        EntityManager em = getEntityManagerFactory().createEntityManager();
        return em;
        
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CUSTOMERIC_PU_TEST");        
        return emf;
        
    }
    
    public static void loadTestUsers() {
        UsersJpaController ujc = new UsersJpaController(getEntityManagerFactory());
        
        Users u = new Users();
        u.setUserName("admin");
        u.setFirstName("admin");
        String[] saltedPwd = SaltPassword.saltPassword("admin");
        u.setPassword(saltedPwd[1]);
        u.setSalt(saltedPwd[0]);
        // create one admin account
        ujc.create(u);

        
        // create other accounts using datafactory
        DataFactory df = new DataFactory();
        
        for (int i = 0; i < 10; i++) {
            Users user = new Users();
            String firstName = df.getFirstName();
            user.setFirstName(firstName);            
            user.setLastName(df.getLastName());
            user.setUserName(firstName.toLowerCase());
            user.setDob(df.getBirthDate());
            
//            user.setSpeciality(df.getItem(specialityList));
            
            String[] spwd = SaltPassword.saltPassword(firstName.toLowerCase());
            user.setSalt(spwd[0]);
            user.setPassword(spwd[1]);
            Calendar c = Calendar.getInstance();
            c.set(1990, 1, 1);
            Date startDate = c.getTime();
            c.add(Calendar.YEAR, 13);
            Date endDate = c.getTime();
            ujc.create(user);
        }
        System.out.println("DONE");
    }
    
}
