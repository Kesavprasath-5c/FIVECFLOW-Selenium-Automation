 package com.Java_Logical_practice;

import java.util.Arrays;

public class StringBubble_sort {

    public static void main(String[] args) {
            int []a ={3,7,9,6,2,8};
            int tem;
            for(int i=0;i<a.length-1;i++){
             for(int j=0;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    tem =a[j];
                    a[j]=a[j+1];
                    a[j+1]=tem;
                }
             }
            }
            System.out.println(Arrays.toString(a));
    }


}
