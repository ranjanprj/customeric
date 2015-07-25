/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.com.bc.wicket.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.SimpleByteSource;

/**
 *
 * @author ranjanp1
 */
public class SaltPassword {
    public static String[] saltPassword(String password){
        
        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
        String salt = rng.nextBytes().toString();
        Sha256Hash sha256Hash = new Sha256Hash(password, (new SimpleByteSource(salt.toString())).getBytes(), 1);
        String ePwd = sha256Hash.toHex();        
        return new String[]{salt,ePwd};
    }
}
