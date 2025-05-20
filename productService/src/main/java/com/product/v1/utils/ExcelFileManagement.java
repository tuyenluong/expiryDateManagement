package com.product.v1.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelFileManagement {

    public static void readExcelFile(String fileLocation) throws FileNotFoundException {
        FileInputStream file = new FileInputStream(fileLocation);
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.getSheetAt(0);
        int lastRow =  sheet.getLastRowNum();
        for (int i = 1; i < lastRow; i++){
            sheet.getRow(i);
        }
    }
}
