package com.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataSupplyier {
   
@Test
public void testFileExists() throws Exception {
    

   File file = new File("/Users/Kesav/Desktop/Automation2.o/FIVECFLOW-Selenium-Automation/src/test/java/com/automation/Excelfiles/Test.xlsx");
   FileInputStream fis = new FileInputStream(file);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheetAt(0);
    String cellvalue =sheet.getRow(0).getCell(0).getStringCellValue();
    System.out.println(cellvalue);
    workbook.close();
    fis.close();
    


}

}


