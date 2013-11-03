/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.helion.jeeweb.hellojsf.entity;

import java.util.Date;

/**
 *
 */
public class Notowanie {
    private double price;
    private Date  day;
    private double change;
    private Spolka spolka;
    private double priceGain;
    
    public Notowanie(){};
    
    public Notowanie(double price, Date day, double change, Spolka spolka)
    {
        this.price = price;
        this.day = day;
        this.change = change;
        this.spolka = spolka;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public double getPrice()
    {
        return this.price;
    }
    
    public void setDay(Date day)
    {
        this.day = day;
    }
    
    public Date getDay()
    {
        return day;
    }
    
    public void setChange(double change)
    {
        this.change = change;
    }
    
    public double getChange()
    {
        return this.change;
    }
    
    public void setSpolka(Spolka spolka)
    {
        this.spolka = spolka;
    }
    
    public Spolka getSpolka()
    {
        return spolka;
        
    }

    /**
     * @return the priceGain
     */
    public double getPriceGain() {
        return priceGain;
    }

    /**
     * @param priceGain the priceGain to set
     */
    public void setPriceGain(double priceGain) {
        this.priceGain = priceGain;
    }
    
}
