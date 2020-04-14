package com.example.demo.config;

import com.example.demo.exceptions.ExceptionTranslator;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class JooqConfig {

    @Value("${spring.jooq.sql-dialect}")
    private String sqlDialect;

    @Bean
    public ExceptionTranslator exceptionTransformer() {
        return new ExceptionTranslator();
    }

    //todo try to use default spring boot jooq starter
    @Bean
    public DSLContext dsl(DataSourceConnectionProvider connectionProvider) {
        return new DefaultDSLContext(configuration(connectionProvider));
    }

    @Bean
    public DataSourceConnectionProvider connectionProvider(DataSource dataSource) {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    public DefaultConfiguration configuration(DataSourceConnectionProvider connectionProvider) {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(connectionProvider);
        jooqConfiguration.set(new DefaultExecuteListenerProvider(exceptionTransformer()));

        SQLDialect dialect = SQLDialect.valueOf(sqlDialect);
        jooqConfiguration.set(dialect);

        return jooqConfiguration;
    }
}
