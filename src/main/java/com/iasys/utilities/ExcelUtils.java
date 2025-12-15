package com.iasys.utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelUtils(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            throw new RuntimeException("Error loading Excel: " + e.getMessage());
        }
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public int getCellCount(int rownum) {
        return sheet.getRow(rownum).getLastCellNum();
    }

    public String getCellData(int rownum, int colnum) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(rownum).getCell(colnum));
    }

    public Object[][] getDataArray() {
        int rows = getRowCount();
        int cols = getCellCount(0);

        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = getCellData(i, j);
            }
        }
        return data;
    }
}
