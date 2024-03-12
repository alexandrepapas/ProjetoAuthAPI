package com.alexandrepapas.authapi.services;

import com.alexandrepapas.authapi.dtos.AuthDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AutenticacaoService  extends UserDetailsService {

    public String obterToken(AuthDto authDto);


    String validaTokenJwt(String token);
}
