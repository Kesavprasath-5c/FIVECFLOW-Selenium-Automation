package com.Java_Logical_practice;

public class String_palindrom_num {
    public static void main(String[] args) {
        int number = 4554;
        int rev = number;
        int palen = 0;
        while(number!=0){

            palen =palen*10 + number%10;
            number = number/10;
        }
        System.out.println(palen);
        if(palen==rev){
            System.out.println("given number is Palindrom");
        }
        else{
            System.out.println("Not Palindrom");
        }
    }
}

