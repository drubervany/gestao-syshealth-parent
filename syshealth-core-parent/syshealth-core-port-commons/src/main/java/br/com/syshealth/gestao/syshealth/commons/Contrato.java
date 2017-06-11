package br.com.syshealth.gestao.syshealth.commons;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Danilo.Rubervany
 */
public class Contrato {

    private final Long codigo;

    private final BigDecimal LimiteTecnico;

    private final BigDecimal taxaAdministrativa;

    private final Date inicioVigencia;

    private final CoParticipacao coParticipacao;

    private final Contributario contributario;

    public Contrato(Long codigo, BigDecimal limiteTecnico, BigDecimal taxaAdministrativa, Date inicioVigencia,
            CoParticipacao coParticipacao, Contributario contributario) {
        super();
        this.codigo = codigo;
        LimiteTecnico = limiteTecnico;
        this.taxaAdministrativa = taxaAdministrativa;
        this.inicioVigencia = inicioVigencia;
        this.coParticipacao = coParticipacao;
        this.contributario = contributario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public BigDecimal getLimiteTecnico() {
        return LimiteTecnico;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public BigDecimal getTaxaAdministrativa() {
        return taxaAdministrativa;
    }

    public CoParticipacao getCoParticipacao() {
        return coParticipacao;
    }

    public Contributario getContributario() {
        return contributario;
    }

}
