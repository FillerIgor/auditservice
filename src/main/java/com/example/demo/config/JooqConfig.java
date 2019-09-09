package com.example.demo.config;

import com.example.demo.exceptions.ExceptionTranslator;
import org.jooq.DSLContext;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JooqConfig {

    @Bean
    public ExceptionTranslator exceptionTransformer() {
        return new ExceptionTranslator();
    }

    public DefaultConfiguration configuration(DataSourceConnectionProvider connectionProvider) {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(connectionProvider);
        jooqConfiguration
                .set(new DefaultExecuteListenerProvider(exceptionTransformer()));

        return jooqConfiguration;
    }

    @Bean
    public DSLContext dsl(DataSourceConnectionProvider connectionProvider) {
        return new DefaultDSLContext(configuration(connectionProvider));
    }
}
