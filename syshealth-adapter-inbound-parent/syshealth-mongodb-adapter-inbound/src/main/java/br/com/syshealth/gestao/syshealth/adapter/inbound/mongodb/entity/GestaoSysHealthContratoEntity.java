package br.com.syshealth.gestao.syshealth.adapter.inbound.mongodb.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import br.com.syshealth.gestao.syshealth.commons.Contrato;

@QueryEntity
@Document(collection = "contrato")
public class GestaoSysHealthContratoEntity {

    private String id;

    private Contrato contrato;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
