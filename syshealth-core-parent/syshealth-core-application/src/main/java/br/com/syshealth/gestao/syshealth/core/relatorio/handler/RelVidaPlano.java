package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelVidaPlano {

	private Integer inicioLinha=4;

	public XSSFWorkbook pagina(Map<String, Map<String, Integer>> faixaEtaria, Integer dataFim, XSSFWorkbook wb,Sheet sheet,  Map<String, XSSFCellStyle> styles) throws Exception{

		PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = header(dataFim, wb, sheet, styles);
        wb = body(faixaEtaria, wb, sheet, styles);



        return wb;
    }

	private XSSFWorkbook header(Integer dataFim, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		//cell = sheet.getRow(2).getCell(1);
		//cell.setCellValue("Ativos: " + StringUtils.converteCompetenciaEmDataAbreviada(dataFim));

        return wb;

    }

	private XSSFWorkbook body(Map<String, Map<String, Integer>> faixaEtaria, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Cell cell = null;
		Integer linha = inicioLinha;

	    for (String faixa : faixaEtaria.keySet() ) {
	    	Integer col=1;

	    	Map<String, Integer> plano = faixaEtaria.get(faixa);

	    	linha++;

        	cell = sheet.getRow(linha).getCell(col++);//Celuna na linha
			cell.setCellValue(faixa);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			if(linha%2==0)
				cell.setCellStyle(styles.get("cell"));
			else
				cell.setCellStyle(styles.get("cell2"));


			//Basico
			cell = sheet.getRow(linha).getCell(col++);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(plano.get("1").intValue());
			if(linha%2==0)
				cell.setCellStyle(styles.get("cellInt"));
			else
				cell.setCellStyle(styles.get("cellInt2"));

			//Master
			cell = sheet.getRow(linha).getCell(col++);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(plano.get("2").intValue());
			if(linha%2==0)
				cell.setCellStyle(styles.get("cellInt"));
			else
				cell.setCellStyle(styles.get("cellInt2"));

			//Especial
			cell = sheet.getRow(linha).getCell(col++);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(plano.get("3").intValue());
			if(linha%2==0)
				cell.setCellStyle(styles.get("cellInt"));
			else
				cell.setCellStyle(styles.get("cellInt2"));


			//String formulaSoma = "SUM(D"+(linha)+":F"+(linha)+")";

			cell = sheet.getRow(linha).getCell(col++);
			//cell.setCellFormula(formulaSoma);
			cell.setCellType(Cell.CELL_TYPE_FORMULA);
			if(linha%2==0)
				cell.setCellStyle(styles.get("cellInt"));
			else
				cell.setCellStyle(styles.get("cellInt2"));


			//String formulaPerc = "H"+linha.toString()+"/$H$"+(faixaEtaria.size()+inicioLinha+1);

			cell = sheet.getRow(linha).getCell(col++);
			//cell.setCellFormula(formulaPerc);
			cell.setCellType(Cell.CELL_TYPE_FORMULA);
			if(linha % 2 == 0)
	        	cell.setCellStyle(styles.get("cell%"));
	        else
	        	cell.setCellStyle(styles.get("cell2%"));
        }
		return wb;
	}
}