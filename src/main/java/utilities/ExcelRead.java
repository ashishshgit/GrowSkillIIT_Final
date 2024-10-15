package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	/*public static void main(String args[]) throws IOException {
		ExcelRead obj = new ExcelRead();
		ArrayList<Data> dataobj = obj.getData();
		for (Data d : dataobj)

		{
			System.out.println(d.getUsername() + " " + d.getPassword());
		}
	}*/

	public ArrayList<Data> getData() throws IOException {

		FileInputStream file = new FileInputStream(
				"C:\\Users\\Ashish\\eclipse-workspace\\GrowSkillITJuly_Final\\src\\test\\resources\\Test1.xlsx");
		Workbook book = new XSSFWorkbook(file);
		Sheet sheet = book.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator();
		ArrayList<Data> dataList = new ArrayList<Data>();
		while (rows.hasNext()) {
			Data rowData = new Data();
			Row row = rows.next();
			Iterator<Cell> cols = row.cellIterator();
			int index = 0;
			while (cols.hasNext()) {
				Cell value = cols.next();

				if (index == 0)

					rowData.setUsername(value + "");
				else

					rowData.setPassword(value + "");
				index++;
			}
			dataList.add(rowData);
			index = 0;

		}
		return dataList;
	}
}
