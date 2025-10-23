package com.Java_Logical_practice;

public class Swapping {
    
   
    public static void main(StringCount_of_numbers[] args) {
         int a = 10;
        int b= 20;
    //    Method 1
    //     System.out.println("Before_swapping :" + a +" " +b);
    //     int r = a;
    //     a = b;
    //     b =r ;
    //   System.out.println("After_swapping :" + a +" " +b);
       
    // Method 2
    // System.out.println("(M)Before_swapping :" + a +" " +b);
    // a = a*b;
    // b =a/b;
    // a=a/b;
    // System.out.println("(M)After_swapping :" + a +" " +b);

    // Method 3
    // System.out.println("(A)Before_swapping :" + a +" " +b);
    //  a =a+b;
    //  b=a-b;
    //  a =a-b;
    //  System.out.println("(A)After_swapping :" + a +" " +b);
    
   // Method 4
//    System.out.println("(B)Before_swapping :" + a +" " +b);
//    a=a^b;
//    b=a^b;
//    a=a^b;
//    System.out.println("(B)After_swapping :" + a +" " +b);
  // Method 5
  System.out.println("(s)Before_swapping :" + a +" " +b);
  b= (a+b)- (a=b);
  System.out.println("(s)After_swapping :" + a +" " +b);

}
}
