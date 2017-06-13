package br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.entity;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import com.google.gson.GsonBuilder;
import com.querydsl.core.annotations.QueryEntity;

import br.com.syshealth.commons.dto.Empresa;
import br.com.syshealth.commons.dto.Segurado;
import br.com.syshealth.commons.dto.SubEmpresa;
import br.com.syshealth.commons.utils.Sistema;

@QueryEntity
@Document(collection = "premio")
public class GestaoSysHealthPremioEntity {

    private String id;

    private Integer competencia;

    private Empresa empresa;

    private SubEmpresa subEmpresa;

    private Segurado segurado;

    private BigDecimal valorPremio;

    private BigDecimal valorTaxaAdm;

    private BigDecimal valorRemissao;

    private BigDecimal valorParteSegurado;

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

    public BigDecimal getValorPremio() {
        return valorPremio;
    }

    public void setValorPremio(BigDecimal valorPremio) {
        this.valorPremio = valorPremio;
    }

    public BigDecimal getValorTaxaAdm() {
        return valorTaxaAdm;
    }

    public void setValorTaxaAdm(BigDecimal valorTaxaAdm) {
        this.valorTaxaAdm = valorTaxaAdm;
    }

    public BigDecimal getValorRemissao() {
        return valorRemissao;
    }

    public void setValorRemissao(BigDecimal valorRemissao) {
        this.valorRemissao = valorRemissao;
    }

    public BigDecimal getValorParteSegurado() {
        return valorParteSegurado;
    }

    public void setValorParteSegurado(BigDecimal valorParteSegurado) {
        this.valorParteSegurado = valorParteSegurado;
    }

    public String toJson() {
        return new GsonBuilder().setDateFormat(Sistema.FORMATO_DATA.getValue()).create().toJson(this);
    }

    public static GestaoSysHealthPremioEntity fromJson(String json) {
        return new GsonBuilder().setDateFormat(Sistema.FORMATO_DATA.getValue()).create().fromJson(json,
                GestaoSysHealthPremioEntity.class);
    }

}
