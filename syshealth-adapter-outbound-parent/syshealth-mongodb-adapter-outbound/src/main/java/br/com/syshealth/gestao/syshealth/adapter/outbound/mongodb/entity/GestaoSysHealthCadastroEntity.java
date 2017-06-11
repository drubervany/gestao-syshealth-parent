package br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.google.gson.GsonBuilder;
import com.querydsl.core.annotations.QueryEntity;

import br.com.syshealth.commons.dto.Cadastro;
import br.com.syshealth.commons.dto.EmpresaCadastro;
import br.com.syshealth.commons.utils.Sistema;

@QueryEntity
@Document(collection = "cadastro")
public class GestaoSysHealthCadastroEntity {

    private String id;

    private Integer competencia;

    private EmpresaCadastro empresa;

    public GestaoSysHealthCadastroEntity() {
    }

    public GestaoSysHealthCadastroEntity(Cadastro cadastro) {
        this.competencia = cadastro.getCompetencia();
        this.empresa = cadastro.getEmpresa();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Integer competencia) {
        this.competencia = competencia;
    }

    public EmpresaCadastro getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaCadastro empresa) {
        this.empresa = empresa;
    }

    public String toJson() {
        return new GsonBuilder().setDateFormat(Sistema.FORMATO_DATA.getValue()).create().toJson(this);
    }

    public static GestaoSysHealthCadastroEntity fromJson(String json) {
        return new GsonBuilder().setDateFormat(Sistema.FORMATO_DATA.getValue()).create().fromJson(json,
                GestaoSysHealthCadastroEntity.class);
    }
}
