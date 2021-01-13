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
public class Employee {
    private String firstName;
    private String lastName;
    private int idNumber;
    Password password;
    Department department;
    Payment payment;
    public Employee(){
        this.payment=new Payment();
        this.password=new Password();
    this.department=new Department();
    }
    public Employee(String firstname,String lastname,int idnum,String password,String department,double wage){
    setFirstName(firstname);
    setFirstName(lastname);
    setIdNumber(idnum);
    this.password=new Password();
    this.password.setPassword(password);
    this.department=new Department();
    this.department.setDepatmentName(department);
    this.payment=new Payment();
    this.payment.setWagePerHour(wage);
    }

    public String getPassword() {
        return password.getPassword();
    }

    public void setPassword(String password) {
        this.password.setPassword(password);
    }

    public String getDepartment() {
        return department.getDepatmentName();
    }

    public void setDepartment(String department) {
        this.department.setDepatmentName(department);
    }

    public Payment getPayment() {
        return payment;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
    public String toString(){
    return "First Name: "+firstName+" Last Name "+lastName+" ID Number: "+idNumber;
    }
}
