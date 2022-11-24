package com.tatho.sprint.login.serviceImpl;

import com.google.gson.Gson;
import com.tatho.sprint.auth.service.TokenService;
import com.tatho.sprint.login.entity.Usuario;
import com.tatho.sprint.login.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements ILoginService {

    public static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private TokenService tokenService;

    @Override
    public Map<String, String> login(Authentication authentication) {
        var aut = SecurityContextHolder.getContext().getAuthentication();
        Gson gson = new Gson();
        Map<String, String> output = new HashMap<>();
        Usuario usuario = new Usuario(aut.getName(), aut.getAuthorities(), new Date(), new Date());
        String token = tokenService.generateToken(authentication);
        output.put("jwt", token);
        output.put("usuario", gson.toJson(usuario));
        return output;
    }
}

