/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customeric.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.apache.shiro.SecurityUtils;


/**
 *
 * @author ranjanp1
 */
@Path("/mobile")
public class HelloWorldResourceMobile {

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        
        StringBuilder sb = new StringBuilder();
        sb.append( SecurityUtils.getSubject().getPrincipal().toString() );
        sb.append(" - has admin role - ");
        sb.append( SecurityUtils.getSubject().hasRole("admin"));
        sb.append("for MOBILE");
        return sb.toString();
    }
    
        
    
}
