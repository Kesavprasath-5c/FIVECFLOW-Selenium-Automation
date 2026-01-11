package com.Java_Logical_practice;

import com.aventstack.extentreports.gherkin.model.Scenario;

public class StringLength {
    
    public static void main(String[]args){
        // String s1 = new String("Muthu");
        // String s2 =" ";
        // String s3 = "Muthu";
        // System.out.println(s1.length());
        // System.out.println(s2.isEmpty());
        // System.out.println(s2.isBlank());
     //   System.out.println(s1==s3);
//scenario =1
      String s1 = new String("Muthu");
      String s2 = "Muthu";
     if(s1==s2){
        System.out.println("s1 and s2 are same");
     }else{
        System.out.println("s1 and s2 are not same");
     }  
     if(s1.equals(s2)){
        System.out.println("s1 and s2 are same");
     }else{
        System.out.println("s1 and s2 are not same");
     } 
     //==================================================
     //Scenario =2
     String s3 = new String("Muthu");
     String s4 = s3;
     if(s3==s4){
        System.out.println("s3 and s4 are same");
     }else{
        System.out.println("s3 and s4 are not same");
     } 
     if(s3.equals(s4)){
        System.out.println("s3 and s4 are same");
     }else{
        System.out.println("s3 and s4 are not same");
     } 

     //==================================================
     //Scenario =3
     String s5 = new String("Muthu");
     String s6 = s5;
    s6 = "Lee";
     if(s5==s6){
        System.out.println("s5 and s6 are same");
     }else{
        System.out.println("s5 and s6 are not same");
     } 
     if(s5.equals(s6)){
        System.out.println("s5 and s6 are same");
     }else{
        System.out.println("s5 and s6 are not same");
     } 
     //==================================================
     //Scenario =4
     String s7 = new String("Muthu");
     String s8 = s7;
    s8 = "Muthu";
     if(s7==s8){
        System.out.println("s7 and s8 are same");
     }else{
        System.out.println("s7 and s8 are not same");
     } 
     if(s7.equals(s8)){
        System.out.println("s7 and s8 are same");
     }else{
        System.out.println("s7 and s8 are not same");
     } 
     //==================================================
     //Scenario =5
     String s9 = new String("Muthu");
     String s10 = s9;
    s10 = "Lee";
    s9="Lee";
     if(s9==s10){
        System.out.println("s9 and s10 are same");
     }else{
        System.out.println("s9 and s10 are not same");
     } 
     if(s9.equals(s10)){
        System.out.println("s9 and s10 are same");
     }else{
        System.out.println("s9 and s10 are not same");
     } 
     //==================================================
     //Scenario =6
     String s11 = new String("Muthu");
     String s12 = s11;
    s12 = "Lee";
    s11=new String("Das");
    s12=new String("Das");
     if(s11==s12){
        System.out.println("s11 and s12 are same");
     }else{
        System.out.println("s11 and s12 are not same");
     } 
     if(s11.equals(s12)){
        System.out.println("s11 and s12 are same");
     }else{
        System.out.println("s11 and s12 are not same");
     } 
     //==================================================
    }
}
