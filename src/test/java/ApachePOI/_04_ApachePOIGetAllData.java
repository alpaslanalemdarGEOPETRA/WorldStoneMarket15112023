package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheetAt(0);

        // calisma sayfasındaki fiziksel kullanılan toplam satır sayısını veriyor.
        int rowCount=sheet.getPhysicalNumberOfRows();

        // 1.Yol
        for (int i = 0; i < rowCount; i++) { // satır sayısı  zoo.length
            //şimdi burada her bir satırın kaç hücresi var onu bulup ona kadar
            // hücreleri alacağım
            Row row=sheet.getRow(i);
            int cellCount= row.getPhysicalNumberOfCells(); // sütun sayısı

            for (int j = 0; j < cellCount; j++) { // zoo[i].length
                Cell cell=row.getCell(j); // j sütun
                System.out.print(cell+"\t");
            }

            System.out.println();
        }

        System.out.println("******************************************");
        //2.Yol
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) { // satır sayısı  zoo.length

            for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) { // zoo[i].length
                System.out.print(sheet.getRow(i).getCell(j)+"\t");
            }

            System.out.println();
        }



    }
}
