/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customeric.pages;

import org.apache.shiro.SecurityUtils;
import org.apache.wicket.markup.html.WebPage;

/**
 *
 * @author RanjanPr
 */
public class LogoffPage extends WebPage{
    private static final long serialVersionUID = 1L;

    public LogoffPage()
    {
        try{
            SecurityUtils.getSubject().logout();
            getSession().invalidate();
        }catch(Exception ex){
            
        }finally{
            setResponsePage(HomePage.class);
        }

    }
}
