package com.customeric;

import com.customeric.pages.AccountsPage;
import com.customeric.pages.ChatPage;
import com.customeric.pages.ContactsPage;
import com.customeric.pages.HomePage;
import com.customeric.pages.LeadsPage;
import com.customeric.pages.LogoffPage;
import com.customeric.pages.UserProfilePage;
import com.customeric.pages.WorkBench;
import com.customeric.service.DocamineService;
import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.atmosphere.EventBus;
import org.apache.wicket.atmosphere.config.AtmosphereTransport;
import org.apache.wicket.protocol.http.WebApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 *
 *
 */
public final class WicketApplication extends WebApplication {

    private static final Logger log = LoggerFactory.getLogger(WicketApplication.class);
    private EventBus eventBus;

    @Override
    public Class<? extends Page> getHomePage() {

        return HomePage.class;
    }

    public EventBus getEventBus() {
        return eventBus;
    }


    public static WicketApplication getApp(){
        return (WicketApplication)WicketApplication.get();
    }
    @Override
    protected final void init() {
        super.init();
        eventBus = new EventBus(this);
        eventBus.getParameters().setTransport(AtmosphereTransport.STREAMING);
        mountPage("/home", HomePage.class);        
        mountPage("/leads", LeadsPage.class);
        mountPage("/accounts", AccountsPage.class);
        mountPage("/contacts", ContactsPage.class);
        mountPage("/chat", ChatPage.class);
        mountPage("/userprofile",UserProfilePage.class);
        mountPage("/workbench",WorkBench.class);
              
        mountPage("/logoff",LogoffPage.class);
//        Application.get().getMarkupSettings().setStripWicketTags(true);
//        eventBus.getParameters().setLogLevel(AtmosphereLogLevel.DEBUG);
/*
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable beeper = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    eventBus.post(new Date());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        scheduler.scheduleWithFixedDelay(beeper, 2, 2, TimeUnit.SECONDS);
  */
        getDebugSettings().setDevelopmentUtilitiesEnabled(true);

    }

    @Override
    public final RuntimeConfigurationType getConfigurationType() {
//        return RuntimeConfigurationType.DEPLOYMENT;
        return RuntimeConfigurationType.DEVELOPMENT;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); //To change body of generated methods, choose Tools | Templates.

    }

    public static DocamineService getDocamineService() {
        return new DocamineService();
    }
}