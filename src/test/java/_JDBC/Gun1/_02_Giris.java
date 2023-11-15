package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_Giris extends JDBCParent {


    @Test
    public void test1() throws SQLException {
        ResultSet sonuc= sorguEkrani.executeQuery("select * from customer");

        sonuc.next();

        System.out.println(sonuc.getString("first_name"));
        System.out.println(sonuc.getString("last_name"));

        sonuc.next();

        System.out.println(sonuc.getString("first_name"));
        System.out.println(sonuc.getString("last_name"));

    }


}
