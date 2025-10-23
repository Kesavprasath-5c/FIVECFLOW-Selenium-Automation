package com.Java_Logical_practice;

public class Stringlinear_Search {
    public static void main(String[] args) {
        int search = 50;
        boolean s = false;
        int []num_lis = {20,40,30,70,65,53};
        for(int i =0;i<=num_lis.length-1;i++){
          if(num_lis[i]==search){
            s = true;
            break;

          }

        }
        if(s==true){
            System.out.println("Serach item is found on the lis");
        }
        else{
            System.out.println("search item is not found in the list");
        }
    }
}
