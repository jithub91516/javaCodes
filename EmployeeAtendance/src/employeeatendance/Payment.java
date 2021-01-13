/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeatendance;

/**
 *
 * @author hp
 */
public class Payment {

    private double hours;
    private double taxes = 0.045;
    private double insurance = 0.038;
    private double wagePerHour;

    /**
     * Default Constructor
     */
    public Payment() {
    }

    /**
     * Constructor takes number of hours and wage per hours as parameters
     *
     * @param hours number of hours employee has worked
     * @param wagePerHour wage per hour employee earn
     */
    public Payment(double hours, double wagePerHour) {
        this.hours = hours;
        this.wagePerHour = wagePerHour;

    }

    /**
     * access to wage per hour in order to set it or update it
     *
     * @param wagePerHour wage per hour employee earn
     */
    public void setWagePerHour(double wagePerHour) {
        this.wagePerHour = wagePerHour;
    }

    /**
     * access to number of hours in order to set it or update it
     *
     * @param hours number of hours employee has worked
     */
    public void setHours(double hours) {
        this.hours = hours;
    }

    /**
     * access to taxes employee should pay in order to set it or update it
     *
     * @param taxes taxes percentage employee should pay
     */
    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    /**
     * access to insurance employee should pay in order to set it or update it
     *
     * @param insurance insurance percentage employee should pay
     */
    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    /**
     * access to call the private variable wage per hour
     *
     * @return private variable wage per hour
     */
    public double getWagePerHour() {
        return wagePerHour;
    }

    /**
     * access to call the private variable hours
     *
     * @return private variable hours
     */
    public double getHours() {
        return hours;
    }

    /**
     * access to call the private variable taxes
     *
     * @return private variable taxes
     */
    public double getTaxes() {
        return taxes;
    }

    /**
     * access to call the private variable insurance
     *
     * @return private variable insurance
     */
    public double getInsurance() {
        return insurance;
    }

    /**
     * a method to calculate the total net payment for employee by subtracting
     * the taxes and insurance part from total salary
     *
     * @return total net payment
     */
    public double calculateNetPayment() {

        return (hours * wagePerHour) - ((taxes + insurance) * (hours * wagePerHour));
    }

}
