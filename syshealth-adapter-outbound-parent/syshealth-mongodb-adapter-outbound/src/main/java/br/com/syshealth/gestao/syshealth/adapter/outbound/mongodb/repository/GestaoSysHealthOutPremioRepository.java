package br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.entity.GestaoSysHealthPremioEntity;

public interface GestaoSysHealthOutPremioRepository extends MongoRepository<GestaoSysHealthPremioEntity, String> {

    @Query(value = "{'premio.competencia': ?0}")
    GestaoSysHealthPremioEntity find(Integer competencia);
}
