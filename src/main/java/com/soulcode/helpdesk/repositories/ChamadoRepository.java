package com.soulcode.helpdesk.repositories;

import com.soulcode.helpdesk.models.ChamadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<ChamadoModel, Long> {

    @Query("SELECT c FROM ChamadoModel c WHERE c.chamadoStatus = :status")
    List<ChamadoModel> findByStatus(@Param("status") String status);
}
