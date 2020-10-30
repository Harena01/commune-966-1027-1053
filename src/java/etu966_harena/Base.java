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
            ResultSet result = this.statement.executeQuery("select * from personne");
            ArrayList[] list = new ArrayList[8];
            for (int i = 0 ; i < 8 ; i++){
                while(result.next()){
                    int id = 0;
                    list[i].add(result.getString(id));
                    id++;
                }
            }
            Personne[] perso = Personne.array(list,8);
            
            request.setAttribute("personne",perso);
            
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
