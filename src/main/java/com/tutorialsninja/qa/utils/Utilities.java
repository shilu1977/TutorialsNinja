package com.tutorialsninja.qa.utils;

import java.util.Date;

public class Utilities {
	
	public final static int IMPLICIT_WAIT = 10;
	public final static int PAGE_WAIT_TIME = 5;

	public static String generateTimeStamp()
	{
		Date date = new Date();
		String timestamp = date.toString().replace(" ","_").replace(":","_");
		return "alisha" + timestamp + "@gmail.com";
	}
	
	
	/*public static Object[][] getTestDataFromExcel(String sheetName) throws IOException
	{
		File excelFile = new File(System.getProperty("C:\\Users\\shilu\\eclipse-workspace\\EdurekaSelenium\\TutorialsNinja\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\TestData.xlsx"));
		FileInputStream fisExcel = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fisExcel);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int i=0;i<rows;i++)
			{
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<cols;j++)
			{
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				
			}
	
			}
		return data;
	
	}*/

}