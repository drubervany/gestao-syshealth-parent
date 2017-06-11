
package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.syshealth.commons.utils.StringUtils;
import br.com.syshealth.gestao.syshealth.commons.Contrato;

public class RelPerfilFinancieiro {

    public XSSFWorkbook pagina(Contrato contrato, Map<Integer, Integer> vida, Map<Integer, Integer> vidaSinistradas,
            Map<Integer, BigDecimal> premio, Map<Integer, BigDecimal> sinistro, Map<Integer, BigDecimal> coParticipacao, Integer dataDe,
            Integer dataAte, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException {

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = body(vida, vidaSinistradas, premio, sinistro, coParticipacao, wb, sheet, styles);

        return wb;
    }

    private XSSFWorkbook body(Map<Integer, Integer> vida, Map<Integer, Integer> vidaSinistradas, Map<Integer, BigDecimal> premio,
            Map<Integer, BigDecimal> sinistro, Map<Integer, BigDecimal> coParticipacao, XSSFWorkbook wb, Sheet sheet,
            Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException {

        Cell cell = null;
        Integer linha = 46;
        Integer col = 2;

        for (Integer competencia : vida.keySet()) {

            Integer qtdeVida = vida.get(competencia);
            BigDecimal vlPremio = new BigDecimal(premio.get(competencia).toString());
            BigDecimal vlSinistro = sinistro.get(competencia);

            cell = sheet.getRow(linha++).getCell(col);
            cell.setCellValue(StringUtils.converteCompetenciaEmDataAbreviada(competencia));

            cell = sheet.getRow(linha++).getCell(col);
            cell.setCellValue(qtdeVida);

            // Premio
            cell = sheet.getRow(linha++).getCell(col);
            cell.setCellValue(vlPremio.doubleValue());

            // Sinistro
            cell = sheet.getRow(linha++).getCell(col);
            cell.setCellValue(vlSinistro.doubleValue());

            // vidaSinistradas
            cell = sheet.getRow(62).getCell(col);
            cell.setCellValue(vidaSinistradas.get(competencia));

            // coParticipacao
            cell = sheet.getRow(68).getCell(col);
            cell.setCellValue(coParticipacao.get(competencia).doubleValue());

            col++;
            linha = 46;
        }

        return wb;
    }

}