package etu966_harena;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertMariage extends HttpServlet{
    public static String vue = "/mariage.jsp";


    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        this.getServletContext().getRequestDispatcher(vue).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        MariageForm form = new MariageForm();
		
        Mariage utilisateur;
        utilisateur = form.inscrireMariage( request ); 
        PrintWriter out = response.getWriter();
        out.print(utilisateur.getPrenom());
        request.setAttribute( "form", form );
        request.setAttribute( "utilisateur", utilisateur );
		
        this.getServletContext().getRequestDispatcher(vue).forward( request, response );
    }
}