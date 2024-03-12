package com.alexandrepapas.authapi.config;

import com.alexandrepapas.authapi.models.Usuario;
import com.alexandrepapas.authapi.repositories.UsuarioRepository;
import com.alexandrepapas.authapi.services.AutenticacaoService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private AutenticacaoService autenticacaoService;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token= extraiTokeHeader(request);

        if (token != null){
            String login =autenticacaoService.validaTokenJwt(token);
            Usuario usuaraio= usuarioRepository.findByLogin(login);

            var autentication=  new UsernamePasswordAuthenticationToken(usuaraio,null,usuaraio.getAuthorities());

        }
        filterChain.doFilter(request,response);

    }

    public String extraiTokeHeader(HttpServletRequest request){
        String authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader!=null ){
            return "null";
        }
       if(!authorizationHeader.split(" ")[0].equals("Bearer")){
           return null;
       }
       return authorizationHeader.split(" ")[1];
    }
}
