/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customeric.pages;

import com.customeric.panels.LeadActivities;
import com.customeric.panels.LeadFormPanel;
import ui.com.bc.wicket.utils.ReceiverFilter;
import ui.com.bc.wicket.utils.ChatMessage;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.atmosphere.EventBus;
import org.apache.wicket.atmosphere.Subscribe;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author RanjanPr
 */
public class LeadsPage extends WebPage{
    private static final long serialVersionUID = 1L;
 private LeadFormPanel leadFormPanel;
 private LeadActivities leadActivities;
    public LeadsPage(final PageParameters parameters)
    {
        super(parameters);
         leadFormPanel = new LeadFormPanel("leadContentPanel", null);
         leadActivities = new LeadActivities("leadContentPanel", null);
//        add(leadFormPanel);
        add(leadActivities);

    }
}
