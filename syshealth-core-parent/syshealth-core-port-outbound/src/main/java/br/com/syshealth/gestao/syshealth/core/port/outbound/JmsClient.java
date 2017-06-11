package br.com.syshealth.gestao.syshealth.core.port.outbound;

import br.com.syshealth.gestao.syshealth.commons.Contrato;
import br.com.syshealth.gestao.syshealth.commons.exception.CoreValidationException;

public interface JmsClient {

    public void sendContratoIncompleto(Contrato contrato) throws CoreValidationException;
}
