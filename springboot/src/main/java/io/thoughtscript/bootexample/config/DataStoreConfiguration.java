package io.thoughtscript.bootexample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("io.thoughtscript.bootexample")
@EnableTransactionManagement
@EnableJpaRepositories("io.thoughtscript.bootexample.repositories")
public class DataStoreConfiguration {
    // Handled solely through application.yml now.
}
