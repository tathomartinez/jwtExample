package com.tatho.sprint.login.entity;

import java.util.Date;

public record Usuario(String name, Object credentials, Date lastAccess, Date suscribeExpiration){
}

