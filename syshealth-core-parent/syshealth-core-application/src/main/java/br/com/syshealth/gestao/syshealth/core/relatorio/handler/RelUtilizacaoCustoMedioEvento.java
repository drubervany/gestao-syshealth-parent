package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelUtilizacaoCustoMedioEvento {

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
		Integer linha = 34;


    	for (Integer codigo : sinistros.keySet()) {

    		//Inseri uma linha para baixo
	    	linha++;

	    	BigDecimal[] fequencia = sinistros.get(codigo);

			//Internacao
			cell = sheet.getRow(linha).getCell(8);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(fequencia[0].intValue());

			//Exames
			cell = sheet.getRow(linha).getCell(9);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(fequencia[1].intValue());

			//Consultas
			cell = sheet.getRow(linha).getCell(10);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(fequencia[2].intValue());
    	}

		return wb;
	}

	public XSSFWorkbook bodyValores(Map<Integer, BigDecimal[]> sinistros,
									 XSSFWorkbook wb,
									 Sheet sheet,
									 Map<String, XSSFCellStyle> styles) {


		Cell cell = null;
		Integer linha = 29;


		for (Integer codigo : sinistros.keySet()) {

			//Inseri uma linha para baixo
			linha++;

			BigDecimal[] valor = sinistros.get(codigo);

			//Internacao
			cell = sheet.getRow(linha).getCell(8);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(valor[0].doubleValue());

			//Exames
			cell = sheet.getRow(linha).getCell(9);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(valor[1].doubleValue());

			//Consultas
			cell = sheet.getRow(linha).getCell(10);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(valor[2].doubleValue());
		}

		return wb;
	}

}