package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelSinistroFaixaEtaria {

	private Integer inicioLinha=6;

	public XSSFWorkbook pagina(Map<String, Map<Integer, BigDecimal>> faixaEtaria, Integer dataFim, XSSFWorkbook wb,Sheet sheet,  Map<String, XSSFCellStyle> styles) throws Exception{

		PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);


        wb = body(faixaEtaria, wb, sheet, styles);

        return wb;
    }


	private XSSFWorkbook body (Map<String, Map<Integer, BigDecimal>> faixaEtaria, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Cell cell = null;
		Integer linha=inicioLinha;

	    for (String faixa : faixaEtaria.keySet() ) {

	    	 Map<Integer, BigDecimal> vidaValores = faixaEtaria.get(faixa);

	    	linha++;
	    	for (Integer vida : vidaValores.keySet() ) {

				//Total
				cell = sheet.getRow(linha).getCell(3);
				//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				//cell.setCellValue(vida);

				//Sinistro
				cell = sheet.getRow(linha).getCell(5);
				cell.setCellType(Cell.CELL_TYPE_NUMERIC);
				cell.setCellValue(vidaValores.get(vida).doubleValue());
	    	}
		}
		return wb;
	}
}