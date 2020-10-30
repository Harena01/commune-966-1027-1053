<%@page import="java.util.ArrayList"%>
<%@page import="etu966_harena.Personne"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    ArrayList lahybase = (ArrayList) request.getAttribute("lahy");
    int countL = lahybase.size();
    String[] listeLahy = new String[countL];

    Personne[] perso = (Personne[]) request.getAttribute("personne");
    String[] lahy = Personne.getName(perso,"homme");
    String[] vavy = Personne.getName(perso,"femme");

    int[] idLahy = Personne.getId(perso,"homme");
    int[] idVavy = Personne.getId(perso,"femme");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="mariage">
            <label for="homme">
               <select name="homme"> 
                    <%  
                        for(int i = 0 ; i < lahy.length ; i++){ %>
                            <option value="<%=idLahy[i]%>"><%=lahy[i]%> </option>
                        <% } %>
                </select>

            <label for="femme">
               <select name="femme"> 
                    <%  
                        for(int i = 0 ; i < vavy.length ; i++){ %>
                            <option value="<%=idVavy[i]%>"><%=vavy[i]%> </option>
                        <% } %>
                </select>

        <label for="nom">Nom famille </label>
        <input name="nom" type="text">


        <input name="valider" type="submit" value="conf">
        </form>
    </body>
</html>