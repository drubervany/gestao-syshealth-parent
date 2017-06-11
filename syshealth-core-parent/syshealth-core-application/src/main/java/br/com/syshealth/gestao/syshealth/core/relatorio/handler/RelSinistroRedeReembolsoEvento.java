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

public class RelSinistroRedeReembolsoEvento {


	public  XSSFWorkbook pagina(Integer dataInicio, Integer dataFim, List<Object> listaSinistro, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = body(listaSinistro, wb, sheet, styles);

        return wb;
    }

	@SuppressWarnings("rawtypes")
	private  XSSFWorkbook body(List<Object> listaSinistro, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Cell cell = null;
		Integer linha = 7;

		BigDecimal internacaoRede 			= BigDecimal.ZERO;
		BigDecimal examesRede				= BigDecimal.ZERO;
		BigDecimal consultasRede			= BigDecimal.ZERO;
		BigDecimal ambulatorioTerapiasRede	= BigDecimal.ZERO;

		BigDecimal internacaoReem 			= BigDecimal.ZERO;
		BigDecimal examesReem				= BigDecimal.ZERO;
		BigDecimal consultasReem			= BigDecimal.ZERO;
		BigDecimal ambulatorioTerapiasReem	= BigDecimal.ZERO;


		Iterator itSinistro = listaSinistro.iterator();
    	while(itSinistro.hasNext()){

    		Object[] sinistro = (Object[]) itSinistro.next();
    		String     evento 	 	 = sinistro[0]==null ? "" : sinistro[0].toString();
    		BigDecimal rede 	 	 = sinistro[1]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[1].toString());
    		BigDecimal reembolso 	 = sinistro[2]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[2].toString());

    		if (evento.equals("1")){
    			internacaoRede=internacaoRede.add(rede);
    			internacaoReem=internacaoReem.add(reembolso);
    		}else if (evento.equals("2")){
    			examesRede=examesRede.add(rede);
    			examesReem=examesReem.add(reembolso);
    		}else if (evento.equals("3")){
    			consultasRede=consultasRede.add(rede);
    			consultasReem=consultasReem.add(reembolso);
    		}else if (evento.equals("4") || evento.equals("5")){
    			ambulatorioTerapiasRede=ambulatorioTerapiasRede.add(rede);
    			ambulatorioTerapiasReem=ambulatorioTerapiasReem.add(reembolso);
    		}
    	}

		linha = 7;

        cell = sheet.getRow(linha).getCell(3);
        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        cell.setCellValue(internacaoRede.doubleValue());

        cell = sheet.getRow(linha++).getCell(4);
        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        cell.setCellValue(internacaoReem.doubleValue());

        cell = sheet.getRow(linha).getCell(3);
        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        cell.setCellValue(examesRede.doubleValue());

        cell = sheet.getRow(linha++).getCell(4);
        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        cell.setCellValue(examesReem.doubleValue());

        cell = sheet.getRow(linha).getCell(3);
        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        cell.setCellValue(consultasRede.doubleValue());

        cell = sheet.getRow(linha++).getCell(4);
        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        cell.setCellValue(consultasReem.doubleValue());

        cell = sheet.getRow(linha).getCell(3);
        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        cell.setCellValue(ambulatorioTerapiasRede.doubleValue());

        cell = sheet.getRow(linha++).getCell(4);
        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        cell.setCellValue(ambulatorioTerapiasReem.doubleValue());

		return wb;
	}
}