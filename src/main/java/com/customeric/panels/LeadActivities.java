/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.customeric.panels;

import com.customeric.entity.Leads;
import com.customeric.service.DocamineServiceFactory;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author RanjanPr
 */
public class LeadActivities extends Panel{
    private ListView<Leads> leadList;
    public LeadActivities(String id, IModel<List<? extends Leads>> leadLists) {
        super(id, leadLists);
        if(leadLists == null){
            leadLists = Model.ofList(DocamineServiceFactory.getLeadsJpaController().findLeadsEntities());
        }
        leadList = new ListView<Leads>("leadList",leadLists) {
            
            @Override
            protected void populateItem(ListItem<Leads> li) {
                li.add(new Label("leadId",li.getModelObject().getId()+""));
            }
        };
        
        add(leadList);
    }
    
}
