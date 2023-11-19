package Utilities;

import Model.Company;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class ExcelWriter {

    public static void writeMapToExcel(String filePath, Map<String, Company> dataMap) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Company Data");

        int rowNum = 0;
        for (Map.Entry<String, Company> entry : dataMap.entrySet()) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(entry.getKey());
            Company company = entry.getValue();
            // Örnek olarak Company sınıfında name ve address alanları olduğunu varsayıyorum
            row.createCell(1).setCellValue(company.getDescription());
            row.createCell(2).setCellValue(company.getCompanyAddress());
            // Diğer alanlar için benzer işlemler...
        }

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
        workbook.close();
    }
}
