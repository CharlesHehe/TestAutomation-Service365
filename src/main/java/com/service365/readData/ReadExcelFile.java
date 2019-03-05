package com.service365.readData;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadExcelFile {
    public Object[][] readExcel(String filePath, String fileName, String sheetName) throws IOException {
//        Create an object of File class to open xlsx file
        File file = new File(filePath + "\\" + fileName);
//        Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
//        Find the file extension by splitting file name in substring and getting only extension name
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
//        Check condition if the file is xlsx file
        if (fileExtensionName.equals(".xlsx")) {
//            If it is xlsx file then create object of XSSWork book class
            workbook = new XSSFWorkbook(inputStream);
        } else if (fileExtensionName.equals(".xls")) {
//            If it is xls file then create object of XSSFWorkbook class
            workbook = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = workbook.getSheet(sheetName);
//        Find number of rows in excel file
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//        Find number of columns in the excel file
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Create a loop over all the rows of excel file to read it
        ArrayList<String> list = new ArrayList<String>();

        HashMap<String, String>[][] hashMap =new HashMap[rowCount][1];
        if (rowCount > 1) {
            for (int i = 0; i < rowCount ; i++) {
                hashMap[i][0] = new HashMap();
            }
        } else {
            System.out.println("测试的Excel"+file+"中没有数据");
        }
        for (int c = 0; c < columnCount; c++) {
            Cell cell = sheet.getRow(0).getCell(c);
            list.add(cell.getStringCellValue());
        }
        for (int r = 0; r <rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {
                Cell cell = sheet.getRow(r+1).getCell(c);
                hashMap[r ][0].put(list.get(c), cell.toString());
            }
        }
        return hashMap;
    }
}
