package com.Java_Logical_practice;

public class StringRevesre_number {
    public static void main(String[] args) {
      // reverse using the logic
        int num = 6789;
        // System.out.println("Before reverse :"+ num);
        // int rev = 0;
        // while(num!=0){
        //     rev =rev*10 +num%10;
        //     num=num/10;
        // }
        // System.out.println("After Reverse :" +rev);

         //Reverse using StringBuffer
         StringBuffer sb = new StringBuffer(String.valueOf(num));
         System.out.println("Reverse using StringBuffer "+sb.reverse());

         //Reverse using String builder
         StringBuilder bui = new StringBuilder();
         StringBuilder built = bui.append(num);
         System.out.println("Using the String Builder Method: " +built.reverse());


        }

    }

