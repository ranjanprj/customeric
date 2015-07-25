/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.customeric.panels;

import com.customeric.entity.Users;
import com.customeric.service.DocamineServiceFactory;
import java.util.Arrays;
import java.util.logging.Level;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ComponentPropertyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author RanjanPr
 */
public class UserProfileFormPanel extends Panel{
    Logger log = LoggerFactory.getLogger(UserProfileFormPanel.class);
    public UserProfileFormPanel(final String id) {
        super(id);
     
        final Users currentUser = DocamineServiceFactory.getDocamineService().getCurrentUser();
        final Form<Users> userProfileForm = new Form<Users>("userProfileForm",new CompoundPropertyModel<Users>(currentUser)){
            @Override
            protected void onSubmit() {
                super.onSubmit(); 
                final Users user = getModelObject();
                try {
                                        if(user.getId() == null ){
                         DocamineServiceFactory.getUsersJpaController().create(user);
                    }else{
                         DocamineServiceFactory.getUsersJpaController().edit(user);
                    }

                } catch (Exception ex) {
                    log.error("Not able to save user in UserProfile Page");
                }
            
            }
            
        };        
        add(userProfileForm);
      
        final DropDownChoice title = new DropDownChoice("title",Arrays.asList("Mr", "Mrs", "Miss", "Dr"));
        final TextField firstName = new TextField("firstName");
        final TextField lastName = new TextField("lastName");
        final EmailTextField  companyEmailAddress = new EmailTextField("companyEmailAddress");
        final EmailTextField personalEmailAddress = new EmailTextField("personalEmailAddress");
        final TextField phoneNumber = new TextField("phoneNumber");
        final TextField street1= new TextField("street1");
        final TextField street2= new TextField("street2");
        final TextField zip= new TextField("zip");
        final TextField city= new TextField("city");
        final TextField state= new TextField("state");
        final TextField country= new TextField("country");
        final TextField twitterHandle= new TextField("twitterHandle");
        final TextField facebookHandle= new TextField("facebookHandle");
        final TextField linkedHandle= new TextField("linkedInHandle");
        final TextField skypeHandle= new TextField("skypeHandle");
        final TextField blogUrl= new TextField("blogUrl");
        final TextArea comments= new TextArea("comments");
        
        userProfileForm.add(title).add(firstName).add(lastName).add(companyEmailAddress).add(personalEmailAddress).add(phoneNumber)
                .add(street1).add(street2).add(zip).add(city).add(state).add(country).add(twitterHandle).add(facebookHandle).add(linkedHandle)
                .add(skypeHandle).add(blogUrl).add(comments);

    }
  
}

