package br.com.syshealth.gestao.syshealth.core.port.inbound;

import br.com.syshealth.gestao.syshealth.commons.Contrato;

/**
 * The Interface IdentificadorInputService.
 * 
 * @author Danilo.Rubervany
 */
public interface GestaoSysHealthInboundDbService {

    Contrato pesquisaContrato(Long contrato);
}
