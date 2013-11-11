/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jeeweb.clinics.controllers;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import pl.jeeweb.clinics.config.DBManager;
import pl.jeeweb.clinics.entity.Clinic;

/**
 *
 * @author R950
 */
public class ClinicBean {
    private Clinic clinic = new Clinic();
    
    public ClinicBean(){}

    /**
     * @return the clinic
     */
    public Clinic getClinic() {
        return clinic;
    }

    /**
     * @param clinic the clinic to set
     */
    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }
    
    public String add()
    {
        EntityManager entityManager = DBManager.getDbManager().createEntityManager();
        entityManager.getTransaction().begin();
        clinic.setClinicId(null);
        entityManager.persist(clinic);
        entityManager.getTransaction().commit();
        this.addInformation("Dodano przychodnie!");
        entityManager.close();
        this.clinic = new Clinic();
        return null;
    }
    
    public String edit()
    {
        EntityManager entityManager = DBManager.getDbManager().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(clinic);
        entityManager.getTransaction().commit();
        entityManager.close();
        this.addInformation("Zmieniono dane przychodni");
        this.clinic = new Clinic();
        return "/showClinics.xhtml";
    }
    
    public List<Clinic> getClinicList()
    {
        EntityManager entityManager = DBManager.getDbManager().createEntityManager();
        List clinicList = entityManager.createNamedQuery("Clinic.findAll").getResultList();
        entityManager.close();
        return clinicList;
    }
    
    public void clinicListener(ActionEvent event)
    {
        String clinicIds = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("clinicId").toString();
        int id = Integer.parseInt(clinicIds);
        this.clinic.setClinicId(id);
    }
    
    public String loadToEdit()
    {
        EntityManager entityManager = DBManager.getDbManager().createEntityManager();
        this.clinic = entityManager.find(Clinic.class, clinic.getClinicId());
        entityManager.close();
        return "/editClinic.xhtml";
    }
    
    public String delete()
    {
        EntityManager entityManager = DBManager.getDbManager().createEntityManager();
        entityManager.getTransaction().begin();
        this.clinic = entityManager.find(Clinic.class, clinic.getClinicId());
        entityManager.remove(this.clinic);
        this.clinic = new Clinic();
        entityManager.getTransaction().commit();
        entityManager.close();
        this.addInformation("Usunięto przychodnie");
        return null;
    }
    
    public void addInformation(String message)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
    }
}
