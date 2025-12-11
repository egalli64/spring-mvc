/*
 * Spring Boot Web MVC tutorial
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SwmApplication {
    private static final Logger log = LoggerFactory.getLogger(SwmApplication.class);

    static void main(String[] args) {
        SpringApplication.run(SwmApplication.class, args);
    }

    /**
     * A Bean factory - development only
     * <p>
     * CommandLineRunner and ApplicationRunner beans are automatically executed when
     * the context is ready.
     *
     * @param ctx the context in which the bean is going to be registered
     * @return the generated bean
     */
    @Bean
    @Profile("dev")
    protected CommandLineRunner beanCounter(ApplicationContext ctx) {
        log.trace("Generating a simple bean");
        return _ -> log.debug("The bean counter sees {} available beans",
                ctx.getBeanDefinitionCount());
    }

    @Bean
    @Profile("prod")
    protected CommandLineRunner welcome() {
        log.trace("Generating a very simple bean");
        return _ -> log.warn("Just as an example");
    }
}
