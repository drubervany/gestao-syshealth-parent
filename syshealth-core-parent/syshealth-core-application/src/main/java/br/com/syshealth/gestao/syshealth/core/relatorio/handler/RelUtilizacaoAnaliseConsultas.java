package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelUtilizacaoAnaliseConsultas {

	public XSSFWorkbook pagina(Map<Integer, BigDecimal[]>    sinistrosFrequencia,
							   Map<Integer, BigDecimal[]> sinistrosValores,
			   				   XSSFWorkbook wb,
			   				   Sheet sheet,
			   				   Map<String, XSSFCellStyle> styles) {


		PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = bodyValores(sinistrosValores, wb, sheet, styles);
        wb = bodyFrequencia(sinistrosFrequencia, wb, sheet, styles);

        return wb;
    }


	public XSSFWorkbook bodyFrequencia(Map<Integer, BigDecimal[]> sinistros,
										 XSSFWorkbook wb,
										 Sheet sheet,
										 Map<String, XSSFCellStyle> styles) {


		Cell cell = null;
		int lin = 7;

    	for (Integer codigo : sinistros.keySet()) {

	    	BigDecimal[] fequencia = sinistros.get(codigo);

			//Eletivas
			cell = sheet.getRow(lin).getCell(4);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(fequencia[0].intValue());

			//Pronto Socorro
			cell = sheet.getRow((lin+1)).getCell(4);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(fequencia[1].intValue());

			lin =  lin + 7;
    	}

		return wb;
	}

	public XSSFWorkbook bodyValores(Map<Integer, BigDecimal[]> sinistros,
									 XSSFWorkbook wb,
									 Sheet sheet,
									 Map<String, XSSFCellStyle> styles) {


		Cell cell = null;
		int lin = 7;
    	for (Integer codigo : sinistros.keySet()) {

	    	BigDecimal[] valores = sinistros.get(codigo);

			//Eletivas
			cell = sheet.getRow(lin).getCell(7);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(valores[0].doubleValue());

			//Pronto Socorro
			cell = sheet.getRow((lin+1)).getCell(7);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(valores[1].doubleValue());


			lin =  lin + 7;
    	}

		return wb;
	}






}