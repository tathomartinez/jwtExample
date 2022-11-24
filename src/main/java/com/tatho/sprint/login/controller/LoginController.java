package com.tatho.sprint.login.controller;

import com.google.gson.Gson;
import com.tatho.sprint.auth.service.TokenService;
import com.tatho.sprint.login.entity.Usuario;
import com.tatho.sprint.login.service.ILoginService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping()
//@SecurityRequirement(name = "bearerAuth")
public class LoginController {

    public static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private ILoginService loginService;

    @GetMapping("/dev")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> getMensajeDev(Principal principal) {
        var aut = SecurityContextHolder.getContext().getAuthentication();
        log.info("name " + aut.getName());
        log.info("Datos de Usuario " + aut.getPrincipal());
        log.info("Datos de Permisos " + aut.getAuthorities());
        log.info("Autenticado? " + aut.isAuthenticated());
        Map<String, String> output = new HashMap<>();
        output.put("respuesta", "Hola mundo " + principal.getName());
        return ResponseEntity.ok(output);
    }

    @GetMapping
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> getMensaje() {
        var aut = SecurityContextHolder.getContext().getAuthentication();
        log.info("name " + aut.getName());
        log.info("Datos de Usuario " + aut.getPrincipal());
        log.info("Datos de Permisos " + aut.getAuthorities());
        log.info("Autenticado? " + aut.isAuthenticated());
        Map<String, String> output = new HashMap<>();
        output.put("respuesta", "Hola mundo");
        return ResponseEntity.ok(output);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> getMensajeAdmin() {
        var aut = SecurityContextHolder.getContext().getAuthentication();
        log.info("name " + aut.getName());
        log.info("Datos de Usuario " + aut.getPrincipal());
        log.info("Datos de Permisos " + aut.getAuthorities());
        log.info("Autenticado? " + aut.isAuthenticated());
        Map<String, String> output = new HashMap<>();
        output.put("respuesta", "Hola mundo Admin");
        return ResponseEntity.ok(output);
    }

    @GetMapping("/public")
    public ResponseEntity<?> getMensajePublic() {
        var aut = SecurityContextHolder.getContext().getAuthentication();
        log.info("name " + aut.getName());
        log.info("Datos de Usuario " + aut.getPrincipal());
        log.info("Datos de Permisos " + aut.getAuthorities());
        log.info("Autenticado? " + aut.isAuthenticated());
        Map<String, String> output = new HashMap<>();
        output.put("respuesta", "Hola mundo Public");
        return ResponseEntity.ok(output);
    }

    @GetMapping("/login")
    public ResponseEntity<?> loginBasic(Authentication authentication) {
        Map<String, String> output = loginService.login(authentication);
        return ResponseEntity.ok(output);
    }
    @GetMapping("/loginbearer")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> loginBrear(Authentication authentication) {
        Map<String, String> output = loginService.login(authentication);
        return ResponseEntity.ok(output);
    }


}
