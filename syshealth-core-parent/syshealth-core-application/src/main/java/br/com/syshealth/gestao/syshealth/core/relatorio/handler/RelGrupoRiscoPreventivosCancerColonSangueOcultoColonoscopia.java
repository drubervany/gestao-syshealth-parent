package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelGrupoRiscoPreventivosCancerColonSangueOcultoColonoscopia {

	public XSSFWorkbook pagina(Integer total, Integer totalVidasTitular, Integer totalVidasDependente, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) {
		//Sheet sheet = wb.createSheet("Evolu��o 5 maiores casos");

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = body(total, totalVidasTitular, totalVidasDependente, wb, sheet, styles);

        return wb;
    }

	private XSSFWorkbook body(Integer total, Integer totalVidasTitular, Integer totalVidasDependente, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) {

		Cell cell = null;

		cell = sheet.getRow(6).getCell(19);
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(total);

		cell = sheet.getRow(8).getCell(19);
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(totalVidasTitular);

		cell = sheet.getRow(9).getCell(19);
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(totalVidasDependente);

		return wb;
	}
}