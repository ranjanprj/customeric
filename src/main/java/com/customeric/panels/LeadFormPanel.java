/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.customeric.panels;

import com.customeric.entity.Accounts;
import com.customeric.entity.Leads;
import com.customeric.service.DocamineServiceFactory;
import java.util.Arrays;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author RanjanPr
 */
public class LeadFormPanel extends Panel{
    Logger log = LoggerFactory.getLogger(LeadFormPanel.class);
    public LeadFormPanel(String id, IModel<Leads> model) {
        super(id, model);
        if(model == null){
            model = new Model<Leads>(new Leads());
        }
        final Form<Leads> leadForm = new Form<Leads>("leadForm",new CompoundPropertyModel<Leads>(model)){
            @Override
            protected void onSubmit() {
                super.onSubmit(); 
                final Leads lead = getModelObject();
                try {
                    DocamineServiceFactory.getLeadsJpaController().edit(lead);
                } catch (Exception ex) {
                    log.error("Not able to save lead in lead Form");
                }
            
            }
            
        };        
        add(leadForm);
        final DropDownChoice title = new DropDownChoice("title",Arrays.asList("Mr", "Mrs", "Miss", "Dr"));
        final TextField firstName = new TextField("firstName");
        final TextField lastName = new TextField("lastName");
        final TextField companyName = new TextField("companyName");
        final EmailTextField  companyEmailAddress = new EmailTextField("companyEmailAddress");
        final TextField phoneNumber = new TextField("phoneNumber");
        final TextField street1= new TextField("street1");
        final TextField street2= new TextField("street2");
        final TextField zip= new TextField("zip");
        final TextField city= new TextField("city");
        final TextField stateName= new TextField("stateName");
        final TextField country= new TextField("country");
        final TextField twitterHandle= new TextField("twitterHandle");
        final TextField facebookHandle= new TextField("facebookHandle");
        final TextField linkdedInHandle= new TextField("linkdedInHandle");
        final TextField skypeHandle= new TextField("skypeHandle");
        final TextField blogUrl= new TextField("blogUrl");
        final TextArea comments= new TextArea("comments");
        
        final RadioGroup radioGroup = new RadioGroup("leadTypeChoice");
        radioGroup.add(new Radio("hot",new Model<String>("hot")));
        radioGroup.add(new Radio("cold",new Model<String>("cold")));
        radioGroup.add(new Radio("warm",new Model<String>("warm")));
        
        leadForm.add(title).add(firstName).add(lastName).add(companyName).add(companyEmailAddress).add(phoneNumber)
                .add(street1).add(street2).add(zip).add(city).add(stateName).add(country).add(twitterHandle).add(facebookHandle).add(linkdedInHandle)
                .add(skypeHandle).add(blogUrl).add(comments).add(radioGroup);
    }
    
}
