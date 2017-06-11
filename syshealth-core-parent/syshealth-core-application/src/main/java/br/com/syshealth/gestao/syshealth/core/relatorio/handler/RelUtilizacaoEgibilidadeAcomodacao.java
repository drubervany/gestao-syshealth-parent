package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelUtilizacaoEgibilidadeAcomodacao {

	public XSSFWorkbook pagina(Map<Integer, Map<BigDecimal, BigDecimal>> treeMapElegibilidade,
			   				   Map<Integer, Map<BigDecimal, BigDecimal>> treeMapAcomodacao,
			   				   XSSFWorkbook wb,
			   				   Sheet sheet,
			   				   Map<String, XSSFCellStyle> styles) {


		PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = body(treeMapElegibilidade, treeMapAcomodacao, wb, sheet, styles);

        return wb;
    }


	public XSSFWorkbook body(Map<Integer, Map<BigDecimal, BigDecimal>> treeMapElegibilidade,
							 Map<Integer, Map<BigDecimal, BigDecimal>> treeMapAcomodacao,
							 XSSFWorkbook wb,
							 Sheet sheet,
							 Map<String, XSSFCellStyle> styles) {


		Cell cell = null;
		Integer linha = 12;

	    for (Integer mapElegibilidade : treeMapElegibilidade.keySet()) {

	    	Map<BigDecimal, BigDecimal> mapSinistroElegibilidade = treeMapElegibilidade.get(mapElegibilidade);

	    	//Inseri uma linha para baixo
	    	linha++;

	    	for (BigDecimal elegibilidade : mapSinistroElegibilidade.keySet()) {


				//Idade M�dia
				cell = sheet.getRow(linha).getCell(2);
				//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				//cell.setCellValue(elegibilidade.intValue());

				//Sinistro
				cell = sheet.getRow(linha).getCell(4);
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell.setCellValue(mapSinistroElegibilidade.get(elegibilidade).doubleValue());
	    	}
		}


	    linha = 12;
	    for (Integer mapAcomodacao : treeMapAcomodacao.keySet()) {


	    	Map<BigDecimal, BigDecimal> mapSinistroAcomodacao = treeMapAcomodacao.get(mapAcomodacao);

	    	//Inseri uma linha para baixo
	    	linha++;

	    	for (BigDecimal acomodacao : mapSinistroAcomodacao.keySet()) {


				//Idade M�dia
				cell = sheet.getRow(linha).getCell(9);
				//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				//cell.setCellValue(acomodacao.intValue());

				//Sinistro
				cell = sheet.getRow(linha).getCell(11);
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell.setCellValue(mapSinistroAcomodacao.get(acomodacao).doubleValue());
	    	}
		}
		return wb;
	}
}