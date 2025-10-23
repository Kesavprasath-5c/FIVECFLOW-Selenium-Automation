package com.Java_Logical_practice;

public class StringMax_and_min {
    public static void main(String[] args) {
        int [] a ={23,67,87,83,95,36,12};
        int max = a[0];
        int min =a[0];
        for(int i=1;i<=a.length-1;i++){
          if (max <a[i]){
           max =a[i];
          }
          if (min >a[i]){
           min =a[i];
          }
        }
        System.out.println("max value is :"+ max);
        System.out.println("min value is :"+ min);

}
}
