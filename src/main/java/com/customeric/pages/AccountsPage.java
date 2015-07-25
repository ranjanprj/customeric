/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customeric.pages;

import com.customeric.panels.AccountFormPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author RanjanPr
 */
public class AccountsPage extends WebPage{
    private static final long serialVersionUID = 1L;

    private AccountFormPanel accountFormPanel;
    public AccountsPage(final PageParameters parameters)
    {
        super(parameters);
        accountFormPanel = new AccountFormPanel("accountFormPanel", null);
        add(accountFormPanel);
    }
}
