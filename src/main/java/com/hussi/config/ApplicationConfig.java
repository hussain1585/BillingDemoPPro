package com.hussi.config;


import com.hussi.domain.BillingPeriod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.HashMap;

@EnableAsync
@Configuration
public class ApplicationConfig {

    @Bean
    public HashMap<String, BillingPeriod> getPeriodCache(){
        return new HashMap<>();
    }
}
