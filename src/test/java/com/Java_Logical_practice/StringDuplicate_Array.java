package com.Java_Logical_practice;

public class StringDuplicate_Array {
    public static void main(String[] args) {
        String name []= {"java","php",".net","c++","c","c"};
        boolean dup = false;
        for(int i=0;i<name.length-1;i++){
            for(int j=i+1;j<name.length;j++){
                if(name[i]==name[j]){
                 dup=true;
                }
            }
        }
        if(dup== true){
            System.out.println("Duplicate name found in the name list");
        }
        else{
            System.out.println("No duplicate is found in the name list");
        }
    }
}
