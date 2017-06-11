package br.com.syshealth.gestao.syshealth.core.port.inbound;

import br.com.syshealth.commons.dto.Cadastro;
import br.com.syshealth.commons.dto.Premio;
import br.com.syshealth.commons.dto.Sinistro;
import br.com.syshealth.gestao.syshealth.commons.exception.CoreValidationException;

/**
 * The Interface IdentificadorInputService.
 * 
 * @author Danilo.Rubervany
 */
public interface GestaoBradescoListenerInputService {

    void processaMensagem(Cadastro cadastro) throws CoreValidationException;

    void processaMensagem(Premio premio) throws CoreValidationException;

    void processaMensagem(Sinistro sinistro) throws CoreValidationException;
}
