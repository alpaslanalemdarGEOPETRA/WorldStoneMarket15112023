package ApachePOI;

/*
   Main den bir metod çağırmak suretiyle, path i ve sheetName i verilen excelden
   istenilen sütun kadar veriyi okuyup bir List e atınız.
   Bu soruda kaynak Excel için : ApacheExcel2.xlsx  in 2.sheet ini kullanabilirsiniz.
 */


import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class _11_Soru {
    public static void main(String[] args) {
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        String sheetName="testCitizen";
        int sutunSayisi=2;

        ArrayList<ArrayList<String>> data = getData(path, sheetName, sutunSayisi);
        System.out.println("data = " + data);
    }


    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int sutunSayisi){
        ArrayList<ArrayList<String>> tablo=new ArrayList<>();

        Sheet sheet=null;
        try {
            FileInputStream inputStream=new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
             sheet=workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());;
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  //her bir satırı

            ArrayList<String> satir=new ArrayList<>();
            for (int j = 0; j < sutunSayisi; j++) {  // sutun sayısı kadar dolas
                satir.add(sheet.getRow(i).getCell(j).toString());
            }

            tablo.add(satir);
        }

        return tablo;
    }
}
