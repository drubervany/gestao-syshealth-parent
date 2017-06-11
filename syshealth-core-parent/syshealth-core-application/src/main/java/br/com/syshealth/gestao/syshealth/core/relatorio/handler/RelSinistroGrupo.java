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

public class RelSinistroGrupo {

    public XSSFWorkbook pagina(Integer dataInicio, Integer dataFim,
            Map<Integer, List<Object>> mapSinistro,
            Map<Integer, Integer> mapInternacao,
            XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException {

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = bodyValores(mapSinistro.get(0), wb, sheet, styles);
        wb = bodyFrequencia(mapSinistro.get(1), mapInternacao, wb, sheet, styles);

        return wb;
    }

    private XSSFWorkbook bodyValores(List<Object> listaSinistro, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles)
            throws IOException, NullPointerException {

        Cell cell = null;
        Integer linha = 6;
        Integer coluna = 2;

        @SuppressWarnings("rawtypes")
        Iterator itSinistro = listaSinistro.iterator();
        while (itSinistro.hasNext()) {

            coluna = 2;

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

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(competencia);

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(internacao.doubleValue() + honorario.doubleValue() + outros.doubleValue());

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(examesSimples.doubleValue() + examesEspeciais.doubleValue());

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(consultas.doubleValue());

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(terapia.doubleValue() + prontoSocorro.doubleValue());
        }

        return wb;
    }

    private XSSFWorkbook bodyFrequencia(List<Object> listaSinistro, Map<Integer, Integer> mapInternacao, XSSFWorkbook wb, Sheet sheet,
            Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException {

        Cell cell = null;
        Integer linha = 24;
        Integer coluna = 2;

        @SuppressWarnings("rawtypes")
        Iterator itSinistro = listaSinistro.iterator();
        while (itSinistro.hasNext()) {

            coluna = 2;

            linha++;

            Object[] sinistro = (Object[]) itSinistro.next();
            Integer periodo = sinistro[0] == null ? null : new Integer(sinistro[0].toString());
            String competencia = sinistro[0] == null ? ""
                    : StringUtils.converteCompetenciaEmDataAbreviada(new Integer(sinistro[0].toString()));
            BigDecimal consultas = sinistro[1] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[1].toString());
            BigDecimal prontoSocorro = sinistro[2] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[2].toString());
            BigDecimal examesSimples = sinistro[3] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[3].toString());
            BigDecimal examesEspeciais = sinistro[4] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[4].toString());
            // BigDecimal internacao = sinistro[5]==null ? BigDecimal.ZERO : new BigDecimal(sinistro[5].toString());
            BigDecimal honorario = sinistro[6] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[6].toString());
            BigDecimal terapia = sinistro[7] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[7].toString());
            BigDecimal outros = sinistro[8] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[8].toString());

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(competencia);

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(mapInternacao.get(periodo).intValue() + honorario.intValue() + outros.intValue());

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(examesSimples.intValue() + examesEspeciais.intValue());

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(consultas.intValue());

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(terapia.intValue() + prontoSocorro.intValue());
        }

        return wb;
    }
}