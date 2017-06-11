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

public class RelRankingMaioresPeriodo {

    public XSSFWorkbook pagina(Integer dataInicio, Integer dataFim, List<Object> listaSinistro, Map<Integer, String> mapPrestador,
            XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException {

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = body(listaSinistro, mapPrestador, wb, sheet, styles);

        return wb;
    }

    private XSSFWorkbook body(List<Object> listaSinistro, Map<Integer, String> mapPrestador, XSSFWorkbook wb, Sheet sheet,
            Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException {

        Cell cell = null;
        Integer linha = 6;
        Integer coluna = 1;
        int i = 0;

        @SuppressWarnings("rawtypes")
        Iterator itSinistro = listaSinistro.iterator();
        while (itSinistro.hasNext()) {

            coluna = 2;
            linha++;
            i++;

            Object[] sinistro = (Object[]) itSinistro.next();
            @SuppressWarnings("unused")
            Long codigoSegurado = sinistro[0] == null ? 0 : new Long(sinistro[0].toString());
            String titularidade = sinistro[1] == null ? "" : new String(sinistro[1].toString());
            String acomodacao = sinistro[2] == null ? "" : new String(sinistro[2].toString());
            Date dataNascimento = null;
            if (sinistro[3] != null)
                dataNascimento = (Date) sinistro[3];

            BigDecimal valorSinistro = sinistro[4] == null ? BigDecimal.ZERO : new BigDecimal(sinistro[4].toString());

            Integer idade = StringUtils.calculaIdade(dataNascimento);

            String status = titularidade.equals("4") ? "Inativo" : "Ativo";
            titularidade = titularidade.equals("1") ? "Titular" : "Dependente";

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(titularidade);

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(acomodacao);

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(idade);

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(valorSinistro.doubleValue());

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(status);

            cell = sheet.getRow(linha).getCell(coluna++);
            // cell.setCellType(Cell.CELL_TYPE_STRING);
            // cell.setCellValue(status);

            cell = sheet.getRow(linha).getCell(coluna++);
            // cell.setCellType(Cell.CELL_TYPE_STRING);
            // cell.setCellValue(status);

            cell = sheet.getRow(linha).getCell(coluna++);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(mapPrestador.get(i));

        }

        return wb;
    }
}