package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelUtilizacaoFaixaSinistro {

	public XSSFWorkbook pagina( Map<Integer, Integer> mapFaixa,
								Map<Integer, BigDecimal> mapFemininoPerc,
								Map<Integer, BigDecimal> mapMasculinoPerc,
								Map<Integer, Integer> mapSinistradoTotal,
								Map<Integer, BigDecimal> mapSinistroTotal,
								XSSFWorkbook wb,
								Sheet sheet, Map<String, XSSFCellStyle> styles) {

		PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = body(mapFaixa, mapFemininoPerc, mapMasculinoPerc, mapSinistradoTotal, mapSinistroTotal, wb, sheet, styles);

        return wb;
    }


	private XSSFWorkbook body(	Map<Integer, Integer> mapFaixa,
								Map<Integer, BigDecimal> mapFemininoPerc,
								Map<Integer, BigDecimal> mapMasculinoPerc,
								Map<Integer, Integer> mapSinistradoTotal,
								Map<Integer, BigDecimal> mapSinistroTotal,
								XSSFWorkbook wb, Sheet sheet,
								Map<String, XSSFCellStyle> styles) {

		Cell cell = null;
		Integer linha = 6;
		Integer col	  = 3;

	    for (Integer faixa : mapFaixa.keySet()) {


	    	//Inseri uma linha para baixo
	    	linha++;

			//Idade M�dia
			cell = sheet.getRow(linha).getCell(col++);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(mapFaixa.get(faixa).intValue());

			//% Sinistrados Feminino
			cell = sheet.getRow(linha).getCell(col++);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(mapFemininoPerc.get(faixa).doubleValue());

			//% Sinistrados Masculino
			cell = sheet.getRow(linha).getCell(col++);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(mapMasculinoPerc.get(faixa).doubleValue());

			//Sinistrados
			cell = sheet.getRow(linha).getCell(col++);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(mapSinistradoTotal.get(faixa).intValue());

			//% Sinistrados
			cell = sheet.getRow(linha).getCell(col++);
			//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			//cell.setCellValue(mapSinistradoTotal.get(faixa).intValue());

			//Sinistro Total
			cell = sheet.getRow(linha).getCell(col++);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(mapSinistroTotal.get(faixa).doubleValue());

			//% Sinistro
			cell = sheet.getRow(linha).getCell(col++);
			//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			//cell.setCellValue(mapSinistradoTotal.get(faixa).intValue());

			//Custo Por Sinistrado
			cell = sheet.getRow(linha).getCell(col++);
			//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			//cell.setCellValue(mapSinistradoTotal.get(faixa).intValue());

			col	  = 3;
		}
		return wb;
	}
}