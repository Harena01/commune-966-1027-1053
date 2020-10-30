<%@ page import="java.util.ArrayList" %> 
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    ArrayList lahybase = (ArrayList) request.getAttribute("lahy");
    int countL = lahybase.size();
    String[] listeLahy = new String[countL];

    ArrayList vavybase = (ArrayList) request.getAttribute("vavy");
    int countV = vavybase.size();
    String[] listeVavy = new String[countV];

    ArrayList base = (ArrayList) request.getAttribute("type");
    int count = base.size();
    String[] liste = new String[count];
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
                        for(String lahy:listeLahy){ %>
                            <option value="<%=i%>"><%=lahy%> </option>
                        <% } %>
                </select>

            <label for="femme">
               <select name="femme"> 
                    <%  
                        for(int i = 1 ; i <= countV ; i++){ %>
                            <option value="<%=i%>"><%=listeVavy[i]%> </option>
                        <% } %>
                </select>

            <label for="type">
               <select name="type"> 
                    <%  
                        for(int i = 1 ; i <= count ; i++){ %>
                            <option value="<%=i%>"><%=liste[i]%> </option>
                        <% } %>
                </select>

        <label for="nom">Nom famille </label>
        <input name="nom" type="text">


        <input name="valider" type="submit" value="conf">
        </form>
    </body>
</html>