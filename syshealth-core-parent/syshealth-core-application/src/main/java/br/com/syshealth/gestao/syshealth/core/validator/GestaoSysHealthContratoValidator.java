package br.com.syshealth.gestao.syshealth.core.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.syshealth.gestao.syshealth.commons.Contrato;
import br.com.syshealth.gestao.syshealth.commons.exception.CoreValidationException;
import br.com.syshealth.gestao.syshealth.core.port.inbound.GestaoSysHealthInboundDbService;
import br.com.syshealth.gestao.syshealth.core.port.outbound.JmsClient;

/**
 * The Class IdentificadorValidator.
 * 
 * @author Danilo.Rubervany
 */
@Service
public class GestaoSysHealthContratoValidator {

    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(GestaoSysHealthContratoValidator.class);

    @Autowired
    GestaoSysHealthInboundDbService dbInService;

    @Autowired
    JmsClient jsmService;

    public GestaoSysHealthContratoValidator() {

    }

    public void validar(Long codigoContrato) throws CoreValidationException {
        log.info("inicio validar");

        Contrato contrato = dbInService.pesquisaContrato(codigoContrato);
        if (contrato == null) {
            contrato = new Contrato(codigoContrato, null, null, null, null, null);
            jsmService.sendContratoIncompleto(contrato);
        }

        log.info("Fim validar");
    }
}
