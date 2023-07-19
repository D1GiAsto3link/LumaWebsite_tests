package Utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelReader {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public static void setupExcel(){
///Try Catch statement for the location of Excel sheet!
        try {
            workbook = new XSSFWorkbook("src/main/java/org/AssessmentData/TestData1.xlsx"); //Location/path
            sheet = workbook.getSheet("LumaSheet1"); //The name of the Sheet in the Excel doc

            workbook.close();  //Closes the workbook after it's done being read
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCellData(int rowNum, int cellNum){
        setupExcel(); //Sets up the doc to be read
        String cellData = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
        return cellData;
    }

    public static int getCellInt(int rowNum, int cellNum){
        setupExcel();
        int cellData = (int) sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
        return cellData;
    }

}
