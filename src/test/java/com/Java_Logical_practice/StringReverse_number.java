package com.Java_Logical_practice;

import java.util.Scanner;

public class StringReverse_number {
    
public static void main(String[] args) {
    //  Method 1
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number:");
    int num = sc.nextInt();
   // int rev = 0;
    System.out.println("Before Reverse: "+ num);
    // while (num!=0) {
    //     rev =(rev*10)+ num%10;
    //     num =num/10;
        
    // }
    // System.out.println("Reverse of given number is :"+ rev);

    // method 2
    String ss = String.valueOf(num);
    StringBuffer sb = new StringBuffer(ss);
     System.out.println("After Reverse: "+ sb.reverse());

}


}
