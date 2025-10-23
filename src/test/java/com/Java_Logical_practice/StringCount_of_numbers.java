package com.Java_Logical_practice;

public class StringCount_of_numbers {
    public static void main(String[] args) {
        int num = 123345;
        
        int count = 0;
        while (num>0){
          count = count + num%10;
          num = num/10;

        }
        System.out.println("COUNT OF NUMBER : "+count);
        
    }

}
