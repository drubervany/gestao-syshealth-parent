package br.com.syshealth.gestao.syshealth.inbound.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "br.com.syshealth.gestao.syshealth" })
@SpringBootApplication
public class GestaoSysHealthApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestaoSysHealthApplication.class, args);
    }

}
