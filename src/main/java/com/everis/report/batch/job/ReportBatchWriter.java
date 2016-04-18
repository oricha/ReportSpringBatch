package com.everis.report.batch.job;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.everis.report.batch.data.ReportDto;
/**
 * 
 * @author kmunizpe
 *
 */
@Component("writer")
@Scope("step")
public class ReportBatchWriter implements ItemWriter<ReportDto> {
	private static final Log LOGGER = LogFactory.getLog(ReportBatchWriter.class);
	private static final String FILE_NAME = "ReportLogBatch";
    private static final String[] HEADERS = { "Modulo", "Entorno", "Batch",
            "Fecha", "RC", "Estado", "Tiempo", "Observaciones",
            "Cadena ejecucion" };
 
    private String outputFilename;
    private Workbook workbook;
    private CellStyle dataCellStyle;
    private int currRow = 0;
	
	
	
	public void write(List<? extends ReportDto> items) throws Exception {
		
		LOGGER.info("Iniciando el writer");
		
		Sheet sheet = workbook.getSheetAt(0);
		for(ReportDto report: items){
			
				  currRow++;
	                Row row = sheet.createRow(currRow);
	                createStringCell(row, report.getModulo(), 0);
	                createStringCell(row, report.getEntorno(), 1);
	                createStringCell(row, report.getBatch(), 2);
	                createStringCell(row, report.getRC(), 4);
	                createStringCell(row, report.getEstado(), 5);
	                createStringCell(row, report.getObservaciones(), 7);
	                createStringCell(row, report.getCadena(), 8);
			
			
		}
	}
	
	@BeforeStep
    public void beforeStep(StepExecution stepExecution) {
 
		 Date now = new Date();
//		String dateTime = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(now);
		SimpleDateFormat format = 
	            new SimpleDateFormat("yyyy MMM dd HH-mm-ss zzz");
		 String nameFile = "aaaabbbbcccc";
		String dateString = now.toString();
//        try {
//			outputFilename = FILE_NAME + "_" + format.parse(dateString) + ".xlsx";
			outputFilename = FILE_NAME + "_" + nameFile + ".xlsx";
//		} catch (ParseException e) {
//			LOGGER.error("ERROR: Cannot parse \"" + dateString + "\"");
//		}
 
        workbook = new SXSSFWorkbook(100);
        Sheet sheet = workbook.createSheet("Testing");
        sheet.createFreezePane(0, 3, 0, 3);
        sheet.setDefaultColumnWidth(20);
 
        addTitleToSheet(sheet);
        currRow++;
        addHeaders(sheet);
        initDataStyle();
 
    }
	
	@AfterStep
    public void afterStep(StepExecution stepExecution) throws IOException {
        FileOutputStream fos = new FileOutputStream(outputFilename);
        workbook.write(fos);
        fos.close();
    }

	private void initDataStyle() {
		dataCellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
 
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Arial");
        dataCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
        dataCellStyle.setFont(font);
		
	}
	
	private void addHeaders(Sheet sheet) {
		 
        Workbook wb = sheet.getWorkbook();
 
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
 
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Arial");
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFont(font);
 
        Row row = sheet.createRow(2);
        int col = 0;
 
        for (String header : HEADERS) {
            Cell cell = row.createCell(col);
            cell.setCellValue(header);
            cell.setCellStyle(style);
            col++;
        }
        currRow++;
    }
	private void addTitleToSheet(Sheet sheet) {
		 
        Workbook wb = sheet.getWorkbook();
 
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
 
        font.setFontHeightInPoints((short) 14);
        font.setFontName("Arial");
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFont(font);
 
        Row row = sheet.createRow(currRow);
        row.setHeightInPoints(16);
        Date now = new Date();
        String currDate =DateFormat.getTimeInstance(DateFormat.MEDIUM).format(now);
 
        Cell cell = row.createCell(0, Cell.CELL_TYPE_STRING);
        cell.setCellValue("Report Batch Logs " + currDate);
        cell.setCellStyle(style);
 
        CellRangeAddress range = new CellRangeAddress(0, 0, 0, 7);
        sheet.addMergedRegion(range);
        currRow++;
 
    }
	
	private void createStringCell(Row row, String val, int col) {
	    Cell cell = row.createCell(col);
	    cell.setCellType(Cell.CELL_TYPE_STRING);
	    cell.setCellValue(val);
	}
	 
	private void createNumericCell(Row row, Double val, int col) {
	    Cell cell = row.createCell(col);
	    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	    cell.setCellValue(val);
	}
	
}
