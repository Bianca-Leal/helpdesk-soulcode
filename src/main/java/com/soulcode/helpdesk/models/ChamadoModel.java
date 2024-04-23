package com.soulcode.helpdesk.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CHAMADO")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getChamadoStatus() {
        return chamadoStatus;
    }

    public void setChamadoStatus(String chamadoStatus) {
        this.chamadoStatus = chamadoStatus;
    }

    public ChamadoModel() {
    }
}
