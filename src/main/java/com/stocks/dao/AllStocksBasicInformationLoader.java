package com.stocks.dao;

import com.stocks.dao.dto.StockBasicInformation;
import com.stocks.dao.dto.StocksBasicInformation;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Date;
import java.util.Iterator;

public class AllStocksBasicInformationLoader implements IAllStocksBasicInformationLoader {

    private String path;

    public AllStocksBasicInformationLoader(String path) {
        this.path = path;
    }

    // TODO: write some logic in such a way that external service is called just once for each company
    @Override
    public StocksBasicInformation load() {
        StocksBasicInformation stocksBasicInformation = new StocksBasicInformation();

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(path));

            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheetAt(0);

            //FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (row.getRowNum() == 0) {
                    continue;
                }

                StockBasicInformation stockBasicInformation = new StockBasicInformation();
                String company = getStringCellValue(row.getCell(0));

                Cell cell1 = row.getCell(1);
                if (cell1.getCellType().equals(CellType.STRING)) {
                    String bseSymbol = getStringCellValue(cell1);
                    stockBasicInformation.setBseSymbol(bseSymbol);
                } else {
                    Double bseSymbol = getNumericCellValue(cell1);
                    if (bseSymbol != null) {
                        stockBasicInformation.setBseSymbol("" + bseSymbol.intValue());
                    }
                }

                String nseSymbol = getStringCellValue(row.getCell(2));
                Double quantity = getNumericCellValue(row.getCell(3));
                Double buyingPrice = getNumericCellValue(row.getCell(4));
                Date purchaseDate = getDateCellValue(row.getCell(5));
                String timeFrames = getStringCellValue(row.getCell(6));
                Double dailyTarget1 = getNumericCellValue(row.getCell(7));
                Double weeklyTarget1 = getNumericCellValue(row.getCell(8));
                Double monthlyTarget1 = getNumericCellValue(row.getCell(9));
                Double dailyTarget2 = getNumericCellValue(row.getCell(10));
                Double weeklyTarget2 = getNumericCellValue(row.getCell(11));
                Double monthlyTarget2 = getNumericCellValue(row.getCell(12));
                Double dailyTarget3 = getNumericCellValue(row.getCell(13));
                Double weeklyTarget3 = getNumericCellValue(row.getCell(14));
                Double monthlyTarget3 = getNumericCellValue(row.getCell(15));
                Double dailyStopLoss1 = getNumericCellValue(row.getCell(16));
                Double weeklyStopLoss1 = getNumericCellValue(row.getCell(17));
                Double monthlyStopLoss1 = getNumericCellValue(row.getCell(18));
                Double dailyStopLoss2 = getNumericCellValue(row.getCell(19));
                Double weeklyStopLoss2 = getNumericCellValue(row.getCell(20));
                Double monthlyStopLoss2 = getNumericCellValue(row.getCell(21));
                Double dailyStopLoss3 = getNumericCellValue(row.getCell(22));
                Double weeklyStopLoss3 = getNumericCellValue(row.getCell(23));
                Double monthlyStopLoss3 = getNumericCellValue(row.getCell(24));
                Double dailyDemandZoneValue = getNumericCellValue(row.getCell(25));
                Double weeklyDemandZoneValue = getNumericCellValue(row.getCell(26));
                Double monthlyDemandZoneValue = getNumericCellValue(row.getCell(27));
                String comment1 = getStringCellValue(row.getCell(28));
                String comment2 = getStringCellValue(row.getCell(29));

                stockBasicInformation.setName(company);
                stockBasicInformation.setNseSymbol(nseSymbol);
                stockBasicInformation.setQuantity(quantity);
                stockBasicInformation.setBuyingPrice(buyingPrice);
                stockBasicInformation.setPurchaseDate(purchaseDate);
                stockBasicInformation.setTimeFrames(timeFrames);

                stockBasicInformation.setDailyTarget1(dailyTarget1);
                stockBasicInformation.setWeeklyTarget1(weeklyTarget1);
                stockBasicInformation.setMonthlyTarget1(monthlyTarget1);

                stockBasicInformation.setDailyTarget2(dailyTarget2);
                stockBasicInformation.setWeeklyTarget2(weeklyTarget2);
                stockBasicInformation.setMonthlyTarget2(monthlyTarget2);

                stockBasicInformation.setDailyTarget3(dailyTarget3);
                stockBasicInformation.setWeeklyTarget3(weeklyTarget3);
                stockBasicInformation.setMonthlyTarget3(monthlyTarget3);

                stockBasicInformation.setDailyStopLoss1(dailyStopLoss1);
                stockBasicInformation.setWeeklyStopLoss1(weeklyStopLoss1);
                stockBasicInformation.setMonthlyStopLoss1(monthlyStopLoss1);

                stockBasicInformation.setDailyStopLoss2(dailyStopLoss2);
                stockBasicInformation.setWeeklyStopLoss2(weeklyStopLoss2);
                stockBasicInformation.setMonthlyStopLoss2(monthlyStopLoss2);

                stockBasicInformation.setDailyStopLoss3(dailyStopLoss3);
                stockBasicInformation.setWeeklyStopLoss3(weeklyStopLoss3);
                stockBasicInformation.setMonthlyStopLoss3(monthlyStopLoss3);

                stockBasicInformation.setDailyDemandZoneValue(dailyDemandZoneValue);
                stockBasicInformation.setWeeklyDemandZoneValue(weeklyDemandZoneValue);
                stockBasicInformation.setMonthlyDemandZoneValue(monthlyDemandZoneValue);

                stockBasicInformation.setComment1(comment1);
                stockBasicInformation.setComment2(comment2);

                stocksBasicInformation.add(stockBasicInformation);
            }
        } catch (FileNotFoundException e) {
            // TODO: convert into DaoException
            throw new RuntimeException("exception while finding the file");

        } catch (IOException e) {
            // TODO: convert into DaoException
            throw new RuntimeException("exception while file operation");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException("exception while closing file input stream");
            }
        }
        return stocksBasicInformation;
    }

    private String getStringCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        final String value = cell.getStringCellValue();
        if (StringUtils.isNotEmpty(value)) {
            return value.trim();
        }
        return value;
    }

    private Double getNumericCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        final Double value = cell.getNumericCellValue();
        return value;
    }

    private Date getDateCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        final Date value = cell.getDateCellValue();
        return value;
    }
}
