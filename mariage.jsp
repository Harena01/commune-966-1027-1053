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
        <form method="post" action="inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez inscrire via ce formulaire.</p>

                <label for="nom">Nom <span class="requis">*</span></label>
                <input type="nom" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['nom']}</span>
                <br />

                <label for="prenom">Prenom <span class="requis">*</span></label>
                <input type="prenom" id="prenom" name="prenom" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['prenom']}</span>
                <br />

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
    </body>
</html>