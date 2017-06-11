package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.syshealth.commons.utils.StringUtils;

public class RelRankingMaioresMes {

    public XSSFWorkbook pagina(Integer dataFim, List<Object> listaSinistro, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles)
            throws IOException, NullPointerException {

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = header(dataFim, wb, sheet, styles);
        wb = body(listaSinistro, wb, sheet, styles);

        return wb;
    }

    private XSSFWorkbook header(Integer dataFim, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles)
            throws IOException, NullPointerException {

        // cell = sheet.getRow(2).getCell(1);
        // cell.setCellValue("Periodo: " + StringUtils.converteCompetenciaEmDataAbreviada(dataFim));

        return wb;
    }

    private XSSFWorkbook body(List<Object> listaSinistro, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles)
            throws IOException, NullPointerException {

        Cell cell = null;
        Integer linha = 6;
        Integer coluna = 1;
        Integer ranking = 1;

        @SuppressWarnings("rawtypes")
        Iterator itSinistro = listaSinistro.iterator();
        while (itSinistro.hasNext()) {

            coluna = 1;
            linha++;

            Object[] sinistro = (Object[]) itSinistro.next();
            @SuppressWarnings("unused")
            Long carteirinha = sinistro[0] == null ? 0 : new Long(sinistro[0].toString());
            String titularidade = sinistro[1] == null ? "" : new String(sinistro[1].toString());
            String genero = sinistro[2] == null ? "" : new String(sinistro[2].toString());
            Date dataNascimento = null;
            if (sinistro[3] != null)
                dataNascimento = (Date) sinistro[3];

            BigDecimal valorSinistro = sinistro[0] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[4].toString());

            String status = "Ativo";

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(ranking++);
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cell"));
            else
                cell.setCellStyle(styles.get("cell2"));

            /*
             * 
             * cell = sheet.getRow(linha).getCell(coluna++);
             * cell.setCellValue(carteirinha);
             * if(linha % 2 == 0)
             * cell.setCellStyle(styles.get("cell"));
             * else
             * cell.setCellStyle(styles.get("cell2"));
             */

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(titularidade);
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cell"));
            else
                cell.setCellStyle(styles.get("cell2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(genero);
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cell"));
            else
                cell.setCellStyle(styles.get("cell2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(StringUtils.calculaIdade(dataNascimento));
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cell"));
            else
                cell.setCellStyle(styles.get("cell2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(status);
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cell"));
            else
                cell.setCellStyle(styles.get("cell2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(valorSinistro.doubleValue());
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cell$"));
            else
                cell.setCellStyle(styles.get("cell$2"));

            // String formulaPerc = "I"+linha.toString()+"/$I$"+(totalLinha+inicioLinha);

            cell = sheet.getRow(linha).getCell(coluna++);
            // cell.setCellFormula(formulaPerc);
            cell.setCellType(Cell.CELL_TYPE_FORMULA);
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cell%"));
            else
                cell.setCellStyle(styles.get("cell2%"));

            // Formata a linha inserida
            // r = new CellRangeAddress(linha-1, linha-1, 1, (short)2);//linha inico, linha fim, coluna inicio, coluna
            // fim
            // sheet.addMergedRegion(r);

        }

        return wb;
    }

}