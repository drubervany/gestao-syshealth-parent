package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelVidaTutilaridade {

	public XSSFWorkbook pagina(Map<String, Integer> vidas, Map<String, Integer> vidasAcomodacao, Map<String, Map<String, Integer>> faixaEtaria, Integer dataFim, XSSFWorkbook wb,Sheet sheet,  Map<String, XSSFCellStyle> styles) throws Exception{

		PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = bodyElegibilidade(vidas, wb, sheet, styles);
        wb = bodyAcomodacao(vidasAcomodacao, wb, sheet, styles);
        wb = bodyFaixaAcomodacao(faixaEtaria, wb, sheet, styles);

        return wb;
    }

	private XSSFWorkbook bodyElegibilidade(Map<String, Integer> vidas, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Cell cell = null;
		Integer linha = 6;
		Integer col	  = 4;

	    for (Integer i=1;i<=5;i++) {

	    	String campo = i.toString();

	    	//Inseri uma linha para baixo
	    	linha++;

			//Beneficiario
			cell = sheet.getRow(linha).getCell(col);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(vidas.get(campo).intValue());

		}
		return wb;
	}

	private XSSFWorkbook bodyAcomodacao( Map<String, Integer> vidas, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Cell cell = null;
		Integer linha = 6;
		Integer col	  = 10;

	    for (Integer i=1;i<=3;i++) {

	    	String campo = i.toString();

	    	//Inseri uma linha para baixo
	    	linha++;

			//Beneficiario
			cell = sheet.getRow(linha).getCell(col);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(vidas.get(campo).intValue());

		}
		return wb;
	}

	private XSSFWorkbook bodyFaixaAcomodacao(Map<String, Map<String, Integer>> faixaEtaria, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Cell cell = null;
		Integer linha = 16;
		Integer colBasico = 3;
		Integer colintermediario = 6;
		Integer colExecutivo = 9;

		 for (String faixa : faixaEtaria.keySet() ) {

		    	Map<String, Integer> acomodacao = faixaEtaria.get(faixa);

	        	//Inseri uma linha para baixo
		    	linha++;

	        	cell = sheet.getRow(linha).getCell(colBasico);
				cell.setCellValue(faixa);
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell.setCellValue(acomodacao.get("1").intValue());

				cell = sheet.getRow(linha).getCell(colintermediario);
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell.setCellValue(acomodacao.get("2").intValue());

				cell = sheet.getRow(linha).getCell(colExecutivo);
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell.setCellValue(acomodacao.get("3").intValue());

		 }
		return wb;
	}
}