/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.simplifiedCalculator;

/**
 *
 * @author R950
 */
public class CalculatorBean {
    private int number1;
    private int number2;
    private int sum;
    
    public CalculatorBean(){}

    public String calculate()
    {
        this.sum = this.number1 + this.number2;
        return null;
    }
    
    /**
     * @return the number1
     */
    public int getNumber1() {
        return number1;
    }

    /**
     * @param number1 the number1 to set
     */
    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    /**
     * @return the number2
     */
    public int getNumber2() {
        return number2;
    }

    /**
     * @param number2 the number2 to set
     */
    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    /**
     * @return the sum
     */
    public int getSum() {
        return sum;
    }
}
