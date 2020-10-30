<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="mariage">
            <fieldset>
                <legend>Mariage</legend>
                <p>Vous pouvez inscrire via ce formulaire.</p>

                <label for="nom">Nom</label>
                <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
                <br />

                <label for="prenom">Prenom <span class="requis"></span></label>
                <input type="prenom" id="prenom" name="prenom" value="<c:out value="${utilisateur.prenom}"/>" size="20" maxlength="20" />
                <br />

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                <%
                    if(request.getAttribute(form) != null)
                    out.print(request.getAttribute(form));
                %>
            </fieldset>
        </form>
    </body>
</html>