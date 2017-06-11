package br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.syshealth.gestao.syshealth.adapter.outbound.mongodb.entity.GestaoSysHealthCadastroEntity;

public interface GestaoSysHealthOutSeguradoRepository extends MongoRepository<GestaoSysHealthCadastroEntity, String> {

    GestaoSysHealthCadastroEntity findByCompetencia(Integer competencia);

}
