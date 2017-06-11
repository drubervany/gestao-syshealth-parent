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

public class RelFrequenciaGrupo {

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
        // cell.setCellValue("Periodo: " + StringUtils.converteCompetenciaEmDataAbreviada(dataInicio) + " � "+
        // StringUtils.converteCompetenciaEmDataAbreviada(dataFim));

        return wb;
    }

    private XSSFWorkbook body(List<Object> listaSinistro, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles)
            throws IOException, NullPointerException {

        Cell cell = null;
        Integer linha = 4;
        Integer coluna = 1;

        @SuppressWarnings("rawtypes")
        Iterator itSinistro = listaSinistro.iterator();
        while (itSinistro.hasNext()) {

            coluna = 1;

            linha++;

            Object[] sinistro = (Object[]) itSinistro.next();
            String competencia = sinistro[0] == null ? ""
                    : StringUtils.converteCompetenciaEmDataAbreviada(new Integer(sinistro[0].toString()));
            BigDecimal consultas = sinistro[1] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[1].toString());
            BigDecimal prontoSocorro = sinistro[2] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[2].toString());
            BigDecimal examesSimples = sinistro[3] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[3].toString());
            BigDecimal examesEspeciais = sinistro[4] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[4].toString());
            BigDecimal internacao = sinistro[5] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[5].toString());
            BigDecimal honorario = sinistro[6] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[6].toString());
            BigDecimal terapia = sinistro[7] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[7].toString());
            BigDecimal outros = sinistro[8] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[8].toString());
            BigDecimal total = sinistro[9] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[9].toString());

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(competencia);
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cell"));
            else
                cell.setCellStyle(styles.get("cell2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(consultas.doubleValue());
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cellInt"));
            else
                cell.setCellStyle(styles.get("cellInt2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(prontoSocorro.doubleValue());
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cellInt"));
            else
                cell.setCellStyle(styles.get("cellInt2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(examesSimples.doubleValue());
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cellInt"));
            else
                cell.setCellStyle(styles.get("cellInt2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(examesEspeciais.doubleValue());
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cellInt"));
            else
                cell.setCellStyle(styles.get("cellInt2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(internacao.doubleValue());
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cellInt"));
            else
                cell.setCellStyle(styles.get("cellInt2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(honorario.doubleValue());
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cellInt"));
            else
                cell.setCellStyle(styles.get("cellInt2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(terapia.doubleValue());
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cellInt"));
            else
                cell.setCellStyle(styles.get("cellInt2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(outros.doubleValue());
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cellInt"));
            else
                cell.setCellStyle(styles.get("cellInt2"));

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellValue(total.doubleValue());
            if (linha % 2 == 0)
                cell.setCellStyle(styles.get("cellInt"));
            else
                cell.setCellStyle(styles.get("cellInt2"));

        }

        return wb;
    }

}