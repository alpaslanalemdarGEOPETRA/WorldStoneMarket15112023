package _JDBC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCParent {

    public static Connection baglanti;
    public static  Statement sorguEkrani;
    @BeforeClass
    public void DBConnectionOpen()
    {
        String HostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            baglanti = DriverManager.getConnection(HostUrl, username, password);
            sorguEkrani = baglanti.createStatement();
        }
        catch(Exception ex){
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    @AfterClass
    public void DBConnectionClose()
    {
        try {
            baglanti.close();
        } catch (SQLException ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }


}
