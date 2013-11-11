/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jeeweb.clinics.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author R950
 */
@Entity
@Table(name = "clinic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clinic.findAll", query = "SELECT c FROM Clinic c"),
    @NamedQuery(name = "Clinic.findByClinicId", query = "SELECT c FROM Clinic c WHERE c.clinicId = :clinicId"),
    @NamedQuery(name = "Clinic.findByName", query = "SELECT c FROM Clinic c WHERE c.name = :name"),
    @NamedQuery(name = "Clinic.findByAdress", query = "SELECT c FROM Clinic c WHERE c.adress = :adress"),
    @NamedQuery(name = "Clinic.findByContact", query = "SELECT c FROM Clinic c WHERE c.contact = :contact")})
public class Clinic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clinic_id", nullable = false)
    private Integer clinicId;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "description", nullable = false, length = 65535)
    private String description;
    @Column(name = "adress", length = 150)
    private String adress;
    @Column(name = "contact", length = 30)
    private String contact;

    public Clinic() {
    }

    public Clinic(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public Clinic(Integer clinicId, String name, String description) {
        this.clinicId = clinicId;
        this.name = name;
        this.description = description;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clinicId != null ? clinicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clinic)) {
            return false;
        }
        Clinic other = (Clinic) object;
        if ((this.clinicId == null && other.clinicId != null) || (this.clinicId != null && !this.clinicId.equals(other.clinicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.jeeweb.clinics.entity.Clinic[ clinicId=" + clinicId + " ]";
    }
    
}
