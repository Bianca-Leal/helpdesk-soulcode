package com.soulcode.helpdesk.repositories;

import com.soulcode.helpdesk.models.ChamadoModel;
import com.soulcode.helpdesk.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<ChamadoModel, Long> {
    List<ChamadoModel> findByIdUsuario(Long idUsuario);
}
