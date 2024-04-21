package com.soulcode.helpdesk.repositories;

import com.soulcode.helpdesk.models.ChamadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<ChamadoModel, Long> {
}
