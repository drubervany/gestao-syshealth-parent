package br.com.syshealth.gestao.syshealth.commons;

import java.math.BigDecimal;

public class Contributario {

    private final BigDecimal valor;

    public Contributario(BigDecimal valor) {
        super();
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
