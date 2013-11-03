/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.helion.jeeweb.hellojsf.entity;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author R950
 */
public class SectorInfoBean {
    private ManagerBean managerBean;
    private Map<String, Double> prices;
    
    public SectorInfoBean() {
    }

    /**
     * @return the prices
     */
    public Map<String, Double> getPrices() {
        prices = new HashMap<String, Double>();
        if(this.getManagerBean()!= null)
        {
            for(Spolka company : this.getManagerBean().getSpolki())
            {
                Double value = prices.get(company.getSector());
                if(value == null)
                {
                    value = 0.0;
                }
                prices.put(company.getSector(), value + company.getOstatnie().getPrice());
            }
        }
        return prices;
    }
    
    public Object[] getSectors()
    {
        Map<String, Double> pricesMap =this.getPrices();
        return pricesMap.keySet().toArray();
    }

    /**
     * @return the managerBean
     */
    public ManagerBean getManagerBean() {
        return managerBean;
    }

    /**
     * @param managerBean the managerBean to set
     */
    public void setManagerBean(ManagerBean managerBean) {
        this.managerBean = managerBean;
    }
}
