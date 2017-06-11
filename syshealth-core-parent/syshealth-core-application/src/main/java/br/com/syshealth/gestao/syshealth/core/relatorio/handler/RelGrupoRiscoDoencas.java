package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelGrupoRiscoDoencas {

	public XSSFWorkbook pagina(Map<String, Integer> saudavel, Map<String, Integer> cronivo, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) {

		//Sheet sheet = wb.createSheet("Evolu��o 5 maiores casos");

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = body(saudavel, cronivo, wb, sheet, styles);

        return wb;
    }

	private XSSFWorkbook body(Map<String, Integer> saudavel, Map<String, Integer> cronivo, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) {

		Cell cell = null;
		//Integer totalSaudavel = 0;
		Integer totalCronico = 0;

		/*for (String codSaudavel : saudavel.keySet()){

			if (codSaudavel.equals("1")){//Diab�ticos
				cell = sheet.getRow(14).getCell(2);
			}else if (codSaudavel.equals("2")){//Hipertensos
				cell = sheet.getRow(18).getCell(2);
			}else if (codSaudavel.equals("3")){//Dpoc
				cell = sheet.getRow(22).getCell(2);
			}else if (codSaudavel.equals("4")){//Asma
				cell = sheet.getRow(26).getCell(2);
			}

			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        	cell.setCellValue(saudavel.get(codSaudavel));

        	totalSaudavel += saudavel.get(codSaudavel).intValue();

	    }*/

		for (String codCronivo : cronivo.keySet()){

			if (codCronivo.equals("1")){//Diab�ticos
				cell = sheet.getRow(14).getCell(3);
			}else if (codCronivo.equals("2")){//Hipertensos
				cell = sheet.getRow(18).getCell(3);
			}else if (codCronivo.equals("3")){//Dpoc
				cell = sheet.getRow(22).getCell(3);
			}else if (codCronivo.equals("4")){//Asma
				cell = sheet.getRow(26).getCell(3);
			}

			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        	cell.setCellValue(saudavel.get(codCronivo));

        	totalCronico += cronivo.get(codCronivo).intValue();
	    }

		return wb;
	}
}