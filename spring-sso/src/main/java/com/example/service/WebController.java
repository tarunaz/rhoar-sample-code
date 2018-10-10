package com.example.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;

import java.security.Principal;

import org.keycloak.common.util.KeycloakUriBuilder;
import org.keycloak.constants.ServiceUrlConstants;


@Controller
public class WebController {
	
	private @Autowired HttpServletRequest request;

    @GetMapping(path = "/")
    public String handleExternal() {
        return "external";
    }

    @GetMapping(path = "/secured")
    public String handleSecured(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        String logoutUri = KeycloakUriBuilder.fromUri("http://localhost:8180/auth").path(ServiceUrlConstants.TOKEN_SERVICE_LOGOUT_PATH)
.queryParam("redirect_uri", "http://localhost:8080/external").build("quickstart").toString();
        model.addAttribute("logout",  logoutUri);
        return "secured";
    }
    
    @GetMapping(value = "/logout")
    public String handleLogout() throws ServletException {
        request.logout();
        return "external";
    }
}
