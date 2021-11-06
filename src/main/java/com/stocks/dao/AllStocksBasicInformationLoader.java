package com.stocks.dao;

import com.stocks.dao.dto.StockBasicInformation;
import com.stocks.dao.dto.StocksBasicInformation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class AllStocksBasicInformationLoader implements IAllStocksBasicInformationLoader {

    private String path;

    public AllStocksBasicInformationLoader(String path) {
        this.path = path;
    }

    @Override
    public StocksBasicInformation load() {
        StocksBasicInformation stocksBasicInformation = new StocksBasicInformation();


        //FileInputStream fis = null;
        try {
            //fis = new FileInputStream(new File(path));

            XSSFWorkbook wb = new XSSFWorkbook(new File(path));

            //HSSFWorkbook wb = new HSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            //FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                StockBasicInformation stockBasicInformation = new StockBasicInformation();

                Row row = rowIterator.next();
                String company = row.getCell(0).getStringCellValue();

                final Cell cell1 = row.getCell(1);
                if(cell1.getCellType().equals(CellType.STRING)) {
                    String bseSymbol = cell1.getStringCellValue();
                    stockBasicInformation.setBseSymbol(bseSymbol);
                } else {
                    Integer bseSymbol = (int)cell1.getNumericCellValue();
                    stockBasicInformation.setBseSymbol(String.valueOf(bseSymbol));
                }

                String nseSymbol = row.getCell(2).getStringCellValue();
                Double quantity = row.getCell(3).getNumericCellValue();
                Double buyingPrice = row.getCell(4).getNumericCellValue();

                stockBasicInformation.setName(company);
                stockBasicInformation.setNseSymbol(nseSymbol);
                stockBasicInformation.setQuantity(quantity);
                stockBasicInformation.setBuyingPrice(buyingPrice);

                stocksBasicInformation.add(stockBasicInformation);
            }
        } catch (FileNotFoundException e) {
            // TODO: convert into DaoException
            throw new RuntimeException("exception while finding the file");

        } catch (IOException e) {
            // TODO: convert into DaoException
            throw new RuntimeException("exception while file operation");
        } catch (InvalidFormatException e) {
            // TODO: convert into DaoException
            throw new RuntimeException("exception while file operation");
        }/* finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException("exception while closing inputstream");
            }
        }*/
        return stocksBasicInformation;
    }
}
