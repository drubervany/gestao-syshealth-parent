package br.com.syshealth.gestao.syshealth.commons;

import java.math.BigDecimal;

import br.com.syshealth.commons.enums.CoParticipacaoRevertidaEnum;

public class CoParticipacao {

    private final CoParticipacaoRevertidaEnum revertida;

    private final BigDecimal valorConsultaPs;

    private final BigDecimal valorExamesSimples;

    private final BigDecimal valorExamesEspeciais;

    private final BigDecimal valorTerapia;

    private final BigDecimal valorLimitado;

    public CoParticipacao(CoParticipacaoRevertidaEnum revertida, BigDecimal valorConsultaPs, BigDecimal valorExamesSimples,
            BigDecimal valorExamesEspeciais, BigDecimal valorTerapia, BigDecimal valorLimitado) {
        super();
        this.revertida = revertida;
        this.valorConsultaPs = valorConsultaPs;
        this.valorExamesSimples = valorExamesSimples;
        this.valorExamesEspeciais = valorExamesEspeciais;
        this.valorTerapia = valorTerapia;
        this.valorLimitado = valorLimitado;
    }

    public CoParticipacaoRevertidaEnum getRevertida() {
        return revertida;
    }

    public BigDecimal getValorConsultaPs() {
        return valorConsultaPs;
    }

    public BigDecimal getValorExamesSimples() {
        return valorExamesSimples;
    }

    public BigDecimal getValorExamesEspeciais() {
        return valorExamesEspeciais;
    }

    public BigDecimal getValorTerapia() {
        return valorTerapia;
    }

    public BigDecimal getValorLimitado() {
        return valorLimitado;
    }

}
