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

public class RelSinistroGrupoConsolidado {

	private  Integer linhaInicio=8;

	public XSSFWorkbook pagina(Integer dataInicio, Integer dataFim, List<Object>listaSinistro, List<Object>listaSinistroQtde	, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = header(dataInicio, dataFim, wb, sheet, styles);
        wb = body(listaSinistro, listaSinistroQtde, wb, sheet, styles);

        return wb;
    }

	private  XSSFWorkbook header(Integer dataInicio, Integer dataFim, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{


        //cell = sheet.getRow(2).getCell(1);
        //cell.setCellValue("Periodo: " + StringUtils.converteCompetenciaEmDataAbreviada(dataInicio) + " � " + StringUtils.converteCompetenciaEmDataAbreviada(dataFim));


        return wb;
    }

	@SuppressWarnings("rawtypes")
	private  XSSFWorkbook body(List<Object> listaSinistro, List<Object> listaSinistroQtde, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Cell cell = null;
		Integer linha=linhaInicio;
		Integer coluna=1;


		Iterator itSinistro = listaSinistro.iterator();
    	while(itSinistro.hasNext()){

    		coluna=3;
    		linha = linhaInicio;

    		Object[] sinistro = (Object[]) itSinistro.next();
    		BigDecimal consultas 	 	= sinistro[1]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[1].toString());
    		BigDecimal prontoSocorro 	= sinistro[2]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[2].toString());
    		BigDecimal examesSimples 	= sinistro[3]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[3].toString());
    		BigDecimal examesEspeciais	= sinistro[4]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[4].toString());
    		BigDecimal internacao    	= sinistro[5]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[5].toString());
    		BigDecimal honorario  	 	= sinistro[6]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[6].toString());
    		BigDecimal terapia  	 	= sinistro[7]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[7].toString());
    		BigDecimal outros  		 	= sinistro[8]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[8].toString());
    		@SuppressWarnings("unused")
			BigDecimal total  		 	= sinistro[9]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[9].toString());


	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(consultas.doubleValue());
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cell$"));
	        else
	        	cell.setCellStyle(styles.get("cell$2"));
	        outrasColunas(sheet, linha, styles);

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(prontoSocorro.doubleValue());
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cell$"));
	        else
	        	cell.setCellStyle(styles.get("cell$2"));
	        outrasColunas(sheet, linha, styles);

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(examesSimples.doubleValue());
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cell$"));
	        else
	        	cell.setCellStyle(styles.get("cell$2"));
	        outrasColunas(sheet, linha, styles);

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(examesEspeciais.doubleValue());
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cell$"));
	        else
	        	cell.setCellStyle(styles.get("cell$2"));
	        outrasColunas(sheet, linha, styles);

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(internacao.doubleValue());
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cell$"));
	        else
	        	cell.setCellStyle(styles.get("cell$2"));
	        outrasColunas(sheet, linha, styles);

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(honorario.doubleValue());
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cell$"));
	        else
	        	cell.setCellStyle(styles.get("cell$2"));
	        outrasColunas(sheet, linha, styles);

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(terapia.doubleValue());
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cell$"));
	        else
	        	cell.setCellStyle(styles.get("cell$2"));
	        outrasColunas(sheet, linha, styles);

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(outros.doubleValue());
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cell$"));
	        else
	        	cell.setCellStyle(styles.get("cell$2"));
	        outrasColunas(sheet, linha, styles);

    	}

    	Iterator itSinistroQtde = listaSinistroQtde.iterator();
    	while(itSinistroQtde.hasNext()){

    		coluna=2;
    		linha = linhaInicio;

    		Object[] sinistro = (Object[]) itSinistroQtde.next();
    		Integer consultas 	 	= sinistro[1]==null ? new Integer(0) : new Integer(sinistro[1].toString());
    		Integer prontoSocorro 	= sinistro[2]==null ? new Integer(0) : new Integer(sinistro[2].toString());
    		Integer examesSimples 	= sinistro[3]==null ? new Integer(0) : new Integer(sinistro[3].toString());
    		Integer examesEspeciais	= sinistro[4]==null ? new Integer(0) : new Integer(sinistro[4].toString());
    		Integer internacao    	= sinistro[5]==null ? new Integer(0) : new Integer(sinistro[5].toString());
    		Integer honorario  	 	= sinistro[6]==null ? new Integer(0) : new Integer(sinistro[6].toString());
    		Integer terapia  	 	= sinistro[7]==null ? new Integer(0) : new Integer(sinistro[7].toString());
    		Integer outros  		= sinistro[8]==null ? new Integer(0) : new Integer(sinistro[8].toString());

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(consultas);
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cellInt"));
	        else
	        	cell.setCellStyle(styles.get("cellInt2"));


	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(prontoSocorro);
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cellInt"));
	        else
	        	cell.setCellStyle(styles.get("cellInt2"));

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(examesSimples);
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cellInt"));
	        else
	        	cell.setCellStyle(styles.get("cellInt2"));

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(examesEspeciais);
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cellInt"));
	        else
	        	cell.setCellStyle(styles.get("cellInt2"));

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(internacao);
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cellInt"));
	        else
	        	cell.setCellStyle(styles.get("cellInt2"));

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(honorario);
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cellInt"));
	        else
	        	cell.setCellStyle(styles.get("cellInt2"));

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(terapia);
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cellInt"));
	        else
	        	cell.setCellStyle(styles.get("cellInt2"));

	        cell = sheet.getRow(linha++).getCell(coluna);
	        cell.setCellValue(outros);
	        if(linha %2 == 0)
	        	cell.setCellStyle(styles.get("cellInt"));
	        else
	        	cell.setCellStyle(styles.get("cellInt2"));
    	}

		return wb;
	}

	private void outrasColunas(Sheet sheet, Integer linha, Map<String, XSSFCellStyle> styles){

		Cell cell = null;
        /**********************************************/
        /*Outros Colunas*/
        cell = sheet.getRow(linha-1).getCell(1);
        if(linha %2 == 0)
        	cell.setCellStyle(styles.get("cell"));
        else
        	cell.setCellStyle(styles.get("cell2"));


        cell = sheet.getRow(linha-1).getCell(4);
        if(linha %2 == 0)
        	cell.setCellStyle(styles.get("cell$"));
        else
        	cell.setCellStyle(styles.get("cell$2"));


        cell = sheet.getRow(linha-1).getCell(5);
        if(linha %2 == 0)
        	cell.setCellStyle(styles.get("cell$"));
        else
        	cell.setCellStyle(styles.get("cell$2"));

        /**********************************************/
	}

}