package br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.entity.GestaoSysHealthSinistroEntity;

public interface GestaoSysHealthOutSinistroRepository extends MongoRepository<GestaoSysHealthSinistroEntity, String> {

    @Query(value = "{'sinistro.competencia': ?0}")
    GestaoSysHealthSinistroEntity find(Integer competencia);

}
