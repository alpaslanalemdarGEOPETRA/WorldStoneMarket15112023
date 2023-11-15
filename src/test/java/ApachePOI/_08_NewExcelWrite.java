package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {
    public static void main(String[] args) throws IOException {

        //hafzada worbook oluştur, içinde hafızada sheet oluştur
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sayfa1");

        //hafızada işlemlerini yap
        Row yeniSatir= sheet.createRow(0);
        Cell hucre= yeniSatir.createCell(0);
        hucre.setCellValue("Merhaba Dünya");

        //kaydet
        String path = "src/test/java/ApachePOI/resource/YeniExcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("işlem tamamlandı");
    }
}
