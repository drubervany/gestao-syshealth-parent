package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.syshealth.commons.dto.Empresa;
import br.com.syshealth.commons.utils.StringUtils;
import br.com.syshealth.gestao.syshealth.commons.Contrato;

public class RelPremissas {

    public XSSFWorkbook pagina(Empresa empresa, Contrato contrato, Integer dataInicio, Integer dataFim, XSSFWorkbook wb, Sheet sheet,
            Map<String, XSSFCellStyle> styles) {

        Cell cell = null;

        // System.out.println(contrato.toString());

        // Nome empresa
        cell = sheet.getRow(1).getCell(2);
        if (empresa.getNome() == null)
            cell.setCellValue("N/I");
        else
            cell.setCellValue(empresa.getNome());

        // Ultimo m�s
        cell = sheet.getRow(2).getCell(2);
        cell.setCellValue(StringUtils.converteVigenciaParaCapaUltimoMes(dataFim));

        cell = sheet.getRow(2).getCell(3);
        cell.setCellValue(StringUtils.converteCompetenciaEmDataAbreviada(dataFim));

        // Per�odo Avaliado
        cell = sheet.getRow(3).getCell(2);
        cell.setCellValue(StringUtils.converteVigenciaParaCapa(dataInicio, dataFim));

        // Per�odo Apura��o
        cell = sheet.getRow(4).getCell(2);
        cell.setCellValue(StringUtils.converteVigenciaParaCapaApuracao(dataInicio, dataFim));

        // Patamar
        cell = sheet.getRow(5).getCell(2);
        cell.setCellValue(contrato.getLimiteTecnico().doubleValue() / 100);

        // Ultrassonografias
        cell = sheet.getRow(6).getCell(2);
        cell.setCellValue(StringUtils.converteVigenciaParaCapa(dataInicio, dataFim));

        return wb;
    }
}