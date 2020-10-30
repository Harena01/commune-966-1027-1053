package etu966_harena;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertMariage extends HttpServlet{
    public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static String vue = "mariage.jsp";


    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        this.getServletContext().getRequestDispatcher(vue).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        MariageForm form = new MariageForm();
		
        Mariage utilisateur;
        utilisateur = form.inscrireMariage( request );
		
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );
		
        this.getServletContext().getRequestDispatcher(vue).forward( request, response );
    }
}