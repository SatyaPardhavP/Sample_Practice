package sample_Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteDatainExcel {

	@Test (enabled = true)
	public void writeExcelData() throws InvalidFormatException, IOException {
		File file = new File("C:\\Users\\spamulapati\\Desktop\\Output.xlsx");
		XSSFWorkbook srcBook = new XSSFWorkbook(); 
		XSSFSheet sourceSheet = srcBook.createSheet();
		sourceSheet.createRow(2).createCell(1).setCellValue("Number TextABCd");
		FileOutputStream fos = new FileOutputStream(file); 
		srcBook.write(fos);		
	}	
}
