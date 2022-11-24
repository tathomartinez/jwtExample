package com.tatho.sprint.login.service;


import org.springframework.security.core.Authentication;

import java.util.Map;

public interface ILoginService {
    public Map<String, String> login(Authentication authentication);
}