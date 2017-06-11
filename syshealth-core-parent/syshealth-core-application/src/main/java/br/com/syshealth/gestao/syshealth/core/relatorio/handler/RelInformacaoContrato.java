package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.syshealth.commons.dto.Empresa;
import br.com.syshealth.commons.enums.CoParticipacaoRevertidaEnum;
import br.com.syshealth.commons.utils.StringUtils;
import br.com.syshealth.gestao.syshealth.commons.Contrato;

public class RelInformacaoContrato {

    public XSSFWorkbook pagina(Empresa empresa, Contrato contrato, Integer dataInicio, Integer dataFim, XSSFWorkbook wb, Sheet sheet,
            Map<String, XSSFCellStyle> styles) throws NullPointerException, IOException, FileNotFoundException, ParseException {

        Cell cell = null;
        // CLIENTE
        cell = sheet.getRow(6).getCell(7);
        cell.setCellValue(empresa.getNome().trim());

        // OPERADORA
        cell = sheet.getRow(7).getCell(7);
        cell.setCellValue(empresa.getOperadora().getNome().trim());

        // CONTRATO
        cell = sheet.getRow(8).getCell(7);
        cell.setCellValue(contrato.getCodigo());

        // VIG�NCIA
        cell = sheet.getRow(9).getCell(7);
        cell.setCellValue(StringUtils
                .converteVigenciaParaCapaUltimoMes(StringUtils.converteDataStringParaIntegerCompetencia(contrato.getInicioVigencia())));

        // PATAMAR DE SINISTRALIDADE
        cell = sheet.getRow(10).getCell(7);
        cell.setCellValue(contrato.getLimiteTecnico().divide(new BigDecimal(100)).doubleValue());

        // REAJUSTE T�CNICO
        cell = sheet.getRow(11).getCell(7);
        cell.setCellValue("Apura��o: " + StringUtils.converteVigenciaParaCapa(dataInicio, dataFim) +
                "                                                                               Aplica��o:"
                + StringUtils.converteVigenciaParaCapaUltimoMes(dataInicio));

        // REAJUSTE FINANCEIRO
        cell = sheet.getRow(12).getCell(7);
        cell.setCellValue(
                "IGPM do per�odo															        Aplica��o: juntamente com o reajuste t�cnico");

        // COPARTICIPA��O
        // Consultas
        cell = sheet.getRow(14).getCell(9);
        cell.setCellValue(contrato.getCoParticipacao().getValorConsultaPs().doubleValue());
        // Exames Simples
        cell = sheet.getRow(16).getCell(9);
        cell.setCellValue(contrato.getCoParticipacao().getValorExamesSimples().doubleValue());
        // Exames Especiais
        cell = sheet.getRow(17).getCell(9);
        cell.setCellValue(contrato.getCoParticipacao().getValorExamesEspeciais().doubleValue());
        // Terapias
        cell = sheet.getRow(18).getCell(9);
        cell.setCellValue(contrato.getCoParticipacao().getValorTerapia().doubleValue());

        // Valor Limitado
        cell = sheet.getRow(20).getCell(7);
        cell.setCellValue("Limitado a " + contrato.getCoParticipacao().getValorLimitado());

        // Revertida
        cell = sheet.getRow(21).getCell(7);
        if (contrato.getCoParticipacao().getRevertida() == CoParticipacaoRevertidaEnum.OPERADORA_SEGURADORA)
            cell.setCellValue("Revertida para Operadora/Seguradora");
        else if (contrato.getCoParticipacao().getRevertida() == CoParticipacaoRevertidaEnum.EMPRESA)
            cell.setCellValue("Revertida para Empresa");

        // CONTRIBUTARIEDADE
        cell = sheet.getRow(23).getCell(7);
        // cell.setCellValue(contrato.getContributario() != null ? SimNaoEnum.SIM : SimNaoEnum.NAO);

        return wb;
    }

}