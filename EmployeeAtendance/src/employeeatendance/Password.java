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
public class Password {
 private String password;
 
 /*
 method to validate password
 */
  private boolean isValid(String password)throws IllegalArgumentException{
        int number=0;
        int upper=0;
        int lower=0;
        int spec=0;
    if(password.length()>=8&&password.length()<=10){
    for(int i=0;i<password.length();i++){
    char c=password.charAt(i);
    if(Character.isDigit(c)){number++;}
    if(Character.isUpperCase(c)){upper++;}
    if(Character.isLowerCase(c)){lower++;}
    if(((c >= 32 && c <= 47) || (c >= 58 && c <= 64) || (c >=123 && c <=126))){
            
    spec++;
    }
  }
    if(password.contains(" ")){
   // return false;
       throw new IllegalArgumentException("Invalid Password");

    }
   if(upper>=1 && lower>=1 && spec>=1 && number>=1){
   return true;
   } 
    }
    //return false;
    throw new IllegalArgumentException("Invalid Password");
    }
 
    
    /**
     *  validating and setting new password
     * @param password setting password
     * @throws IllegalArgumentException 
     */
    public void setPassword(String password)throws IllegalArgumentException{
    if(isValid(password)){ this.password=password;}
    else{
    //throw new Exception();}
           throw new IllegalArgumentException("Invalid Password");
    }
    }
    /**
     * 
     * @return password
     */
    public String getPassword(){return password;}
}
