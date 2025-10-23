package com.Java_Logical_practice;

public class StringR {
    public static void main(String[] args) {

        int num = 1234;
        System.out.println("Before reverse :"+ num);
        int rev = 0;
        while(num!=0){
            rev =rev*10 + num%10;
            num=num/10;
        }
        System.out.println("After Reverse :" +rev);
        }
    }

