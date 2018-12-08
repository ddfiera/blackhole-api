package com.dfiera.blackholeapi.config;

import com.dfiera.blackholeapi.web.HttpsEnforcer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class ApiConfig {
    @Bean
    public Filter httpsEnforcerFilter() {
        return new HttpsEnforcer();
    }
}
