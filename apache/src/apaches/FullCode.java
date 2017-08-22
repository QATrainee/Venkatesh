package apaches;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FullCode {
	@SuppressWarnings("deprecation")
	public static void main(String[]args) throws IOException{
	Workbook cc = new XSSFWorkbook();
	Sheet s1 = cc.createSheet("new sheet");
	Sheet s2 = cc.createSheet("second sheet");
	CreationHelper createHelper = cc.getCreationHelper();
	Row row   = s2.createRow((short)5);
	// Create a cell and put a value in it.
	Cell cell = row.createCell(2);
	row.createCell(0).setCellValue(1.1);
	row.createCell(1).setCellValue(new Date());
	row.createCell(2).setCellValue(Calendar.getInstance());
	row.createCell(3).setCellValue("a string");
	row.createCell(4).setCellValue(true);
	row.createCell(5).setCellType(HSSFCell.CELL_TYPE_ERROR);

	CellStyle cellStyle = cc.createCellStyle();
	cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yy h:mm:ss"));
	cell.setCellValue(new Date());
	cell.setCellStyle(cellStyle);
	cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
	cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
	cellStyle.setLeftBorderColor(IndexedColors.GREEN.getIndex());
	cellStyle.setBorderRight(CellStyle.BORDER_THIN);
	cellStyle.setRightBorderColor(IndexedColors.BLUE.getIndex());
	cellStyle.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
	cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
	row.setRowStyle(cellStyle);


	FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
	cc.write(fileOut);
	fileOut.close();

}
}