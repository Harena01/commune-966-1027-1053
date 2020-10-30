/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author ONINTSOA
 */
public class Helper {
     public static Connection getConnection()throws Exception {
        Connection connection = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","commune","123456");
        }catch(Exception ex){
            throw ex;
        }
        return connection;
    }
}
