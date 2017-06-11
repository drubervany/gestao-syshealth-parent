package br.com.syshealth.gestao.syshealth.adapter.inbound.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.syshealth.gestao.syshealth.adapter.inbound.mongodb.entity.GestaoSysHealthContratoEntity;
import br.com.syshealth.gestao.syshealth.commons.Contrato;

public interface GestaoSysHealthRepository extends MongoRepository<GestaoSysHealthContratoEntity, String> {

    GestaoSysHealthContratoEntity findByContrato(Contrato contrato);

}
