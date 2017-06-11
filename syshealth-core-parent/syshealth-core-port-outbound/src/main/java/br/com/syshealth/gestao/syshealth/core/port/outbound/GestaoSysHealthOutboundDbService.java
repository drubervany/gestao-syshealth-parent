package br.com.syshealth.gestao.syshealth.core.port.outbound;

import br.com.syshealth.commons.dto.Cadastro;
import br.com.syshealth.commons.dto.Premio;
import br.com.syshealth.commons.dto.Sinistro;

/**
 * The Interface IdentificadorOutboundDbService.
 */
public interface GestaoSysHealthOutboundDbService {

    void salvar(Cadastro cadastro);

    void salvar(Premio premio);

    void salvar(Sinistro sinistro);

}
