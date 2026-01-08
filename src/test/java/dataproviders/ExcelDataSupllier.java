package dataproviders;

import org.testng.annotations.DataProvider;
import utils.ReadDataFromExcel;

public class ExcelDataSupllier {

    @DataProvider(name = "loginData")
    public Object[][] supplyData() throws Exception {
        String filePath = System.getProperty("user.dir") + "\\testdata\\OrangeHRMTestLogin.xlsx";
        String sheetName = "Sheet1";
        return ReadDataFromExcel.getExcelData(filePath, sheetName);
    }
}
