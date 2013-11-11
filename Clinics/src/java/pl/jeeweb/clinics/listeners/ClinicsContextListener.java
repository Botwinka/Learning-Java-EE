/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jeeweb.clinics.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import pl.jeeweb.clinics.config.DBManager;

/**
 *
 * @author R950
 */
public class ClinicsContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DBManager.getDbManager().createEntityManagerFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBManager.getDbManager().closeEntityManagerFactory();
    }
    
}
