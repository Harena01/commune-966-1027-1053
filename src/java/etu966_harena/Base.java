package etu966_harena;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base extends HttpServlet{
    public static String vue = "/mariage";
    private Connection connection; 
    private Statement statement;

    @Override
    protected void doPost (HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
        this.getServletContext().getRequestDispatcher(vue).forward( request, response );
    }

    protected void doGet (HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","commune","123456");            
            this.statement = this.connection.createStatement();
            ResultSet resultLahy = this.statement.executeQuery("select nom from personne where sexe=1");
            ArrayList listLahy = new ArrayList<String>();
            while(resultLahy.next()){
                listLahy.add(resultLahy.getString(1));
            }

            ResultSet reslutVavy = this.statement.executeQuery("select nom from personne where sexe=0");
            ArrayList listvavy = new ArrayList<String>();
            while (reslutVavy.next()){
                listvavy.add(reslutVavy.getString(1));
            }
            ResultSet typeResult = this.statement.executeQuery("select nom from personne where sexe=0");
            ArrayList typeList = new ArrayList<String>();
            while (typeResult.next()){
                typeList.add(typeResult.getString(1));
            }

            request.setAttribute("lahy",listLahy);
            request.setAttribute("vavy",listvavy);
            request.setAttribute("type",typeList);
            
            this.connection.close();
            this.statement.close();

        this.getServletContext().getRequestDispatcher(vue).forward( request, response );


        } catch (SQLException e) {
            //TODO: handle exception
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }   

    }
}
