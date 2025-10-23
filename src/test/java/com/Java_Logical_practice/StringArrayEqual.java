package com.Java_Logical_practice;



public class StringArrayEqual {
    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        int b[] ={1,2,3,4,5};
        boolean status = true;
      //  boolean status = Arrays.equals(a,b);

        //if(status==true){
        for(int i =0;i<a.length;i++){
         if(a[i]!=b[i]){
          status = false;
         }
          
        }
        if(status==true){
           System.out.println("Given 2 arrays are  equal");  
        }
        else{
         System.out.println("Given 2 arrays are not equal"); 
        }
    }
        
    }

