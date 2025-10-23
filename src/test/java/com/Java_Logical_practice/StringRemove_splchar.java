package com.Java_Logical_practice;

public class StringRemove_splchar {
    public static void main(String[] args) {
        String name ="Ab9@#xY7$kL3!";
       String s = name.replaceAll("[^a-zA-Z0-9]", "");
       System.out.println(s);
    

    
    // reomve the white sapce
    String space = " this my java class ";
    String sp = space.replaceAll("\\s","");
    System.out.println(sp);
    }


}
