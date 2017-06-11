package br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.google.gson.GsonBuilder;
import com.querydsl.core.annotations.QueryEntity;

import br.com.syshealth.commons.dto.EmpresaSinistro;
import br.com.syshealth.commons.dto.Sinistro;
import br.com.syshealth.commons.utils.Sistema;

@QueryEntity
@Document(collection = "sinistro")
public class GestaoSysHealthSinistroEntity {

    private String id;

    private Integer competencia;

    private EmpresaSinistro empresa;

    public GestaoSysHealthSinistroEntity() {

    }

    public GestaoSysHealthSinistroEntity(Sinistro sinistro) {
        this.setCompetencia(sinistro.getCompetencia());
        this.setEmpresa(sinistro.getEmpresa());
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

    public EmpresaSinistro getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaSinistro empresa) {
        this.empresa = empresa;
    }

    public String toJson() {
        return new GsonBuilder().setDateFormat(Sistema.FORMATO_DATA.getValue()).create().toJson(this);
    }

    public static GestaoSysHealthSinistroEntity fromJson(String json) {
        return new GsonBuilder().setDateFormat(Sistema.FORMATO_DATA.getValue()).create().fromJson(json,
                GestaoSysHealthSinistroEntity.class);
    }
}
