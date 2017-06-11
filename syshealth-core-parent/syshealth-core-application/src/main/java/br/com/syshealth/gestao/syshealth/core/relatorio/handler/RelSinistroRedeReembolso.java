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

import br.com.syshealth.commons.utils.StringUtils;

public class RelSinistroRedeReembolso {

    private Integer linhaInicio = 6;

    private Integer colunaInicio = 1;

    public XSSFWorkbook pagina(Integer dataInicio, Integer dataFim, List<Object> listaSinistro, XSSFWorkbook wb, Sheet sheet,
            Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException {

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = header(dataInicio, dataFim, wb, sheet, styles);
        wb = body(listaSinistro, wb, sheet, styles);

        return wb;
    }

    private XSSFWorkbook header(Integer dataInicio, Integer dataFim, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles)
            throws IOException, NullPointerException {

        // cell = sheet.getRow(2).getCell(1);
        // cell.setCellValue("Periodo: " + StringUtils.converteCompetenciaEmDataAbreviada(dataInicio) + " � " +
        // StringUtils.converteCompetenciaEmDataAbreviada(dataFim));

        return wb;
    }

    @SuppressWarnings("rawtypes")
    private XSSFWorkbook body(List<Object> listaSinistro, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles)
            throws IOException, NullPointerException {

        Cell cell = null;
        Integer linha = linhaInicio;
        Integer coluna = colunaInicio;

        Iterator itSinistro = listaSinistro.iterator();
        while (itSinistro.hasNext()) {

            coluna = colunaInicio;
            linha++;

            Object[] sinistro = (Object[]) itSinistro.next();
            String competencia = sinistro[0] == null ? ""
                    : StringUtils.converteCompetenciaEmDataAbreviada(new Integer(sinistro[0].toString()));
            BigDecimal rede = sinistro[1] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[1].toString());
            BigDecimal reembolso = sinistro[2] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[2].toString());

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(competencia);
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cell"));
            else
                cell.setCellStyle(styles.get("cell2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(rede.doubleValue());
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cell$"));
            else
                cell.setCellStyle(styles.get("cell$2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(reembolso.doubleValue());
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cell$"));
            else
                cell.setCellStyle(styles.get("cell$2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_FORMULA);
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cell$"));
            else
                cell.setCellStyle(styles.get("cell$2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_FORMULA);
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cell%"));
            else
                cell.setCellStyle(styles.get("cell2%"));

        }

        return wb;
    }
}