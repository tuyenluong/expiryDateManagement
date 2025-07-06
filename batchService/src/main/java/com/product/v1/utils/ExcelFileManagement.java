package com.product.v1.utils;

import com.product.v1.exception.ResourceNotFoundException;
import com.product.v1.model.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelFileManagement {

    // Helper method to partition the list into smaller batches
    public static List<List<Product>> partitionList(List<Product> list, int batchSize) {
        List<List<Product>> partitions = new ArrayList<>();
        for (int i = 0; i < list.size(); i += batchSize) {
            partitions.add(list.subList(i, Math.min(i + batchSize, list.size())));
        }
        return partitions;
    }

    public static List<Product> readExcelFile(MultipartFile fileLocation){
        try{
            Workbook workbook = new XSSFWorkbook(fileLocation.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            int lastRow = sheet.getLastRowNum();
            List<Product> products = new ArrayList<>();
            for (int i = 1; i < lastRow; i++){
                Row row = sheet.getRow(i);
                String sku = String.valueOf((int) row.getCell(0).getNumericCellValue()) ;
                Cell nameProduct = row.getCell(1);
                Product product = Product.builder().sku(sku).name(nameProduct.getStringCellValue()).build();
                products.add(product);
            }
            return products;
        }catch (IOException e){
            throw new ResourceNotFoundException("File not found: " + e);
        }
    }

    private static void setCellValue(Row row, String[] data){
        for(int i = 0; i < data.length; i++){
            Cell cell = row.getCell(i);
            if (cell == null) {
                cell = row.createCell(i);
            }
            cell.setCellValue(data[i]);
        }
    }

    public static byte[] exportExcelBytes(List<Product> productList) {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Products_info");

            Row headerRows = sheet.createRow(0);
            String[] headers = {"SKU", "Product Name", "Production date", "Expiry date"};
            setCellValue(headerRows, headers);

            for (int i = 0; i < productList.size(); i++) {
                String[] rowValue = getStrings(productList, i);
                Row productRow = sheet.createRow(i + 1);
                setCellValue(productRow, rowValue);
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    private static String[] getStrings(List<Product> productList, int i) {
        Product product = productList.get(i);
        String productionDate = "";
        String expiryDate = "";
        if (product.getProductionDate() != null) {
            productionDate = product.getProductionDate().toString();
        }
        if (product.getExpiryDate() != null) {
            expiryDate = product.getExpiryDate().toString();
        }
        return new String[]{
                product.getSku(),
                product.getName(),
                productionDate,
                expiryDate
        };
    }


}
