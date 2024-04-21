package com.soulcode.helpdesk.repositories;

import com.soulcode.helpdesk.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    List<UsuarioModel> findByLogin(String login);
}
