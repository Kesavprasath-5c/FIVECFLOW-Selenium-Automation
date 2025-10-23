package com.automation;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcelData {

   @DataProvider
    public Object[][] getData ()throws Exception {
       String path = "/Users/Kesav/Desktop/automation-projects/FIVECFLOW-Selenium-Automation/src/test/resources/DataFile for Automation.xlsx";
        File exefile = new File(path);
        System.out.println(exefile.exists());
        
        FileInputStream fs = new FileInputStream(exefile);
        XSSFWorkbook wb = new XSSFWorkbook(fs);
        XSSFSheet sh = wb.getSheet("Sheet1");
        DataFormatter df = new DataFormatter();
        Object[][] data = new Object[1][2]; // only 1 row, 2 columns
        data[0][0] = df.formatCellValue(sh.getRow(1).getCell(0));
        data[0][1] = df.formatCellValue(sh.getRow(1).getCell(1));
        wb.close();
        fs.close();

    //     int No_of_row = sh.getPhysicalNumberOfRows();
    //     int No_of_col = sh.getRow(0).getPhysicalNumberOfCells();
    //     Object [][] data = new Object[No_of_row-1][No_of_col];
    //     for(int i =0;i<No_of_row-1;i++){
    //      for(int c =0; c<No_of_col;c++){
    //        DataFormatter df = new DataFormatter();
    //       data[i][c] = df.formatCellValue(sh.getRow(i+1).getCell(c));
    //     }
    //   }
        
     
    return data;

    }

}
