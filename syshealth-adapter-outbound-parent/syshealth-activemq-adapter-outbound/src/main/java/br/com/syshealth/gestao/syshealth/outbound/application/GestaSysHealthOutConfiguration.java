package br.com.syshealth.gestao.syshealth.outbound.application;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class GestaSysHealthOutConfiguration {

    @Value("${jms.queue.destination.contrato}")
    private String queue;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(queue);
    }
}