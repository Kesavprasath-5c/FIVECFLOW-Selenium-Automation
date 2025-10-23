package com.Java_Logical_practice;

public class String_palindrom {
    public static void main(String[] args) {
        String name = "madem";
        int le = name.length();
        String palin = name;
        String rev = "";
        
        for(int i =le-1;i>=0;i--){
         rev = rev+ name.charAt(i);
        }
        if(rev.equals(palin)){
        System.out.println("After palindrom : "+rev);
        }
        else{
            System.out.println("Given String not a palindrome");
        }
        

        
    }

    
}


