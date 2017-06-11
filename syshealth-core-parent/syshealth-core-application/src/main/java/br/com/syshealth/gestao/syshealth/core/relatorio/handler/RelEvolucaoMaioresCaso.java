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
import br.com.syshealth.gestao.syshealth.commons.EmpresaPeriodo;

public class RelEvolucaoMaioresCaso {

    public XSSFWorkbook pagina(Integer dataInicio, Integer dataFim, Map<Integer, List<Object>> maioresCasos,
            List<EmpresaPeriodo> listaEmpresaPeriodo, List<Long> listaCarteirinha, XSSFWorkbook wb, Sheet sheet,
            Map<String, XSSFCellStyle> styles) throws NullPointerException, IOException {

        // Sheet sheet = wb.createSheet("Evolu��o 5 maiores casos");

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        wb = body(maioresCasos, listaEmpresaPeriodo, listaCarteirinha, wb, sheet, styles);

        return wb;
    }

    private XSSFWorkbook body(Map<Integer, List<Object>> maioresCasos,
            List<br.com.syshealth.gestao.syshealth.commons.EmpresaPeriodo> listaEmpresaPeriodo,
            List<Long> listaCarteirinha, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles)
            throws IOException, NullPointerException {

        Cell cell = null;
        Integer linha = 6;
        Integer col = 3;

        /*
         * linha = iniciolinha-1;
         * 
         * col=2;
         * for (Long carteirinha : listaCarteirinha) {
         * 
         * cell = sheet.getRow(linha).getCell(col++);
         * cell.setCellValue(carteirinha);
         * 
         * }
         */

        linha = 6;
        col = 3;
        for (EmpresaPeriodo empresaPeriodo : listaEmpresaPeriodo) {

            cell = sheet.getRow(linha).getCell(col++);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(StringUtils.converteCompetenciaEmDataAbreviada(empresaPeriodo.getCompetencia()));

        }

        linha = 7;
        for (Integer ranking : maioresCasos.keySet()) {

            col = 3;

            Iterator<Object> itSinistro = maioresCasos.get(ranking).iterator();
            while (itSinistro.hasNext()) {

                Object[] dadosSinistro = (Object[]) itSinistro.next();

                // competencia = dadosSinistro[0]==null ? 0 : new Integer(dadosSinistro[0].toString());
                BigDecimal valorSinistro = dadosSinistro[1] == null ? BigDecimal.ZERO : new BigDecimal(dadosSinistro[1].toString());

                cell = sheet.getRow(linha).getCell(col++);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(valorSinistro.doubleValue());
            }

            linha++;
        }

        return wb;
    }

}