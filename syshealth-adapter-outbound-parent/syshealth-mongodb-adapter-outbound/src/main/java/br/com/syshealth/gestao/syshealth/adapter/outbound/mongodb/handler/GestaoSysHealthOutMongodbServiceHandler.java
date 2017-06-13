package br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.syshealth.commons.dto.Cadastro;
import br.com.syshealth.commons.dto.Premio;
import br.com.syshealth.commons.dto.Sinistro;
import br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.entity.GestaoSysHealthCadastroEntity;
import br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.entity.GestaoSysHealthPremioEntity;
import br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.entity.GestaoSysHealthSinistroEntity;
import br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.repository.GestaoSysHealthOutPremioRepository;
import br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.repository.GestaoSysHealthOutSeguradoRepository;
import br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.repository.GestaoSysHealthOutSinistroRepository;
import br.com.syshealth.gestao.syshealth.core.port.outbound.GestaoSysHealthOutboundDbService;

@Service
public class GestaoSysHealthOutMongodbServiceHandler implements GestaoSysHealthOutboundDbService {

    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(GestaoSysHealthOutMongodbServiceHandler.class);

    /** The dao. */
    @Autowired
    private GestaoSysHealthOutSeguradoRepository repositoryCadastro;

    /** The dao. */
    @Autowired
    private GestaoSysHealthOutPremioRepository repositoryPremio;

    /** The dao. */
    @Autowired
    private GestaoSysHealthOutSinistroRepository repositorySinistro;

    @Override
    public void salvar(Premio premio) {
        log.info("salvar premio");

        GestaoSysHealthPremioEntity dto = GestaoSysHealthPremioEntity.fromJson(premio.toJson());
        repositoryPremio.save(dto);

        log.info("premio salvo!");
    }

    @Override
    public void salvar(Cadastro cadastro) {
        log.info("salvar segurado");

        GestaoSysHealthCadastroEntity dto = GestaoSysHealthCadastroEntity.fromJson(cadastro.toJson());
        repositoryCadastro.save(dto);

        log.info("segurado salvo!");
    }

    @Override
    public void salvar(Sinistro sinistro) {
        log.info("salvar sinistro");

        GestaoSysHealthSinistroEntity dto = GestaoSysHealthSinistroEntity.fromJson(sinistro.toJson());
        repositorySinistro.save(dto);

        log.info("sinistro sinistro!");
    }
}
