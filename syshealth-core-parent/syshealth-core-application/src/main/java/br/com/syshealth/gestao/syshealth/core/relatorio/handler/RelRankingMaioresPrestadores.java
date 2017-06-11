package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelRankingMaioresPrestadores {

	public  XSSFWorkbook pagina(Integer dataInicio, Integer dataFim, Map<Integer, List<Object>> mapSinistro, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);


        wb = body(mapSinistro.get(0), wb, sheet, styles);
        wb = bodyBasico(mapSinistro.get(1), wb, sheet, styles);
        wb = bodyIntermediario(mapSinistro.get(2), wb, sheet, styles);
        wb = bodyExecutivo(mapSinistro.get(3), wb, sheet, styles);

        return wb;
    }


	@SuppressWarnings("unused")
	private  XSSFWorkbook body(List<Object> listaSinistro, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Cell cell = null;
		Integer linha=6;
		Integer coluna=3;
		Integer ranking = 1;

		@SuppressWarnings("rawtypes")
		Iterator itSinistro = listaSinistro.iterator();
    	while(itSinistro.hasNext()){

    		coluna=1;
    		linha++;

    		Object[] sinistro = (Object[]) itSinistro.next();
    		String     prestador 	 	= sinistro[0]==null ? "" : new String(sinistro[0].toString().length()>25 ? sinistro[0].toString().substring(0,25).trim() : sinistro[0].toString().trim());
    		BigDecimal consultas 	 	= sinistro[1]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[1].toString());
    		BigDecimal prontoSocorro 	= sinistro[2]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[2].toString());
    		BigDecimal examesSimples 	= sinistro[3]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[3].toString());
    		BigDecimal examesEspeciais	= sinistro[4]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[4].toString());
    		BigDecimal internacao    	= sinistro[5]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[5].toString());
    		BigDecimal honorario  	 	= sinistro[6]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[6].toString());
    		BigDecimal terapia  	 	= sinistro[7]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[7].toString());
    		BigDecimal outros  		 	= sinistro[8]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[8].toString());
    		BigDecimal total  		 	= sinistro[9]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[9].toString());

    		cell = sheet.getRow(linha).getCell(3);
	        cell.setCellValue(prestador);

	        cell = sheet.getRow(linha).getCell(6);
	        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	        cell.setCellValue(total.doubleValue());
    	}

		return wb;
	}

	@SuppressWarnings("unused")
	private  XSSFWorkbook bodyBasico(List<Object> listaSinistro, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Cell cell = null;
		Integer linha=22;
		Integer coluna=3;
		Integer ranking = 1;

		@SuppressWarnings("rawtypes")
		Iterator itSinistro = listaSinistro.iterator();
    	while(itSinistro.hasNext()){

    		coluna=1;
    		linha++;

    		Object[] sinistro = (Object[]) itSinistro.next();
    		String     prestador 	 	= sinistro[0]==null ? "" : new String(sinistro[0].toString().length()>25 ? sinistro[0].toString().substring(0,25).trim() : sinistro[0].toString().trim());
    		BigDecimal consultas 	 	= sinistro[1]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[1].toString());
    		BigDecimal prontoSocorro 	= sinistro[2]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[2].toString());
    		BigDecimal examesSimples 	= sinistro[3]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[3].toString());
    		BigDecimal examesEspeciais	= sinistro[4]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[4].toString());
    		BigDecimal internacao    	= sinistro[5]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[5].toString());
    		BigDecimal honorario  	 	= sinistro[6]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[6].toString());
    		BigDecimal terapia  	 	= sinistro[7]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[7].toString());
    		BigDecimal outros  		 	= sinistro[8]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[8].toString());
    		BigDecimal total  		 	= sinistro[9]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[9].toString());

    		cell = sheet.getRow(linha).getCell(1);
	        cell.setCellValue(prestador);

	        cell = sheet.getRow(linha).getCell(2);
	        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	        cell.setCellValue(total.doubleValue());
    	}

		return wb;
	}

	@SuppressWarnings("unused")
	private  XSSFWorkbook bodyIntermediario(List<Object> listaSinistro, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Cell cell = null;
		Integer linha=22;
		Integer coluna=3;
		Integer ranking = 1;

		@SuppressWarnings("rawtypes")
		Iterator itSinistro = listaSinistro.iterator();
    	while(itSinistro.hasNext()){

    		coluna=1;
    		linha++;

    		Object[] sinistro = (Object[]) itSinistro.next();
    		String     prestador 	 	= sinistro[0]==null ? "" : new String(sinistro[0].toString().length()>25 ? sinistro[0].toString().substring(0,25).trim() : sinistro[0].toString().trim());
    		BigDecimal consultas 	 	= sinistro[1]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[1].toString());
    		BigDecimal prontoSocorro 	= sinistro[2]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[2].toString());
    		BigDecimal examesSimples 	= sinistro[3]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[3].toString());
    		BigDecimal examesEspeciais	= sinistro[4]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[4].toString());
    		BigDecimal internacao    	= sinistro[5]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[5].toString());
    		BigDecimal honorario  	 	= sinistro[6]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[6].toString());
    		BigDecimal terapia  	 	= sinistro[7]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[7].toString());
    		BigDecimal outros  		 	= sinistro[8]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[8].toString());
    		BigDecimal total  		 	= sinistro[9]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[9].toString());

    		cell = sheet.getRow(linha).getCell(5);
	        cell.setCellValue(prestador);

	        cell = sheet.getRow(linha).getCell(6);
	        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	        cell.setCellValue(total.doubleValue());
    	}

		return wb;
	}

	@SuppressWarnings("unused")
	private  XSSFWorkbook bodyExecutivo(List<Object> listaSinistro, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Cell cell = null;
		Integer linha=22;
		Integer coluna=1;
		Integer ranking = 1;

		@SuppressWarnings("rawtypes")
		Iterator itSinistro = listaSinistro.iterator();
    	while(itSinistro.hasNext()){

    		coluna=1;
    		linha++;

    		Object[] sinistro = (Object[]) itSinistro.next();
    		String     prestador 	 	= sinistro[0]==null ? "" : new String(sinistro[0].toString().length()>25 ? sinistro[0].toString().substring(0,25).trim() : sinistro[0].toString().trim());
    		BigDecimal consultas 	 	= sinistro[1]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[1].toString());
    		BigDecimal prontoSocorro 	= sinistro[2]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[2].toString());
    		BigDecimal examesSimples 	= sinistro[3]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[3].toString());
    		BigDecimal examesEspeciais	= sinistro[4]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[4].toString());
    		BigDecimal internacao    	= sinistro[5]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[5].toString());
    		BigDecimal honorario  	 	= sinistro[6]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[6].toString());
    		BigDecimal terapia  	 	= sinistro[7]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[7].toString());
    		BigDecimal outros  		 	= sinistro[8]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[8].toString());
    		BigDecimal total  		 	= sinistro[9]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[9].toString());

    		cell = sheet.getRow(linha).getCell(9);
	        cell.setCellValue(prestador);

	        cell = sheet.getRow(linha).getCell(10);
	        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	        cell.setCellValue(total.doubleValue());
    	}

		return wb;
	}
}