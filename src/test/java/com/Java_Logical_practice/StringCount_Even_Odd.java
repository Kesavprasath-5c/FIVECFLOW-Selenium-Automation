package com.Java_Logical_practice;

public class StringCount_Even_Odd {
    public static void main(String[] args) {
        int num = 23671;
        int rev =0;
        int even_count= 0;
        int odd_count=-0;
        while(num>0){
        rev=  num%10;
        if((rev%2)==0){
            even_count++;
         
        }
        else{
            odd_count++;
        }
        num = num/10;
        

        }
        System.out.println("Even count :" + even_count);
        System.out.println("Odd Count is : "+ odd_count);
    }
}
