package eCommerce.Test;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class readFromExcel {
    public static String location = "./test-data/SignUpEcommerce.xlsx";
    public static String[][] getDataFromExcel() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(location);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int LastRow = sheet.getLastRowNum();
        System.out.println(LastRow);
        short LastCell = sheet.getRow(0).getLastCellNum();
        System.out.println(LastCell);
        String[][] data = new String[LastRow][LastCell];
        for(int i=1;i<=LastRow;i++){
            XSSFRow row = sheet.getRow(i);
            for(int j=0;j<LastCell;j++){
                String value = new DataFormatter().formatCellValue(row.getCell(j));
                data[i-1][j] = value;
            }
        }
        workbook.close();
        return data;
    }

   public static String[] getOrderDataByUser(String username) throws IOException {

       XSSFWorkbook workbook = new XSSFWorkbook(location);
       XSSFSheet sheet = workbook.getSheetAt(1);

       int lastRow = sheet.getLastRowNum();

       for (int i = 1; i <= lastRow; i++) {

           XSSFRow row = sheet.getRow(i);

           String excelUser =
                   new DataFormatter().formatCellValue(row.getCell(0));

           if (excelUser.equals(username)) {

               String[] data = new String[6];

               for (int j = 1; j <= 6; j++) {
                   data[j - 1] =
                           new DataFormatter().formatCellValue(row.getCell(j));
               }

               workbook.close();
               return data;
           }
       }
       workbook.close();
       return null;
   }
}
