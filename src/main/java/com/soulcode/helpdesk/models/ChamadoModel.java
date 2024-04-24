package com.soulcode.helpdesk.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_CHAMADO")
@Getter @Setter
public class ChamadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private Long idUsuario;
    @Column
    private String setor;
    @Column
    private String descricao;
    @Column
    private String prioridade;
    @Column
    private String dataInicio;
    @Column
    private String chamadoStatus;

    public ChamadoModel() {
    }
}
