package com.automation;

import org.testng.annotations.Test;

public class Data_Provider_reciver {
    @Test(dataProvider = "getData",dataProviderClass = ReadExcelData.class)
     public void GetData(String username, String userpassword){
		System.out.println(username);
        System.out.println(userpassword);
   }
}
