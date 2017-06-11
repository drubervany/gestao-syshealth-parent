package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelGrupoRiscoRessonanciasMagneticasColuna {

	public XSSFWorkbook pagina(Integer masculino, Integer feminino, Integer titular, Integer dependente, BigDecimal valor, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) {
		//Sheet sheet = wb.createSheet("Evolu��o 5 maiores casos");

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = body(masculino, feminino, titular, dependente, valor, wb, sheet, styles);

        return wb;
    }

	private XSSFWorkbook body(Integer masculino, Integer feminino, Integer totalVidasTitular, Integer totalVidasDependente, BigDecimal valor, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) {

		Cell cell = null;

		cell = sheet.getRow(1).getCell(18);
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(masculino);

		cell = sheet.getRow(2).getCell(18);
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(feminino);

		cell = sheet.getRow(5).getCell(18);
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(totalVidasTitular);

		cell = sheet.getRow(6).getCell(18);
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(totalVidasDependente);

		cell = sheet.getRow(9).getCell(18);
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(valor.doubleValue());

		return wb;
	}
}