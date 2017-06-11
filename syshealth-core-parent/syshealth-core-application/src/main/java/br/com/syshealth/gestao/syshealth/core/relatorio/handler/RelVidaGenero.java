package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelVidaGenero {

	private Integer inicioLinha=36;

	public XSSFWorkbook pagina(Map<String, Map<String, Integer>> faixaEtaria, Map<String, Map<String, Integer>> faixaEtariaTitular, Integer dataFim, XSSFWorkbook wb,Sheet sheet,  Map<String, XSSFCellStyle> styles) throws Exception{

		PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = body(faixaEtaria, faixaEtariaTitular, wb, sheet, styles);

        return wb;
    }


	private XSSFWorkbook body(Map<String, Map<String, Integer>> faixaEtaria, Map<String, Map<String, Integer>> faixaEtariaTitular, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Cell cell = null;
		Integer linha=inicioLinha;

	    for (String faixa : faixaEtaria.keySet() ) {

	    	Map<String, Integer> genero = faixaEtaria.get(faixa);

	    	linha++;

        	/*cell = sheet.getRow(linha).getCell(2);
			cell.setCellValue(faixa);
			cell.setCellType(Cell.CELL_TYPE_STRING);*/

			//Feminino
			cell = sheet.getRow(linha).getCell(3);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(genero.get("2").intValue());

			//Masculino
			cell = sheet.getRow(linha).getCell(5);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(genero.get("1").intValue());

		}

	    linha=51;
	    for (String faixa : faixaEtariaTitular.keySet() ) {

	    	Map<String, Integer> genero = faixaEtariaTitular.get(faixa);

	    	linha++;

        	/*cell = sheet.getRow(linha).getCell(20);
			cell.setCellValue(faixa);
			cell.setCellType(Cell.CELL_TYPE_STRING);*/

			//Feminino
			cell = sheet.getRow(linha).getCell(21);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(genero.get("2").intValue());

			//Masculino
			cell = sheet.getRow(linha).getCell(23);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(genero.get("1").intValue());

		}
		return wb;
	}
}