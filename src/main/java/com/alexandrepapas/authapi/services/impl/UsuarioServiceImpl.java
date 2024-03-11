package com.alexandrepapas.authapi.services.impl;

import com.alexandrepapas.authapi.dtos.UsuarioDto;
import com.alexandrepapas.authapi.models.Usuario;
import com.alexandrepapas.authapi.repositories.UsuarioRepository;
import com.alexandrepapas.authapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UsuarioDto salvar(UsuarioDto usuarioDto) {

        Usuario usuarioIfExist= usuarioRepository.findByLogin(usuarioDto.login());
        if (usuarioIfExist !=null){
            throw  new RuntimeException("Usúario Ja Existe");
        }
        Usuario entity= new Usuario(usuarioDto.nome(),usuarioDto.login(),usuarioDto.senha());
        Usuario novoUsuario=usuarioRepository.save(entity);
        return new UsuarioDto(novoUsuario.getNome(), novoUsuario.getLogin(), novoUsuario.getSenha());

    }
}
