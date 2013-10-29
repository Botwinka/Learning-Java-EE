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
   
   public ManagerBean()
   {
       spolki = new ArrayList<Spolka>();
       Date date = new Date();
       spolki.add(new Spolka("Kocia spolka weglowa", "energetyczny", "KSW", 20.0, 11.1, date));
       spolki.add(new Spolka("KitKompDotCom", "informatyczny", "KKDC", 90.0, 3.4, date));
       spolki.add(new Spolka("Kocie Dance Studio", "rozrywkowy", "KDS", 15.0, -11.7, date));
   }
   
   public List<Spolka> getSpolki()
   {
       return spolki;
   }
   
   public void setSpolki(List<Spolka> spolki)
   {
       this.spolki = spolki;
   }
}
