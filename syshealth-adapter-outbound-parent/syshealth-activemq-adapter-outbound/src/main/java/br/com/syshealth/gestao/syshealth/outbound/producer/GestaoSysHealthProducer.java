package br.com.syshealth.gestao.syshealth.outbound.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import br.com.syshealth.gestao.syshealth.commons.Contrato;
import br.com.syshealth.gestao.syshealth.commons.exception.CoreValidationException;
import br.com.syshealth.gestao.syshealth.core.port.outbound.JmsClient;

@Service
public class GestaoSysHealthProducer implements JmsClient {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void sendContratoIncompleto(Contrato contrato) throws CoreValidationException {
        this.jmsMessagingTemplate.convertAndSend(this.queue, contrato.toJson());
    }
}