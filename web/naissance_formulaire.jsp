<%-- 
    Document   : naissance_formulaire
    Created on : 30 oct. 2020, 07:51:38
    Author     : ONINTSOA
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="etu1027_Onintsoa.Naissance" %>
<%@ page import="personne.Personne"%>
<%@ page import ="java.sql.Connection" %>
<%@ page import="utils.Helper" %>
<% 
Connection connection =Helper.getConnection();
Personne[] personneF = (Personne[]) new Personne().findByGenre('F', connection);
Personne[] personneM = (Personne[]) new Personne().findByGenre('M', connection); 
connection.close();
Naissance personne = null; if(request.getAttribute("bouton")!= null){ personne = (Naissance)request.getAttribute("personne");}
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "servletNaissance.jsp" method = "POST">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputNom">Nom</label>
                    <input type="text" class="form-control" id="inputNom" placeholder="Nom" name="nom" value="<% if(personne!= null) {out.print(personne.getNouveau().getNom());}  %>" >
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPrenom">Prenom</label>
                    <input type="text" class="form-control" id="inputPrenom" placeholder="Prenom" name="prenom" value="<% if(personne!= null) {out.print (personne.getNouveau().getPrenom());}  %>">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                     <label for="inputNom">Nom pere</label>
                     <select name=" pere" value="<% if(personne!=null){out.print (personne.getPere().getNom()+" "+personne.getPere().getPrenom());} %>"> </select>
					 <% for (int i=0;i<personneM.length;i++){%>
					 <option value="<%out.print(personneM[i].getId()); %>" > <% out.print(personneM[i].getNom()); %> </option>
					 <% } %>
                </div>
                <div class="form-group col-md-6">
                     <label for="inputNom">Nom mere</label>
                    <select name="mere" value="<% if(personne!=null) {out.print (personne.getMere().getNom()+" "+personne.getMere().getPrenom());} %>"> </select>
					<%for (int i=0;i<personneF.length;i++){%>
					<option value="<% out.print(personneF[i].getNom()) ; %>" > <% out.print(personneF[i].getNom());%> </option>
					<% } %>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="date" name="dateNaissance" value="<% if(personne!= null){out.print (personne.getDateNaissance());}  %>"><!--   date-->
                </div>
                <div class="form-group col-md-6">
                    <input type="text" name="lieu" value="<% if(personne!= null) {out.print (personne.getLieu());}  %>"> <!-- lieu -->
                </div>
            </div>
            <label for="inputNom">Genre</label>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="sexe" id="inlineRadio1" value="F" <% if(personne!= null && personne.getNouveau().getSexe()=="F"){ out.print ("checked");} %>>
                <label class="form-check-label" for="inlineRadio1">Femme</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="sexe" id="inlineRadio2" value="M"  <% if(personne!= null && personne.getNouveau().getSexe()=="M") {out.print ("checked");} %> >
                <label class="form-check-label" for="inlineRadio2">Homme</label>
            </div>
        </form>
    </body>
</html>
