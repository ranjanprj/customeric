/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customeric;

/**
 *
 * @author ranjan
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;
import java.util.logging.Level;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.JdbcUtils;
import org.apache.shiro.util.SimpleByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This realm has all {@link JdbcRealm} capabilities. It also supports JNDI as
 * datasource source and can add salt to passwords.
 */
public class JNDIAndSaltAwareJdbcRealm extends JdbcRealm {

    private static final Logger log = LoggerFactory.getLogger(JNDIAndSaltAwareJdbcRealm.class);
    protected String jndiDataSourceName;

    public JNDIAndSaltAwareJdbcRealm() {
    }

    public String getJndiDataSourceName() {
        
        return jndiDataSourceName;
    }

    public void setJndiDataSourceName(String jndiDataSourceName) {
        this.jndiDataSourceName = jndiDataSourceName;
        this.dataSource = getDataSourceFromJNDI(jndiDataSourceName);
    }

    private DataSource getDataSourceFromJNDI(String jndiDataSourceName) {
        try {
            InitialContext ic = new InitialContext();
            return (DataSource) ic.lookup(jndiDataSourceName);
        } catch (NamingException e) {
            log.error("JNDI error while retrieving " + jndiDataSourceName, e);
            throw new AuthorizationException(e);
        }
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
        String username = userPassToken.getUsername();
        if (username == null) {
            log.info("Username is null.");
            return null;
        }

        // read password hash and salt from db 
        PasswdSalt passwdSalt = getPasswordForUser(username);

        if (passwdSalt == null) {
            log.info("No account found for user [" + username + "]");
            return null;
        }


        log.info("return salted credentials");
        log.info(username + " " + passwdSalt.password + " " + passwdSalt.salt);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, passwdSalt.password, getName());
        info.setCredentialsSalt(new SimpleByteSource(passwdSalt.salt));

        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String memberId = principals.fromRealm(getName()).iterator().next().toString();
        log.info("Member ID : " + memberId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        try {
            Connection conn = dataSource.getConnection();
            Set<String> roleNames = getRoleNamesForUser(conn, memberId);
            info.addRoles(roleNames);
            Set<String> permissions = getPermissions(conn, memberId, roleNames);
            info.addStringPermissions(permissions);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(JNDIAndSaltAwareJdbcRealm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
    }

    private PasswdSalt getPasswordForUser(String username) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            statement = conn.prepareStatement(authenticationQuery);
            statement.setString(1, username);

            resultSet = statement.executeQuery();

            boolean hasAccount = resultSet.next();
            if (!hasAccount) {
                return null;
            }

            String salt = null;
            String password = resultSet.getString(1);
            if (resultSet.getMetaData().getColumnCount() > 1) {
                salt = resultSet.getString(2);
            }

            log.info("Salt value from DB " + salt);

            if (resultSet.next()) {
                throw new AuthenticationException("More than one user row found for user [" + username + "]. Usernames must be unique.");
            }

            return new PasswdSalt(password, salt);
        } catch (SQLException e) {
            final String message = "There was a SQL error while authenticating user [" + username + "]";
            if (log.isErrorEnabled()) {
                log.error(message, e);
            }
            throw new AuthenticationException(message, e);

        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(conn);
        }
    }

    @Override
    protected Set<String> getRoleNamesForUser(Connection conn, String username) throws SQLException {
        return super.getRoleNamesForUser(conn, username);
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Set<String> roleNames = new LinkedHashSet<String>();
//        try {
//            ps = conn.prepareStatement(userRolesQuery);
//            ps.setString(1, username);
//            rs = ps.executeQuery();
//            // Loop over results and add each returned role to a set
//            while (rs.next()) {
//                String roleName = rs.getString(1);
//                
//                System.out.println("ROLE NAMES ====");
//                System.out.println("realm"+roleName);
//                System.out.println("query"+userRolesQuery);
//                if (roleName != null) {
//                    roleNames.add(roleName);
//                } else {
//                    if (log.isWarnEnabled()) {
//                        log.warn("Null role name found while retrieving role names for user [" + username + "]");
//                    }
//
//                }
//
//            }
//            
//        } finally {
//            JdbcUtils.closeResultSet(rs);
//            JdbcUtils.closeStatement(ps);
//        }
//        return roleNames;
    }

    @Override
    protected Set<String> getPermissions(Connection conn, String username, Collection<String> roleNames) throws SQLException {
        return super.getPermissions(conn, username, roleNames);
    }
    
    
}
class PasswdSalt {

    public String password;
    public String salt;

    public PasswdSalt(String password, String salt) {
        super();
        this.password = password;
        this.salt = salt;
    }
}