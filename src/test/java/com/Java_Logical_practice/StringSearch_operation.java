package com.Java_Logical_practice;

public class StringSearch_operation {
    public static void main(String[] args) {
        String name = " java payilagam";
        char n = 'a';
        int count = 0;
        for(int i =0;i<name.length()-1;i++){
            if (n == name.charAt(i)) {
                count++;
            }
        }
        System.out.println("count of given char: "+count);
    }
}
