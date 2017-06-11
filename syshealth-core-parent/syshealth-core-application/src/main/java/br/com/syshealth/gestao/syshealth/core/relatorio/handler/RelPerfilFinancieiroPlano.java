package br.com.syshealth.gestao.syshealth.core.relatorio.handler;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class RelPerfilFinancieiroPlano {

	private Integer qtdePlanos = new Integer(0);

	public XSSFWorkbook pagina(Integer dataDe, Integer dataAte, List<Object> listaVida, List<Object> listaPremio, List<Object> listaSinistro, XSSFWorkbook wb, Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setDisplayGridlines(false);

        qtdePlanos = listaPremio.size();
        wb = header(dataDe, dataAte, wb, sheet, styles);
        wb = body(listaVida, listaPremio, listaSinistro, wb, sheet, styles);
        wb = footer(wb, sheet, styles);

        return wb;
    }

	private XSSFWorkbook header(Integer dataDe, Integer dataAte, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		 //cell = sheet.getRow(2).getCell(1);
	     //cell.setCellValue("Periodo: " + StringUtils.converteCompetenciaEmDataAbreviada(dataDe) + " � "+ StringUtils.converteCompetenciaEmDataAbreviada(dataAte));

        return wb;
    }

	@SuppressWarnings("rawtypes")
	private XSSFWorkbook body(List<Object> listaVida, List<Object>listaPremio, List<Object>listaSinistro, XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Row  row = null;
		Cell cell = null;
		Integer linha=5;
		Integer coluna=1;

		Integer x = 0;
		Integer qtdeVida = 0;

		String planoPremio, planoSinitro, planoVida;
    	String acomodacaoPremio, acomodacaoSinitro, acomodacaoVida;
    	String planoCategoriaPremio, planoCategoriaSinitro, planoCategoriaVida;

    	BigDecimal vlPremio = new BigDecimal(0);
    	BigDecimal vlSinistro  = new BigDecimal(0);

		Iterator itPremio = listaPremio.iterator();
    	while(itPremio.hasNext()){
    		x++;

    		Object[] premio = (Object[]) itPremio.next();
    		planoPremio 			= premio[0]==null ? "" : premio[0].toString();
        	acomodacaoPremio 		= premio[2]==null ? "" : premio[2].toString();
        	planoCategoriaPremio 	= premio[3]==null ? "" : premio[3].toString();
        	//qtdeVida 				= premio[4]==null ? 0 : new Integer(premio[4].toString());
        	vlPremio  				= premio[5]==null ? BigDecimal.ZERO : new BigDecimal(premio[5].toString());

        	Iterator itVida = listaVida.iterator();
        	while(itVida.hasNext()){

        		Object[] vida = (Object[]) itVida.next();
        		planoVida 			= vida[0]==null ? "" : vida[0].toString();
            	acomodacaoVida 		= vida[2]==null ? "" : vida[2].toString();
            	planoCategoriaVida 	= vida[3]==null ? "" : vida[3].toString();
            	qtdeVida 			= vida[4]==null ? 0 : new Integer(vida[4].toString());

            	if (planoVida.equals(planoPremio)
            		&& acomodacaoVida.equals(acomodacaoPremio)
            		&& planoCategoriaVida.equals(planoCategoriaPremio)){

            			listaVida.remove(vida);
            		break;
            	}
        	}

    		Iterator itSinistro = listaSinistro.iterator();
        	while(itSinistro.hasNext()){

        		Object[] sinistro = (Object[]) itSinistro.next();
        		planoSinitro 			= sinistro[0]==null ? "" : sinistro[0].toString();
            	acomodacaoSinitro 		= sinistro[2]==null ? "" : sinistro[2].toString();
            	planoCategoriaSinitro 	= sinistro[3]==null ? "" : sinistro[3].toString();
            	vlSinistro  			= sinistro[4]==null ?  BigDecimal.ZERO : new BigDecimal(sinistro[4].toString());

            	if (planoSinitro.equals(planoPremio)
            		&& acomodacaoSinitro.equals(acomodacaoPremio)
            		&& planoCategoriaSinitro.equals(planoCategoriaPremio)){

            			listaSinistro.remove(sinistro);
            		break;
            	}
        	}

			coluna=1;

			//Inseri uma linha para baixo
         	//sheet.shiftRows(linha,linha+1,1, true, false);
         	row = criaLinhaCell(linha++, sheet);


			cell = row.createCell(coluna++);
	        cell.setCellValue(planoPremio);
	        if(x % 2 == 0)
	        	cell.setCellStyle(styles.get("cell"));
	        else
	        	cell.setCellStyle(styles.get("cell2"));


	        cell = row.createCell(coluna++);
	        cell.setCellValue(acomodacaoPremio);
	        if(x % 2 == 0)
	        	cell.setCellStyle(styles.get("cell"));
	        else
	        	cell.setCellStyle(styles.get("cell2"));


	        cell = row.createCell(coluna++);
	        cell.setCellValue(planoCategoriaPremio);
	        if(x % 2 == 0)
	        	cell.setCellStyle(styles.get("cell"));
	        else
	        	cell.setCellStyle(styles.get("cell2"));

	        //Vidas
	        cell = row.createCell(coluna++);
	        cell.setCellValue(qtdeVida);
	        if(x % 2 == 0)
	        	cell.setCellStyle(styles.get("cellInt"));
	        else
	        	cell.setCellStyle(styles.get("cellInt2"));

	        //% Vidas
	        cell = row.createCell(coluna++);
	        String formulaPremioPmpm = "E"+linha+"/$E$"+(qtdePlanos.intValue()+6);
	        cell.setCellType(Cell.CELL_TYPE_FORMULA);
        	cell.setCellFormula(formulaPremioPmpm);
        	if(x % 2 == 0)
	        	cell.setCellStyle(styles.get("cell%"));
	        else
	        	cell.setCellStyle(styles.get("cell2%"));


	        //Premio
	        cell = row.createCell(coluna++);
	        if(qtdeVida==BigDecimal.ZERO.intValue())
	        	vlPremio=BigDecimal.ZERO;
        	else
        		vlPremio = vlPremio.divide(new BigDecimal(qtdeVida), RoundingMode.HALF_UP);
	        cell.setCellValue(vlPremio.doubleValue());
	        if(x % 2 == 0)
	        	cell.setCellStyle(styles.get("cell$"));
	        else
	        	cell.setCellStyle(styles.get("cell$2"));


        	//Sinistro
        	cell = row.createCell(coluna++);
        	if(qtdeVida==BigDecimal.ZERO.intValue())
        		vlSinistro=BigDecimal.ZERO;
        	else
        		vlSinistro=vlSinistro.divide(new BigDecimal(qtdeVida), RoundingMode.HALF_UP);
	        cell.setCellValue(vlSinistro.doubleValue());
	        if(x % 2 == 0)
	        	cell.setCellStyle(styles.get("cell$"));
	        else
	        	cell.setCellStyle(styles.get("cell$2"));

	        //Sinistralidade
	        cell = row.createCell(coluna++);
	        String formulaSinistroPmpm = "IFERROR(H"+linha+"/G"+linha+",0)";
	        cell.setCellType(Cell.CELL_TYPE_FORMULA);
        	cell.setCellFormula(formulaSinistroPmpm);
        	if(x % 2 == 0)
	        	cell.setCellStyle(styles.get("cell%"));
	        else
	        	cell.setCellStyle(styles.get("cell2%"));

	        //Reajuste
	        cell = row.createCell(coluna++);
	        String formulaSinistralidade = "IFERROR((i"+linha+"/J4)-1,0)";
	        cell.setCellType(Cell.CELL_TYPE_FORMULA);
        	cell.setCellFormula(formulaSinistralidade);
        	if(x % 2 == 0)
	        	cell.setCellStyle(styles.get("cell%"));
	        else
	        	cell.setCellStyle(styles.get("cell2%"));

		}

		return wb;
	}

	private XSSFWorkbook footer(XSSFWorkbook wb,Sheet sheet, Map<String, XSSFCellStyle> styles) throws IOException, NullPointerException{

		Row  row = null;
		Cell cell = null;
		Integer linha=5;
		Integer coluna=1;
		CellRangeAddress r;
		String formulaTotalVida;

		coluna=1;
		//Inseri uma linha para baixo
     	//sheet.shiftRows(linha,linha+1,1, true, false);
     	row = criaLinhaCell(linha++, sheet);

	    cell = row.createCell(coluna++);
        cell.setCellValue("Total");
        cell.setCellStyle(styles.get("footer"));

        cell = row.createCell(coluna++);
        cell.setCellStyle(styles.get("footer"));

        cell = row.createCell(coluna++);
        cell.setCellStyle(styles.get("footer"));

        //Total Vidas
        cell = row.createCell(coluna++);
        formulaTotalVida = "SUM(E6:E"+(qtdePlanos.intValue()+5)+")";
        cell.setCellType(Cell.CELL_TYPE_FORMULA);
    	cell.setCellFormula(formulaTotalVida);
        cell.setCellStyle(styles.get("footerInt"));

        //Total % idas
        cell = row.createCell(coluna++);
        formulaTotalVida = "SUM(F6:F"+(qtdePlanos.intValue()+5)+")";
        cell.setCellType(Cell.CELL_TYPE_FORMULA);
    	cell.setCellFormula(formulaTotalVida);
        cell.setCellStyle(styles.get("footer%"));

        //Premio
        cell = row.createCell(coluna++);
        formulaTotalVida = "SUM(G6:G"+(qtdePlanos.intValue()+5)+")";
        cell.setCellType(Cell.CELL_TYPE_FORMULA);
    	cell.setCellFormula(formulaTotalVida);
        cell.setCellStyle(styles.get("footer$"));

        //Sinistro
        cell = row.createCell(coluna++);
        formulaTotalVida = "SUM(H6:H"+(qtdePlanos.intValue()+5)+")";
        cell.setCellType(Cell.CELL_TYPE_FORMULA);
    	cell.setCellFormula(formulaTotalVida);
        cell.setCellStyle(styles.get("footer$"));

        //Sinistralidade
        cell = row.createCell(coluna++);
        formulaTotalVida = "IFERROR(H"+(qtdePlanos.intValue()+6)+"/G"+(qtdePlanos.intValue()+6)+",0)";
        cell.setCellType(Cell.CELL_TYPE_FORMULA);
    	cell.setCellFormula(formulaTotalVida);
        cell.setCellStyle(styles.get("footer%"));

        //Reajuste
        cell = row.createCell(coluna++);
        formulaTotalVida = "IFERROR(I"+(qtdePlanos.intValue()+6)+"/J4,0)";
        cell.setCellType(Cell.CELL_TYPE_FORMULA);
    	cell.setCellFormula(formulaTotalVida);
        cell.setCellStyle(styles.get("footer%"));

        //Formata a linha inserida
		r = new CellRangeAddress(linha-1, linha-1, 1, (short)3);//linha inico, linha fim, coluna inicio, coluna fim
	    sheet.addMergedRegion(r);

        coluna=1;
        //Inseri uma linha para baixo
     	//sheet.shiftRows(linha,linha+1,1, true, false);
		row = criaLinhaCell(linha++, sheet);

        cell = row.createCell(coluna++);
        cell.setCellValue("� pmpm: Per member/ per month (per capita/ por m�s)");
        //cell.setCellStyle(styles.get("titulo"));

        return wb;
	}

	private Row criaLinhaCell(Integer linha, Sheet sheet){
		Row row = sheet.createRow(linha);
	    row.setHeightInPoints(21);

		return row;
	}
}