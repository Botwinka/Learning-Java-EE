/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jeeweb.clinics.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author R950
 */
public class DBManager {
    private static DBManager dbManagerInstance;
    private EntityManagerFactory entityManagerFactory;
    
    private DBManager(){};
    
    public synchronized static DBManager getDbManager()
    {
        if(dbManagerInstance == null)
        {
            dbManagerInstance = new DBManager();
        }
        return dbManagerInstance;
    }
    
    public EntityManagerFactory  createEntityManagerFactory()
    {
        if(entityManagerFactory == null)
        {
            entityManagerFactory = Persistence.createEntityManagerFactory("ClinicsPU");
        }
        return entityManagerFactory;
    }
    
    public EntityManager createEntityManager()
    {
        return this.createEntityManagerFactory().createEntityManager();
    }
    
    public void closeEntityManagerFactory()
    {
        if(entityManagerFactory != null)
        {
            entityManagerFactory.close();
        }
    }
}
