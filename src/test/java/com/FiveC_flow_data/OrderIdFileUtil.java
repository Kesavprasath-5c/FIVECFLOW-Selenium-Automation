package com.FiveC_flow_data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OrderIdFileUtil {
    


    public static void stroreOrderId(String orderId){
        File ff = new File("/Users/Kesav/Documents/caseid/id.txt");
        
        try {
            FileWriter file = new FileWriter(ff, false); // false = overwrite mode
            BufferedWriter bf = new BufferedWriter(file);
            bf.write(orderId);
            bf.flush();
            bf.close();
            file.close();
            System.out.println("Order ID stored successfully in file: " + orderId);
        } 
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to store order ID: " + e.getMessage());
        }   
      }

      public static String get_orderId() throws Exception{
        File ff = new File("/Users/Kesav/Documents/caseid/id.txt"); 
      
       
        FileReader fr = new FileReader(ff);
        BufferedReader br = new BufferedReader(fr);
        String orderID = br.readLine();
        br.close();
        return orderID;
      }
    
      }

