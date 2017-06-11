package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.syshealth.commons.dto.Empresa;
import br.com.syshealth.commons.utils.StringUtils;

public class RelCapaRelatorio {

    public XSSFWorkbook pagina(Empresa empresa, Integer dataInicio, Integer dataFim, XSSFWorkbook wb, Sheet sheet,
            Map<String, XSSFCellStyle> styles) {

        Cell cell = null;

        // System.out.println(contrato.toString());

        // Nome empresa
        cell = sheet.getRow(9).getCell(1);
        if (empresa.getNome() == null)
            cell.setCellValue("N/I");
        else
            cell.setCellValue(empresa.getNome());

        // Nome Operadora
        cell = sheet.getRow(13).getCell(1);
        cell.setCellValue(empresa.getOperadora().getNome());

        // Periodo de Vigencia
        cell = sheet.getRow(15).getCell(1);
        cell.setCellValue(StringUtils.converteVigenciaParaCapa(dataInicio, dataFim));

        return wb;
    }
}