package Flight.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class utilityTestData {
	
/*	public static void main(String[] args) {
		File excelfile = new File("C:\\Users\\mittal.tannya\\eclipse-workspace1\\FlightMng\\src\\test\\java\\excelData\\FlightData.xlsx");
		System.out.println(excelfile.exists());
	}}*/
	
	static Workbook workbook ;
	static Sheet sheet ;
	
	private static String FILE_PATH = "C:\\Users\\mittal.tannya\\eclipse-workspace1\\FlightMng\\src\\test\\java\\excelData\\FlightData.xlsx";

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
      //  Workbook workbook = null;
     //   Sheet sheet = null;

        try {
            file = new FileInputStream("C:\\Users\\mittal.tannya\\eclipse-workspace1\\FlightMng\\src\\test\\java\\excelData\\FlightData.xlsx");
            workbook = WorkbookFactory.create(file);
            sheet = workbook.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sheet == null) {
            System.out.println("Sheet '" + sheetName + "' not found.");
            return new Object[0][0]; // or handle this case as appropriate
        }

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                data[i][j] = cell.toString();
            }
        }

        return data;
    }
}



