package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteInTheExcel {

    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";

        FileInputStream inputStream=new FileInputStream(path); // okuma yönünde açıldı
        Workbook workbook= WorkbookFactory.create(inputStream); // hafızaya kopyası oluşturuldu
        Sheet sheet=workbook.getSheetAt(0);

        // hafızada yazma işlemlerine başlıyorum
        int sonSatirIndex=sheet.getPhysicalNumberOfRows(); // son satırın indexini alıp
        Row yeniSatir= sheet.createRow(sonSatirIndex); // son boş yere satır açılıyor
        Cell yeniHucre= yeniSatir.createCell(0); // ilk hücre oluşturuldu
        yeniHucre.setCellValue("Merhaba Dünya");
        // yazma işim bitti
        // okuma kanalını kapat.
        inputStream.close();

        //dosyay kaydetmeye geçiyorum
        // bunun için dosyayı yazma yönünd eaç
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close(); // hafızayı boşalt
        outputStream.close(); // yazma kanalını kapat

        System.out.println("işlem bitti");
    }

}
