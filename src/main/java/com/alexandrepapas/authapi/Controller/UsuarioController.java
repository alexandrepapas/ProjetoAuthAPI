package com.alexandrepapas.authapi.Controller;

import com.alexandrepapas.authapi.dtos.UsuarioDto;
import com.alexandrepapas.authapi.services.UsuarioService;
import com.alexandrepapas.authapi.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    private UsuarioDto salvar(@RequestBody  UsuarioDto usuarioDto){
        return  usuarioService.salvar(usuarioDto);
    }
}
