

package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelEstiloExcel {


	public static Map<String, XSSFCellStyle> createStyles(XSSFWorkbook wb){

		Map<String, XSSFCellStyle> styles = new HashMap<String, XSSFCellStyle>();
        XSSFCellStyle style;

        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short)16);
        titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        titleFont.setColor(IndexedColors.WHITE.getIndex());

        style = wb.createCellStyle();
        style.setWrapText(true);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(31,73,125)));
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        styles.put("titulo", style);

        style = wb.createCellStyle();
        style.setWrapText(true);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        styles.put("logo", style);

        Font cellFont = wb.createFont();
        cellFont.setFontHeightInPoints((short)14);
        cellFont.setBoldweight(Font.BOLDWEIGHT_NORMAL);
        cellFont.setColor(IndexedColors.BLACK.getIndex());

        style = wb.createCellStyle();
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setFont(cellFont);
        styles.put("cellPrestador", style);

        style = wb.createCellStyle();
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(242,242,242)));
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(cellFont);
        styles.put("cellPrestador2", style);

        style = wb.createCellStyle();
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFont(cellFont);
        styles.put("cell", style);

        style = wb.createCellStyle();
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(242,242,242)));
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(cellFont);
        styles.put("cell2", style);

        style = wb.createCellStyle();
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFont(cellFont);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00%"));
        styles.put("cell%", style);

        style = wb.createCellStyle();
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(242,242,242)));
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(cellFont);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00%"));
        styles.put("cell2%", style);

        style = wb.createCellStyle();
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFont(cellFont);
        style.setDataFormat(wb.createDataFormat().getFormat("##,##0"));
        styles.put("cellInt", style);

        style = wb.createCellStyle();
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(242,242,242)));
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(cellFont);
        style.setDataFormat(wb.createDataFormat().getFormat("##,##0"));
        styles.put("cellInt2", style);

        style = wb.createCellStyle();
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFont(cellFont);
        style.setDataFormat(wb.createDataFormat().getFormat("##,##0.00"));
        styles.put("cell$", style);

        style = wb.createCellStyle();
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(242,242,242)));
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(cellFont);
        style.setDataFormat(wb.createDataFormat().getFormat("##,##0.00"));
        styles.put("cell$2", style);

        style = wb.createCellStyle();
        style.setWrapText(true);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(31,73,125)));
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        styles.put("footer", style);

        style = wb.createCellStyle();
        style.setWrapText(true);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(31,73,125)));
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00%"));
        styles.put("footer%", style);

        style = wb.createCellStyle();
        style.setWrapText(true);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(31,73,125)));
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        style.setDataFormat(wb.createDataFormat().getFormat("##,##0"));
        styles.put("footerInt", style);

        style = wb.createCellStyle();
        style.setWrapText(true);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(31,73,125)));
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        style.setDataFormat(wb.createDataFormat().getFormat("##,##0.00"));
        styles.put("footer$", style);

        XSSFCellStyle styleBorderTopRight = wb.createCellStyle();
        styleBorderTopRight.setBorderRight(CellStyle.BORDER_THIN);
        styleBorderTopRight.setRightBorderColor(new XSSFColor(new java.awt.Color(217,217,217)));
        styleBorderTopRight.setBorderTop(CellStyle.BORDER_THIN);
        styleBorderTopRight.setTopBorderColor(new XSSFColor(new java.awt.Color(217,217,217)));
        styles.put("borderTopRight", styleBorderTopRight);

        XSSFCellStyle styleBorderBottomLeft = wb.createCellStyle();
        styleBorderTopRight.setBorderLeft(CellStyle.BORDER_THIN);
        styleBorderTopRight.setRightBorderColor(new XSSFColor(new java.awt.Color(217,217,217)));
        styleBorderTopRight.setBorderBottom(CellStyle.BORDER_THIN);
        styleBorderTopRight.setTopBorderColor(new XSSFColor(new java.awt.Color(217,217,217)));
        styles.put("borderBottomLeft", styleBorderBottomLeft);

        styleBorderTopRight.setTopBorderColor(new XSSFColor(new java.awt.Color(217,217,217)));
        XSSFCellStyle styleBorderRight = wb.createCellStyle();
        styleBorderRight.setBorderRight(CellStyle.BORDER_THIN);
        styleBorderRight.setRightBorderColor(new XSSFColor(new java.awt.Color(217,217,217)));
        styles.put("borderRight", styleBorderRight);

        XSSFCellStyle styleBorderTop = wb.createCellStyle();
        styleBorderTop.setBorderTop(CellStyle.BORDER_THIN);
        styleBorderTop.setTopBorderColor(new XSSFColor(new java.awt.Color(217,217,217)));
        styles.put("borderTop", styleBorderTopRight);

        return styles;
    }

	private static  XSSFCellStyle createBorderedStyle(XSSFWorkbook wb){
		XSSFCellStyle style = wb.createCellStyle();

		style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(new XSSFColor(new java.awt.Color(217,217,217)));

		style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(new XSSFColor(new java.awt.Color(217,217,217)));

        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(new XSSFColor(new java.awt.Color(217,217,217)));

        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(new XSSFColor(new java.awt.Color(217,217,217)));

        return style;
    }
}