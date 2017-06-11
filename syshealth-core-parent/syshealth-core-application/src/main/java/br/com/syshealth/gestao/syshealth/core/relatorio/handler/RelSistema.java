package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelSistema {
	
    public Workbook pagina(XSSFWorkbook wb) throws IOException, NullPointerException{
       
        Map<String, XSSFCellStyle> styles = RelEstiloExcel.createStyles(wb);

        Sheet sheet = wb.createSheet("Sistema");
        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);

        //title row
        Row titleRow = sheet.createRow(0);
        titleRow.setHeightInPoints(45);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Sistema");
        titleCell.setCellStyle(styles.get("title"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$L$1"));

        //header row
        //Row headerRow = sheet.createRow(1);
        //headerRow.setHeightInPoints(40);
        Cell headerCell;
        
        for (int i = 1; i < 21; i++) {
        	Row headerRow = sheet.createRow(i);
        	headerRow.setHeightInPoints(40);
        	for (int j = 0; j < 13; j++) {
        		
	            headerCell = headerRow.createCell(j);
	            headerCell.setCellStyle(styles.get("header"));
        	}
        }
        
        //for (int i = 0; i < titles.length; i++) {
        //    headerCell = headerRow.createCell(i);
        //    headerCell.setCellValue(titles[i]);
        //    //headerCell.setCellStyle(styles.get("header"));
        //}
        
        /**
        int rownum = 2;
        for (int i = 0; i < 10; i++) {
            Row row = sheet.createRow(rownum++);
            for (int j = 0; j < titles.length; j++) {
                Cell cell = row.createCell(j);
                if(j == 9){
                    //the 10th cell contains sum over week days, e.g. SUM(C3:I3)
                    String ref = "C" +rownum+ ":I" + rownum;
                    cell.setCellFormula("SUM("+ref+")");
                    cell.setCellStyle(styles.get("formula"));
                } else if (j == 11){
                    cell.setCellFormula("J" +rownum+ "-K" + rownum);
                    cell.setCellStyle(styles.get("formula"));
                } else {
                    cell.setCellStyle(styles.get("cell"));
                }
            }
        }
        
        //set sample data
        for (int i = 0; i < sample_data.length; i++) {
        	Integer coluna = 0;
            Row row = sheet.getRow(2 + i);
            for (int j = 0; j < sample_data[i].length; j++) {
                if(sample_data[i][j] == null) continue;

                if (((sample_data[i][j].toString().length()+2)*256) >=  sheet.getColumnWidth(coluna)){
            		sheet.setColumnWidth(coluna, (sample_data[i][j].toString().length()+2)*256);  //6 characters wide
            	}
                
                if(sample_data[i][j] instanceof String) {
                    row.getCell(j).setCellValue((String)sample_data[i][j]);
                } else {
                    row.getCell(j).setCellValue((Double)sample_data[i][j]);
                }
                coluna++;
            }
        }*/
        
        return wb;
    }
}