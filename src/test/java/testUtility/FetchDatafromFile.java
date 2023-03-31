package testUtility;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDatafromFile {
public static String fetchdatafromfile(int a, int b) throws EncryptedDocumentException, IOException 
{
 String data="";
 String path="src\\test\\resources\\Excelfile\\TestNinja.xlsx";
FileInputStream file= new FileInputStream(path);
Sheet s= WorkbookFactory.create(file).getSheet("Sheet1");
Cell c=s.getRow(a).getCell(b);
CellType type=c.getCellType();
if (type==CellType.STRING)
{
	data = c.getStringCellValue();
}
else if (type==CellType.NUMERIC)
{
	double number =c.getNumericCellValue();
	 data=String.valueOf(number);
}
else if (type==CellType.BLANK)
{
	data= "";
}

 return data;
 
}
}