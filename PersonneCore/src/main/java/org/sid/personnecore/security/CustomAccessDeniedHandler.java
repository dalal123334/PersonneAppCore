package org.sid.personnecore.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {

        // Définir le statut de la réponse HTTP à 403 (Forbidden)
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        // Définir le type de contenu à JSON
        response.setContentType("application/json");

        // Créer la réponse JSON
        String jsonResponse = "{"
                + "\"error\": \"Forbidden\","
                + "\"message\": \"Vous n'avez pas cette autorité pour accéder à cette ressource.\","
                + "\"status\": 403"
                + "}";

        // Renvoyer la réponse JSON
        response.getWriter().write(jsonResponse);
    }
}
