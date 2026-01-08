

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//Excel File--->Workbook--->Sheets--->Rows----Cells


public class ReadingDataFromExcel {

    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\OrangeHRMTestLogin.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int total_rows = sheet.getLastRowNum();
        int total_cols = sheet.getRow(0).getLastCellNum();

        //System.out.println(total_cols+" "+total_rows);

        for(int r = 0;r<total_rows;r++){
            for(int c=0;c<total_cols;c++){
                DataFormatter df = new DataFormatter();
                String curCol = df.formatCellValue(sheet.getRow(r+1).getCell(c));
                System.out.print(curCol+"\t");
            }
            System.out.println();
        }
    }

//	public static void main(String[] args) throws IOException {
//
//		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
//
//		XSSFWorkbook workbook=new XSSFWorkbook(file);
//
//		XSSFSheet  sheet=workbook.getSheet("Sheet1");  //	XSSFSheet  sheet=workbook.getSheetAt(0);
//
//		int totalRows=sheet.getLastRowNum();
//
//		int totalCells=sheet.getRow(0).getLastCellNum();
//
//		System.out.println("number of rows:"+ totalRows); //5
//		System.out.println("number of cells:"+ totalCells);  //4
//
//		for(int r=0;r<=totalRows;r++)
//		{
//			XSSFRow currentRow=sheet.getRow(r);
//
//			for(int c=0;c<totalCells;c++)
//			{
//				XSSFCell cell=currentRow.getCell(c);
//				System.out.print(cell.toString()+"\t");
//
//			}
//			System.out.println();
//		}
//
//		workbook.close();
//		file.close();
//        for(int r=0;r<totalRows;r++){
//            XSSFRow curRow = sheet.getRow(r);
//            for(int c=0;c<totalCells;c++){
//
//                XSSFCell curCol = curRow.getCell(c);
//                System.out.print(curCol.toString()+" ");
//            }
//            System.out.println();
//        }
//
//        workbook.close();
//        file.close();
//


}








