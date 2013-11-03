/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.helion.jeeweb.hellojsf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class ManagerBean {
   private List<Spolka> spolki;
   private String activeCompanySymbol;
   
   public ManagerBean()
   {
       spolki = new ArrayList<Spolka>(3);
       Date date = new Date();
       spolki.add(new Spolka("Kocia spolka weglowa", "energetyczny", "KSW", 20.0, 11.1, date));
       spolki.add(new Spolka("KitKompDotCom", "informatyczny", "KKDC", 90.0, 3.4, date));
       spolki.add(new Spolka("Kocie Dance Studio", "rozrywkowy", "KDS", 15.0, -11.7, date));
       
       Date yesterday = new Date(date.getTime()-1);
       spolki.get(0).getNotowania().add(0, new Notowanie(18, yesterday, 4.0, spolki.get(0)));
       spolki.get(1).getNotowania().add(0, new Notowanie(87, yesterday, -2.0, spolki.get(1)));
       spolki.get(2).getNotowania().add(0, new Notowanie(17, yesterday, 10.0, spolki.get(2)));
   }
   
   public List<Spolka> getSpolki()
   {
       return spolki;
   }
   
   public void setSpolki(List<Spolka> spolki)
   {
       this.spolki = spolki;
   }

   public Spolka getActiveCompany(){
       for(Spolka s : this.getSpolki())
       {
           System.out.println("active Company1" + " s.getSymbol(): " + s.getSymbol() + " this.getActiveCompanySymbol() " + this.getActiveCompanySymbol());
           if(s.getSymbol().equals(this.getActiveCompanySymbol()))
           {
               System.out.println("active Company2");
               return s;
           }
       }
       return null;
   }
   
    /**
     * @return the activeCompanySymbol
     */
    public String getActiveCompanySymbol() {
        return this.activeCompanySymbol;
    }

    /**
     * @param activeCompanySymbol the activeCompanySymbol to set
     */
    public void setActiveCompanySymbol(String activeCompanySymbol) {
        System.out.println("setSymbol: " + activeCompanySymbol);
        this.activeCompanySymbol = activeCompanySymbol;
    }

    
}
