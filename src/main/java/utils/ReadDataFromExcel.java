package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int totalRows = sheet.getLastRowNum(); // index-based
        int totalCols = sheet.getRow(0).getLastCellNum(); // count-based

        Object[][] data = new Object[totalRows][totalCols];

        DataFormatter df = new DataFormatter();

        for (int r = 0; r < totalRows; r++) {
            for (int c = 0; c < totalCols; c++) {
                data[r][c] = df.formatCellValue(sheet.getRow(r + 1).getCell(c));
                System.out.println(Arrays.toString((long[]) data[r][c]));
            }
        }

        workbook.close();
        file.close();
        return data;
    }
}
