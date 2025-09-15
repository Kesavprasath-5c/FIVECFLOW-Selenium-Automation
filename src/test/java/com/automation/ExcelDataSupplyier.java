package com.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataSupplyier {
   
@Test
@DataProvider
public void getdata() throws Exception {
    

   File file = new File("./src/test/java/com/automation/Excelfiles/Test1.xlsx");
   FileInputStream fis = new FileInputStream(file);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheetAt(0);
     DataFormatter formatter = new DataFormatter();
    
    // int numofRows =sheet.getPhysicalNumberOfRows();
    // int nomofcolm = sheet.getRow(0).getLastCellNum();
    // String data[][]= new String[numofRows-1][nomofcolm];
    // for(int i=0;i<numofRows-1;i++) {
    //   for(int j=0;j<nomofcolm;j++){
    //     DataFormatter formatter = new DataFormatter();
      
    //   data[i][j] =formatter.formatCellValue(sheet.getRow(i+1).getCell(j));
     
    //   }
    //   System.out.println();
    // }
    
    String cellvalue0=formatter.formatCellValue(sheet.getRow(1).getCell(0));
     String userId = formatter.formatCellValue(sheet.getRow(1).getCell(1));
    String Password = formatter.formatCellValue(sheet.getRow(1).getCell(2));


     System.out.println(cellvalue0);
     System.out.println(cellvalue1);
    System.out.println(cellvalue2);
    workbook.close();
    fis.close();
    // for (String[] strings : data) {
    //     System.out.println( Arrays.toString(strings));
       
    // }
   // return(data);
}

}


