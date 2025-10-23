package com.Java_Logical_practice;

public class StringSum_of_digits {
public static void main(String[] args) {
    int a = 1234;
    int sum = 0;
    while(a>0){
     sum = sum + a%10;
     a = a/10;
    }
    System.out.println("Total sum value is : "+sum );
}
}
