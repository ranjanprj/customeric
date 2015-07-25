/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.customeric.panels;

import com.customeric.entity.Contacts;
import com.customeric.service.DocamineServiceFactory;
import java.util.Arrays;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
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
public class ContactFormPanel extends Panel{

    Logger log = LoggerFactory.getLogger(ContactFormPanel.class);
    public ContactFormPanel(String id, IModel<Contacts> model) {
        super(id, model);
        if(model == null){
            model = new Model<Contacts>(new Contacts());
        }
        final Form<Contacts> contactForm = new Form<Contacts>("contactForm",new CompoundPropertyModel<Contacts>(model)){
            @Override
            protected void onSubmit() {
                super.onSubmit(); 
                final Contacts contact = getModelObject();
                System.out.println(contact);
                try {
                    if(contact.getId() == null ){
                         DocamineServiceFactory.getContactsJpaController().create(contact);
                    }else{
                         DocamineServiceFactory.getContactsJpaController().edit(contact);
                    }
                   
                } catch (Exception ex) {
                    log.error("Not able to save contact in Contact Form");
                }
            
            }
            
        };        
        add(contactForm);
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
        final TextField state= new TextField("stateName");
        final TextField country= new TextField("country");
        final TextField twitterHandle= new TextField("twitterHandle");
        final TextField facebookHandle= new TextField("facebookHandle");
        final TextField linkedInHandle= new TextField("linkedInHandle");
        final TextField skypeHandle= new TextField("skypeHandle");
        final TextField blogUrl= new TextField("blogUrl");
        final TextArea comments= new TextArea("comments");
     
        contactForm.add(title).add(firstName).add(lastName).add(companyName).add(companyEmailAddress).add(phoneNumber)
                .add(street1).add(street2).add(zip).add(city).add(state).add(country).add(twitterHandle).add(facebookHandle).add(linkedInHandle)
                .add(skypeHandle).add(blogUrl).add(comments);
    }
    
    
}
