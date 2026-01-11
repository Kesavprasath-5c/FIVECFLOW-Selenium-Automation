package com.Java_Logical_practice;

public class String_missingNumber {
    public static void main(String[] args) {
        int []a ={1,4,2,5,6};
        int num =0;
        int missing_num=0;
        for(int i=0;i<a.length;i++){
            num = num+a[i];

        }
        System.out.println("sum of array :" +num);

        for(int j =0;j<=6;j++){
            missing_num= missing_num +j;
        }
       System.out.println("sum of array :" +missing_num);   
        missing_num =missing_num-num;
        System.out.println("missed number in the array is "+ missing_num);
    }
}
