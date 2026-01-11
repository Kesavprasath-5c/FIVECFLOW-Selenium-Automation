package com.Java_Logical_practice;

import java.util.Scanner;

public class String_vowels {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the name: ");
      String name =  sc.next();
      name = name.toLowerCase();  
            //String name = "zppey";
            int count = 0;
            for(int i =0; i<name.length()-1;i++){
                switch (name.charAt(i)) {
                    case 'a':
                        count++;
                        break;
                   case 'e':
                       count++;
                        break;
                   case 'i':
                       count++;
                        break;
                    case 'o':
                       count++;
                        break;
                    case 'u':
                       count++;
                        break;
                    default:
                    //System.out.println("No vowels present in the given word");
                        break;
                }
            }
            System.out.println("Total vowels count present :" + count);
        }
    }
}
