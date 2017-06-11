package br.com.syshealth.gestao.syshealth.inbound.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.syshealth.commons.dto.Cadastro;
import br.com.syshealth.commons.dto.Premio;
import br.com.syshealth.commons.dto.Sinistro;
import br.com.syshealth.gestao.syshealth.commons.exception.CoreValidationException;
import br.com.syshealth.gestao.syshealth.core.port.inbound.GestaoBradescoListenerInputService;

@Component
public class GestaoSysHealthListener {

    private static final Logger log = LoggerFactory.getLogger(GestaoSysHealthListener.class);

    @Autowired
    private GestaoBradescoListenerInputService service;

    @JmsListener(destination = "${jms.queue.syshealth.cadastro}")
    public void cadastro(String msg) {

        long tempoInicial = System.currentTimeMillis();

        log.info("Processar mensagem");

        try {
            service.processaMensagem(Cadastro.fromJson(msg));
        } catch (CoreValidationException e) {
            log.error("Erro mensagem {}", e);
        }

        log.info("Mensagem processada");

        log.info("a msg executou em {}", System.currentTimeMillis() - tempoInicial);

    }

    @JmsListener(destination = "${jms.queue.syshealth.fatura}")
    public void fatura(String msg) {

        long tempoInicial = System.currentTimeMillis();

        log.info("Processar mensagem");

        try {
            service.processaMensagem(Premio.fromJson(msg));
        } catch (CoreValidationException e) {
            log.error("Erro mensagem {}", e);
        }

        log.info("Mensagem processada");

        log.info("a msg executou em {}", System.currentTimeMillis() - tempoInicial);

    }

    @JmsListener(destination = "${jms.queue.syshealth.sinistro}")
    public void sinistro(String msg) {

        long tempoInicial = System.currentTimeMillis();

        log.info("Processar mensagem");

        try {
            service.processaMensagem(Sinistro.fromJson(msg));
        } catch (CoreValidationException e) {
            log.error("Erro mensagem {}", e);
        }

        log.info("Mensagem processada");

        log.info("a msg executou em {}", System.currentTimeMillis() - tempoInicial);

    }
}
