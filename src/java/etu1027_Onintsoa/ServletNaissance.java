/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etu1027_Onintsoa;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import etu1027_Onintsoa.Naissance;
/**
 *
 * @author ONINTSOA
 */
public class ServletNaissance extends HttpServlet {
        @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	int id = new Integer(request.getParameter("id")).intValue();
	String bouton = (String) request.getParameter("bouton");
	Naissance p = new Naissance();
	p.setId(id);
		try{
			if(bouton.compareTo("edit")==0) {
			p = (Naissance) p.findById(); 
			request.setAttribute("personne", p);
			request.getRequestDispatcher("naissance_formulaire.jsp").forward(request, response);
		}else if(bouton.compareTo("delete")==0){
			p.remove();
			Naissance[] liste = (Naissance[]) new Naissance().find();
			request.setAttribute("liste", liste);
			request.getRequestDispatcher("naissance_liste.jsp").forward(request, response);
		}
		}catch(Exception e){
			
		}finally{
			
		}
	}
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		try{
			Naissance nouveau = new Naissance(request.getParameter("nom"),  request.getParameter("prenom"),	request.getParameter("sexe"),	new Integer(request.getParameter("pere")).intValue(),new Integer(request.getParameter("mere")).intValue(),	request.getParameter("dateNaissance"),	request.getParameter("lieu"));
			nouveau.save();
			Naissance[] liste =  (Naissance[]) new Naissance().find();
			request.setAttribute("liste", liste);
			request.getRequestDispatcher("naissance_liste.jsp").forward(request, response);
		}catch(Exception e){
			
		}finally{}
    }
}
