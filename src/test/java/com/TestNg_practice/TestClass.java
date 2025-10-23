package com.TestNg_practice;

import java.util.Scanner;

public class TestClass {
    
    public static void main(String[] args) {
    System.out.println("Enter the sentance :");
    Scanner sc = new Scanner(System.in);
    String sentance= sc.nextLine();
    System.out.print("Enter the words to reverse (separated by commas): ");
    String []target_name= sc.nextLine().split(",");
    
    
      //String sentance = "Kesav prasath is a good man";
     // String []target_name = {"prasath","good"};

      for (String target : target_name) {
        target =target.strip().toLowerCase();



        if(sentance.contains(target)){
            StringBuilder sb = new StringBuilder(target);
            StringBuilder reverse = sb.reverse();
            String st = reverse.toString();
            System.out.println(st);
            sentance = sentance.replace(target, st);
        }
      }
     
      System.out.println(sentance);
    }
}
