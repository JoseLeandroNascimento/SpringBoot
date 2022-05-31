package com.projeto.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AplicationConfiguration {

    @Bean(name="applicationName")
    public String applicationName(){

        return "Sistema de vendas";
    }
    
}
