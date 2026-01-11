package com.Java_Logical_practice;

public class StringFibonacci_serious {
    public static void main(String[] args) {
      //  Fab series 0 1 1 2 3 5 8 13 21 34
        int n1 =0;
        int n2 = 1;
      
        System.out.print(n1 + " "+n2);
        for(int i =2;i<10;i++){
            
         int sum = n1+n2;
         System.out.print(" "+sum);
            n1=n2;
            n2=sum;

        }
       
    }
}
