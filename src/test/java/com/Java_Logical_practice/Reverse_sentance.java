package com.Java_Logical_practice;

import java.util.ArrayList;

public class Reverse_sentance {
    
    public static void main(String[] args) {
        String ss = "The Car on a tree Road";
      ArrayList<String> al = new ArrayList<>();
      al.add("car");
      al.add("road");

       //String [] targetwords = {"car","road"};
       for (String target : al) {
        int index = ss.toLowerCase().indexOf(target.toLowerCase());
       if(index!=-1){
        String before = ss.substring(0,index);
        String after = ss.substring( index+target.length());
        ss = before + target.toUpperCase() + after;
       }
        
       }
       
        System.out.println("Final Text: " + ss);

    }
}
