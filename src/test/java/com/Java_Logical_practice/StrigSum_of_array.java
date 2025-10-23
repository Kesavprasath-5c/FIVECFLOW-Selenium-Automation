package com.Java_Logical_practice;

public class StrigSum_of_array {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        int count = 0;
        System.out.println(num.length);
        for(int i =0 ;i<=num.length-1;i++){
          count=count+ num[i];
        }
        System.out.println(count);
    }
}
