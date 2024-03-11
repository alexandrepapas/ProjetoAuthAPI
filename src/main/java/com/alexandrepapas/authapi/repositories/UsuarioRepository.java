package com.alexandrepapas.authapi.repositories;

import com.alexandrepapas.authapi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {




    Usuario findByLogin(String login);
}
