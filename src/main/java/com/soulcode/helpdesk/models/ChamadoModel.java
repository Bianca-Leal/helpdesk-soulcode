package com.soulcode.helpdesk.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_CHAMADO")
public class ChamadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID id;
    private int idUsuario;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
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
