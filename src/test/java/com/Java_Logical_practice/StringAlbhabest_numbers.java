package com.Java_Logical_practice;

public class StringAlbhabest_numbers {
    public static void main(String[] args) {
        String name = "chennai ";
    /*    int count =1;
        for(int i= 0;i<name.length()-1;i++){
            if(name.charAt(i)>='0'){
                if (name.charAt(i)<='9') {
                    
                    count++;
                }
                
            }
                we can do above same method for char aslo
        }
        if(count>1){
        System.out.println("Nmubers count :" + count);
    }
    else{
        System.out.println("No number is present");
    }
*/
  String n = name.replaceAll("\\d", "");
  System.out.println(n);
  if(name.length() == n.length()){
    System.out.println("No numbers present");
}
else{
 System.out.println("Number is present in the given string");
}

}


}
