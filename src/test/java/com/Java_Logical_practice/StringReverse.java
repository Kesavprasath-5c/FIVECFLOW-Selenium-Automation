package com.Java_Logical_practice;

public class StringReverse {
    public static void main(String[] args) {

        String name = "ABCD";
        int nl = name.length();
        String Rev = "";
        //using charAt method 
        
       
        // while(nl>0){
        //     for(int i=nl-1;i>=0;i--){
        //      Rev = Rev + name.charAt(i);

        //     }
        //     System.out.println("Reverse name :" +Rev);
        // }
       // using Array method

        //Reverse using charArray
         char[] c = name.toCharArray();

         for(int i =nl-1;i>=0;i--){
            Rev = Rev+ c[i];
           
         }
          System.out.print(Rev);
         
    }
}
