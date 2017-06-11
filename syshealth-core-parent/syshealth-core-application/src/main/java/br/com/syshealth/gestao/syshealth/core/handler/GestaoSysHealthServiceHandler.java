package br.com.syshealth.gestao.syshealth.core.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.syshealth.commons.dto.Cadastro;
import br.com.syshealth.commons.dto.Premio;
import br.com.syshealth.commons.dto.Sinistro;
import br.com.syshealth.gestao.syshealth.commons.exception.CoreValidationException;
import br.com.syshealth.gestao.syshealth.core.port.inbound.GestaoBradescoListenerInputService;
import br.com.syshealth.gestao.syshealth.core.port.outbound.GestaoSysHealthOutboundDbService;
import br.com.syshealth.gestao.syshealth.core.validator.GestaoSysHealthContratoValidator;

@Service
public class GestaoSysHealthServiceHandler implements GestaoBradescoListenerInputService {

    @Autowired
    GestaoSysHealthOutboundDbService dbOutService;

    @Autowired
    GestaoSysHealthContratoValidator contratoValidator;

    @Override
    public void processaMensagem(Cadastro cadastro) throws CoreValidationException {

        dbOutService.salvar(cadastro);
    }

    @Override
    public void processaMensagem(Premio premio) throws CoreValidationException {

        contratoValidator.validar(premio.getEmpresa().getContrato());
        dbOutService.salvar(premio);
    }

    @Override
    public void processaMensagem(Sinistro sinistro) throws CoreValidationException {

        contratoValidator.validar(sinistro.getEmpresa().getContrato());
        dbOutService.salvar(sinistro);
    }
}
