package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelGrupoRisco {

	public XSSFWorkbook pagina(XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		//Sheet sheet = wb.createSheet("Grupo de Risco");

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = header(wb, sheet, styles);
        wb = body(wb, sheet, styles);

        return wb;
    }

	private XSSFWorkbook header(XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{


		Cell cell = null;
		Integer linha=2;
		Integer coluna=1;

		linha++;
        coluna=1;

        cell = sheet.getRow(linha).getCell(coluna++);
        sheet.setColumnWidth(coluna-1, 6000);
        cell.setCellValue("Grupo");
        cell.setCellStyle(styles.get("titulo"));

        cell = sheet.getRow(linha).getCell(coluna++);
        sheet.setColumnWidth(coluna-1, 6000);
        cell.setCellValue("Vidas");
        cell.setCellStyle(styles.get("titulo"));

        cell = sheet.getRow(linha).getCell(coluna++);
        sheet.setColumnWidth(coluna-1, 6000);
        cell.setCellValue("Exposi��o m�dia");
        cell.setCellStyle(styles.get("titulo"));

        cell = sheet.getRow(linha).getCell(coluna++);
        sheet.setColumnWidth(coluna-1, 6000);
        cell.setCellValue("% (vidas)");
        cell.setCellStyle(styles.get("titulo"));

        cell = sheet.getRow(linha).getCell(coluna++);
        sheet.setColumnWidth(coluna-1, 6000);
        cell.setCellValue("Sinistro (total)");
        cell.setCellStyle(styles.get("titulo"));

        cell = sheet.getRow(linha).getCell(coluna++);
        sheet.setColumnWidth(coluna-1, 6000);
        cell.setCellValue("Sinistro (pmpm)");
        cell.setCellStyle(styles.get("titulo"));

        cell = sheet.getRow(linha).getCell(coluna++);
        sheet.setColumnWidth(coluna-1, 6000);
        cell.setCellValue("% do sinistro");
        cell.setCellStyle(styles.get("titulo"));

        return wb;
    }

	private XSSFWorkbook body(XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Cell cell = null;
		Integer linha=2;
		Integer coluna=1;

		for (int i=1; i<=7; i++){
			coluna=1;
			//row = criaLinhaCell(linha++, sheet);

			linha++;

			for (int x=1; x<=7; x++){
				cell = sheet.getRow(linha).getCell(coluna++);
		        cell.setCellValue(x);
		        if(i % 2 == 0)
		        	cell.setCellStyle(styles.get("cell"));
		        else
		        	cell.setCellStyle(styles.get("cell2"));
			}
		}

		return wb;
	}

}