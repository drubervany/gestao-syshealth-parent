package br.com.syshealth.gestao.syshealth.adapter.inbound.mongodb.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.syshealth.gestao.syshealth.adapter.inbound.mongodb.entity.GestaoSysHealthContratoEntity;
import br.com.syshealth.gestao.syshealth.adapter.inbound.mongodb.repository.GestaoSysHealthRepository;
import br.com.syshealth.gestao.syshealth.commons.Contrato;
import br.com.syshealth.gestao.syshealth.core.port.inbound.GestaoSysHealthInboundDbService;

@Service
public class GestaoSysHealthInMongodbServiceHandler implements GestaoSysHealthInboundDbService {

    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(GestaoSysHealthInMongodbServiceHandler.class);

    /** The dao. */
    @Autowired
    private GestaoSysHealthRepository repository;

    @Override
    public Contrato pesquisaContrato(Long contrato) {
        log.info("pesquisaContrato {}", contrato);

        Contrato contratoFind = new Contrato(contrato, null, null, null, null, null);
        GestaoSysHealthContratoEntity contratoEntity = repository.findByContrato(contratoFind);

        log.info("GestaoSysHealthContratoEntity {}", contratoEntity);

        if (contratoEntity == null)
            return null;

        return contratoEntity.getContrato();
    }

}
