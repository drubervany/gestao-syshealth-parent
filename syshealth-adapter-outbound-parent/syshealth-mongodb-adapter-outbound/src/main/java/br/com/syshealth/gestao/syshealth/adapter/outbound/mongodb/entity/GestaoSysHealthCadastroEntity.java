package br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.google.gson.GsonBuilder;
import com.querydsl.core.annotations.QueryEntity;

import br.com.syshealth.commons.dto.Empresa;
import br.com.syshealth.commons.dto.Segurado;
import br.com.syshealth.commons.dto.SubEmpresa;
import br.com.syshealth.commons.utils.Sistema;

@QueryEntity
@Document(collection = "cadastro")
public class GestaoSysHealthCadastroEntity {

    private String id;

    private Integer competencia;

    private Empresa empresa;

    private SubEmpresa subEmpresa;

    private Segurado segurado;

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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String toJson() {
        return new GsonBuilder().setDateFormat(Sistema.FORMATO_DATA.getValue()).create().toJson(this);
    }

    public static GestaoSysHealthCadastroEntity fromJson(String json) {
        return new GsonBuilder().setDateFormat(Sistema.FORMATO_DATA.getValue()).create().fromJson(json,
                GestaoSysHealthCadastroEntity.class);
    }

    public SubEmpresa getSubEmpresa() {
        return subEmpresa;
    }

    public void setSubEmpresa(SubEmpresa subEmpresa) {
        this.subEmpresa = subEmpresa;
    }

    public Segurado getSegurado() {
        return segurado;
    }

    public void setSegurado(Segurado segurado) {
        this.segurado = segurado;
    }
}
