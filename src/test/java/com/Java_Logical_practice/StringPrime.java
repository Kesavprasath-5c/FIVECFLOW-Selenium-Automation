package com.Java_Logical_practice;

public class StringPrime {
    
    public static void main(String[] args) {
        int num =17;
        int count =0;
        if(num>0){
        for(int i =1;i<=num;i++){
         if(num%i ==0){
            count++;
         }
        }
    }
    else{
        System.out.println("Give number is not valid");
    }
     if(count==2){
        System.out.println("Given number is prime");
     }
     else{
        System.out.println("Given Number is not prime");
     }

    }
}
