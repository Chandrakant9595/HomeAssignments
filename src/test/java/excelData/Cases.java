package excelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 

public class Cases extends Base{

	public static void main(String[] args) throws IOException {
	    try {
	        FileInputStream file = new FileInputStream(new File("D:\\Projects\\HomeAssignment\\src\\test\\java\\excelData\\TestData.xlsx"));
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheetAt(0);

	        Iterator<Row> rowIterator = sheet.iterator();
	        while (rowIterator.hasNext())
	        {
	            Row row = rowIterator.next();
	            Iterator<Cell> cellIterator = row.cellIterator();

	            while (cellIterator.hasNext()) 
	            {
	                Cell cell = cellIterator.next();
	                switch (cell.getCellType()) 
	                {
	                    case Cell.CELL_TYPE_NUMERIC:
	                        System.out.print(cell.getNumericCellValue() + "\t");
	                        break;
	                    case Cell.CELL_TYPE_STRING:
	                        System.out.print(cell.getStringCellValue() + "\t");
	                        break;
	                }
	            }
	            System.out.println("");
	        }
	        file.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	
	    String excelFilePath = "D:\\Projects\\HomeAssignment\\src\\test\\java\\excelData\\TestData.xlsx";
	    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	    
	    Workbook workbook = new XSSFWorkbook(inputStream);
	    Sheet sheet = workbook.getSheetAt(0);
	    
	    sheet.getRow(4).getCell(0).setCellFormula("SUM(A1:A3)");
	    
	    inputStream.close();
	    
	    FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        ((FileInputStream) workbook).close();
        outputStream.close();
	
	    
	}

}