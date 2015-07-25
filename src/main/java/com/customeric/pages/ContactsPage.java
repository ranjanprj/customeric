/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customeric.pages;

import com.customeric.panels.ContactFormPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author RanjanPr
 */
public class ContactsPage extends WebPage{
    private static final long serialVersionUID = 1L;

    private ContactFormPanel contactFormPanel; 
    public ContactsPage(final PageParameters parameters)
    {
        super(parameters);
        contactFormPanel = new ContactFormPanel("contactFormPanel",null);
        add(contactFormPanel);
    }
}
