/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customeric.pages;

import com.customeric.panels.UserProfileFormPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author RanjanPr
 */
public class UserProfilePage extends WebPage{
    private static final long serialVersionUID = 1L;

    private UserProfileFormPanel userProfileFormPanel;
    public UserProfilePage(final PageParameters parameters)
    {
       super(parameters);
       userProfileFormPanel = new UserProfileFormPanel("userProfileFormPanel");
       add(userProfileFormPanel);
  
    }
}
