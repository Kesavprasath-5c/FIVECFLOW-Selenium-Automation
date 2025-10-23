package com.Java_Logical_practice;

public class StringOperations {
    public static void main(StringCount_of_numbers[] args) {
        
        String s1 = "java";

        //is blank()-----------
      /*   boolean t = s1.isBlank();
        System.out.println(t);
        if(t== true){
            System.out.println("Given String is blank");
        }
        else{
            System.out.println("Given Strig is not blank ");
      */  
     
      //isempty-------------
   /*  boolean t =  s1.isEmpty();
    if(t == true){
     System.out.println("Given String is Empty");
    }
    else{
        System.out.println("Given Stringb is not Empty");
    }
    */
   String s2 = "java";
   //System.out.println(s1.equalsIgnoreCase(s2));
   // System.out.println(s1.compareToIgnoreCase(s2));
   //System.out.println(s.startsWith("J"));
  // System.out.println(s.endsWith("i"));
   //System.out.println(s.startsWith("pay", 5));
   //System.out.println(s2.contentEquals(s1));

   // Searching meathod------

   String s = "i Java payilagam java chennai";
   //System.out.println(s.indexOf('7'));
   //System.out.println(s.lastIndexOf('a'));
   //System.out.println(s.indexOf('a', 10));
   // System.out.println(s.indexOf("chennai", 15));
   //System.out.println(s.lastIndexOf("Java",13));

   //character Extraction
   //System.out.println(s.charAt(15));
   //System.out.println(s.substring(2,6));
   //System.out.println(s.toLowerCase());
  // System.out.println(s.toUpperCase());
//   System.out.println("Before strip length of s is :" + s.length());
//   String strip = s.strip();
//   System.out.println(strip.strip());
//   System.out.println("After strip length of s is :" + strip.length());
     //System.out.println(s.repeat(2));
     char first = s.charAt(0);
     int count = 1;
     for(int i =0;i<s.length()-1;i++){

        if(first == s.charAt(i)){
            
            count++;
        }
        
     }
     
    }

    
}
