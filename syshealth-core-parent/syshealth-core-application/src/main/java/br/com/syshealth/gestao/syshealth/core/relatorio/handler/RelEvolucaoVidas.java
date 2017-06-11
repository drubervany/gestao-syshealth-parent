package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.syshealth.commons.utils.StringUtils;

public class RelEvolucaoVidas {

    public XSSFWorkbook pagina(Map<Integer, Integer> competenciaVidas,
            Integer dataInicio, Integer dataFim, XSSFWorkbook wb, Sheet sheet,
            Map<String, XSSFCellStyle> styles) {

        Cell cell = null;

        Integer linha = 8;
        for (Integer competencia : competenciaVidas.keySet()) {

            Integer col = 1;

            Integer vida = competenciaVidas.get(competencia);

            // Mes
            cell = sheet.getRow(linha).getCell(col);
            cell.setCellValue(StringUtils.converteCompetenciaEmDataAbreviada(competencia));

            // Vidas
            cell = sheet.getRow(linha++).getCell(col + 1);
            cell.setCellValue(vida);

        }

        return wb;
    }

}