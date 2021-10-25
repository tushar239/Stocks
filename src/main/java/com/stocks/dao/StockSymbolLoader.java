package com.stocks.dao;

import com.stocks.dao.dto.Exchange;
import com.stocks.dao.dto.StockSymbol;
import com.stocks.dao.dto.StockSymbols;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class StockSymbolLoader implements IStockSymbolLoader {

    @Override
    public StockSymbols load(String companyName) {
        StockSymbols stockSymbols = new StockSymbols();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("C:\\demo\\stocks.xls"));

            HSSFWorkbook wb = new HSSFWorkbook(fis);
            HSSFSheet sheet = wb.getSheetAt(0);
            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String company = row.getCell(0).getStringCellValue();
                String nseSymbol = row.getCell(1).getStringCellValue();
                String bseSymbol = row.getCell(2).getStringCellValue();

                if (company.trim().equalsIgnoreCase(companyName.trim())) {
                    stockSymbols.add(new StockSymbol(nseSymbol, Exchange.NSE, company));
                    stockSymbols.add(new StockSymbol(bseSymbol, Exchange.BSE, company));
                    return stockSymbols;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("exception while finding the file");

        } catch (IOException e) {
            throw new RuntimeException("exception while file operation");
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException("exception while closing inputstream");
            }
        }
        return stockSymbols;
    }
}
