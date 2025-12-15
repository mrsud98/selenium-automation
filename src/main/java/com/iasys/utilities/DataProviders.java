package com.iasys.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "loginData", parallel = true)
    public Object[][] loginDataProvider() {
        // Use your exact Excel path
        String filePath = "D:\\Automation_Project\\selenium-testng-automation\\src\\test\\resources\\LoginData.xlsx";
        String sheetName = "Sheet1";
        ExcelUtils excel = new ExcelUtils(filePath, sheetName);
        return excel.getDataArray();  // returns Object[][] from Excel
    }
}
