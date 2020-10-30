<%-- 
    Document   : naissance_liste
    Created on : 30 oct. 2020, 07:54:29
    Author     : ONINTSOA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "etu1027_Onintsoa.Naissance" %>
<% Naissance[] liste = (Naissance[]) new Naissance().find(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <body>
        <h1>Liste des actes de naissance</h1>
		<nav class="nav">
			<%if(request.getSession()!=null){%><a class="nav-link" href="naissance_fomulaire.jsp">Ajouter</a> <% } %>
			<a class="nav-link" href="#">Voir liste</a>
		</nav>
        <table class="table">
	  <thead class="thead-dark">
		<tr>
		  <th scope="col">Nom</th>      
		  <th scope="col">Prenom</th>
		  <th scope="col">Sexe</th>
		  <th scope="col">Date de naissance</th>
		  <th scope="col">Lieu de naissance</th>
		  <th scope="col">Nom du pere</th>
		  <th scope="col">Nom de la mere</th>
		</tr>
	  </thead>
	  <tbody>
		  <% for(int i=0; i<liste.length; i++){ %>
		<tr>
		  <th scope="row">1</th>
			<td> <% out.print(liste[i].getId()) ;  %> </td>	
			<td> <% out.print(liste[i].getNouveau().getNom());  %> </td>
			<td>  <% out.print(liste[i].getNouveau().getPrenom());  %> </td>
			<td> <% out.print(liste[i].getNouveau().getSexe());   %>  </td>
			<td> <% out.print(liste[i].getDateNaissance());   %>  </td>
			<td> <% out.print(liste[i].getLieu());   %>  </td>
			<td> <% out.print(liste[i].getPere().getNom()+" "+liste[i].getPere().getPrenom());   %>  </td>
			<td> <% out.print(liste[i].getMere().getNom()+" "+liste[i].getMere().getPrenom());  %>  </td>
			<form action="servletNaissance.jsp" method="GET">
			<%if(request.getSession()!=null){%><td> <input type="hidden" name="id" value="<% out.print(liste[i].getId());  %> ">  </td>
			<td> <button type="button" class="btn btn-primary"><input type="submit" name="bouton" value="edit"> Edit</button></td>
			<td> <button type="button" class="btn btn-primary" > <input type="submit" name="bouton" value="delete"> Delete</button>  </td> <% } %>
			</form>
		</tr>
		<% } %>
	  </tbody>
	</table>
    </body>
    </body>
</html>

