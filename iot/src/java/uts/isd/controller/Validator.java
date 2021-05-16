package uts.isd.controller;

   import java.io.Serializable;
   import java.util.regex.Matcher;
   import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;


   public class Validator implements Serializable{ 

 
   private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";      
   private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";       
   private String passwordPattern = "[a-z0-9]{4,}";       
   private String deviceTypePattern = "^[A-Za-z\\s]*";  
   private String deviceIntPattern = "^+?[0-9]*$"; 
   private String positionPattern = "[a-zA-Z0-9]*";        
     private String datePattern = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";    
   
   public Validator(){    }       

    public boolean validatePosition(String position) {
        return validate(positionPattern, position);
    }
   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       
      return match.matches(); 
   }       

   public boolean checkEmpty(String email, String password){       

      return  email.isEmpty() || password.isEmpty();   
   }
   
   public boolean validateDate(String date){

      return validate(datePattern,date); 

   }     
   
   public boolean validateEmail(String email){                       
      return validate(emailPattern,email);   
   } 
   
   public boolean validateDeviceInt(String price){
      return validate(deviceIntPattern,price); 
   } 
   
   public boolean validateDeviceType(String type){
      return validate(deviceTypePattern,type); 
   } 
       
   public boolean validateName(String name){
      return validate(namePattern,name); 
   }       
   

   public boolean validatePassword(String password){
      return validate(passwordPattern,password); 
   }          
   
   public void clear(HttpSession session){
       session.setAttribute("typeErr", "Enter type");
       session.setAttribute("priceErr", "Enter price");
       session.setAttribute("stockErr", "Enter stock");
       session.setAttribute("existErr", "");
       session.setAttribute("resultInfor", "");
   }
}