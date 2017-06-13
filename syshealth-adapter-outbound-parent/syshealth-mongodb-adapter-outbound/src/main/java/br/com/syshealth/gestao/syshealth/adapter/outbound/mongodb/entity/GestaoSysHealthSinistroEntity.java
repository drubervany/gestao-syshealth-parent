package br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.google.gson.GsonBuilder;
import com.querydsl.core.annotations.QueryEntity;

import br.com.syshealth.commons.dto.Empresa;
import br.com.syshealth.commons.dto.Prestador;
import br.com.syshealth.commons.dto.Procedimento;
import br.com.syshealth.commons.dto.Segurado;
import br.com.syshealth.commons.dto.SubEmpresa;
import br.com.syshealth.commons.enums.RedeReembolsoEnum;
import br.com.syshealth.commons.enums.SimNaoEnum;
import br.com.syshealth.commons.utils.Sistema;

@QueryEntity
@Document(collection = "sinistro")
public class GestaoSysHealthSinistroEntity {

    private String id;

    private Integer competencia;

    private Empresa empresa;

    private SubEmpresa subEmpresa;

    private Segurado segurado;

    private String conta;

    private Date dataAtendimento;

    private Date dataPagamento;

    private String grupoDespesa;

    private Procedimento procedimento;

    private Integer qtdeProcedimento;

    private Prestador prestador;

    private BigDecimal valorSinistro;

    private BigDecimal valorRecibo;

    private BigDecimal valorPago;

    private BigDecimal valorInssIssFajtr;

    private BigDecimal valorInssIssMoeda;

    private String numDocumento;

    private RedeReembolsoEnum redeReembolso;

    private SimNaoEnum internado;

    private String localAtendimento;

    private String crmSolicitante;

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

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getGrupoDespesa() {
        return grupoDespesa;
    }

    public void setGrupoDespesa(String grupoDespesa) {
        this.grupoDespesa = grupoDespesa;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Integer getQtdeProcedimento() {
        return qtdeProcedimento;
    }

    public void setQtdeProcedimento(Integer qtdeProcedimento) {
        this.qtdeProcedimento = qtdeProcedimento;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public BigDecimal getValorSinistro() {
        return valorSinistro;
    }

    public void setValorSinistro(BigDecimal valorSinistro) {
        this.valorSinistro = valorSinistro;
    }

    public BigDecimal getValorRecibo() {
        return valorRecibo;
    }

    public void setValorRecibo(BigDecimal valorRecibo) {
        this.valorRecibo = valorRecibo;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public BigDecimal getValorInssIssFajtr() {
        return valorInssIssFajtr;
    }

    public void setValorInssIssFajtr(BigDecimal valorInssIssFajtr) {
        this.valorInssIssFajtr = valorInssIssFajtr;
    }

    public BigDecimal getValorInssIssMoeda() {
        return valorInssIssMoeda;
    }

    public void setValorInssIssMoeda(BigDecimal valorInssIssMoeda) {
        this.valorInssIssMoeda = valorInssIssMoeda;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public RedeReembolsoEnum getRedeReembolso() {
        return redeReembolso;
    }

    public void setRedeReembolso(RedeReembolsoEnum redeReembolso) {
        this.redeReembolso = redeReembolso;
    }

    public SimNaoEnum getInternado() {
        return internado;
    }

    public void setInternado(SimNaoEnum internado) {
        this.internado = internado;
    }

    public String getLocalAtendimento() {
        return localAtendimento;
    }

    public void setLocalAtendimento(String localAtendimento) {
        this.localAtendimento = localAtendimento;
    }

    public String getCrmSolicitante() {
        return crmSolicitante;
    }

    public void setCrmSolicitante(String crmSolicitante) {
        this.crmSolicitante = crmSolicitante;
    }

    public String toJson() {
        return new GsonBuilder().setDateFormat(Sistema.FORMATO_DATA.getValue()).create().toJson(this);
    }

    public static GestaoSysHealthSinistroEntity fromJson(String json) {
        return new GsonBuilder().setDateFormat(Sistema.FORMATO_DATA.getValue()).create().fromJson(json,
                GestaoSysHealthSinistroEntity.class);
    }
}
