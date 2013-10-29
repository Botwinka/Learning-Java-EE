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
 * @author Asia
 */
public class Spolka {
    private String name;
    private String sector;
    private String symbol;
    private List<Notowanie> notowania;
    private Notowanie ostatnie;
    
    public Spolka(){}
    
    public Spolka(String name, String sector, String symbol)
    {
        this.name = name;
        this.sector = sector;
        this.symbol = symbol;
    }
    
    public Spolka(String name, String sector, String symbol, double price, double difference, Date day)
    {
        this(name, sector, symbol);
        this.notowania = new ArrayList<Notowanie>();
        notowania.add(new Notowanie(price, day, difference, this));
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setSector(String sector)
    {
        this.sector = sector;
    }
            
    public String getSector()
    {
        return this.sector;
    }
    
    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }
    
    public String getSymbol()
    {
        return this.symbol;
    }
    
    public void setNotowania(List<Notowanie> notowania)
    {
        this.notowania = notowania;
    }
    
    public List<Notowanie> getNotowania()
    {
        return notowania;
    }
    
    public void setOstatnie(Notowanie ostatnie)
    {
        this.ostatnie = ostatnie;
    }
    
    public Notowanie getOstatnie()
    {
        if(this.ostatnie == null)
        {
            if(this.getNotowania() != null && !this.getNotowania().isEmpty())
            {
                this.ostatnie = this.getNotowania().get(this.getNotowania().size()-1);
            }
        }
        return this.ostatnie;
    }
}
