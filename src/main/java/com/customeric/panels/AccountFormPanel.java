/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customeric.panels;

import com.customeric.entity.Accounts;
import com.customeric.service.DocamineServiceFactory;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioChoice;
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
public class AccountFormPanel extends Panel {

    Logger log = LoggerFactory.getLogger(AccountFormPanel.class);

    public AccountFormPanel(String id, IModel<Accounts> model) {
        super(id, model);
        if (model == null) {
            model = new Model<Accounts>(new Accounts());
        }
        final Form<Accounts> accountForm = new Form<Accounts>("accountForm", new CompoundPropertyModel<Accounts>(model)) {
            @Override
            protected void onSubmit() {
                super.onSubmit();
                final Accounts account = getModelObject();
                try {
                    if (account.getId() == null) {
                        DocamineServiceFactory.getAccountsJpaController().create(account);
                    } else {
                        DocamineServiceFactory.getAccountsJpaController().edit(account);
                    }

                } catch (Exception ex) {
                    log.error("Not able to save account in Account Form");
                }

            }

        };
        add(accountForm);
        final TextField companyName = new TextField("companyName");
        final EmailTextField companyEmailAddress = new EmailTextField("companyEmailAddress");
        final TextField phoneNumber = new TextField("phoneNumber");
        final TextField street1 = new TextField("street1");
        final TextField street2 = new TextField("street2");
        final TextField zip = new TextField("zip");
        final TextField city = new TextField("city");
        final TextField state = new TextField("state");
        final TextField country = new TextField("country");
        final TextField twitterHandle = new TextField("twitterHandle");
        final TextField facebookHandle = new TextField("facebookHandle");
        final TextField linkdedInHandle = new TextField("linkdedInHandle");
        final TextField skypeHandle = new TextField("skypeHandle");
        final TextField blogUrl = new TextField("blogUrl");
        final TextArea comments = new TextArea("comments");

        final RadioGroup radioGroup = new RadioGroup("customerTypeChoice");
        radioGroup.add(new Radio("premium", new Model<String>("premium")));
        radioGroup.add(new Radio("valued", new Model<String>("valued")));
        radioGroup.add(new Radio("normal", new Model<String>("normal")));

        accountForm.add(companyName).add(companyEmailAddress).add(phoneNumber)
                .add(street1).add(street2).add(zip).add(city).add(state).add(country).add(twitterHandle).add(facebookHandle).add(linkdedInHandle)
                .add(skypeHandle).add(blogUrl).add(comments).add(radioGroup);
    }

}
