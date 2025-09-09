/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SwmApplication {
    private static Logger log = LogManager.getLogger(SwmApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SwmApplication.class, args);
    }

    @Bean
    @Profile("dev")
    /**
     * A Bean factory - development only
     * <p>
     * CommandLineRunner and ApplicationRunner beans are automatically executed when
     * the context is ready.
     * 
     * @param ctx the context in which the bean is going to be registered
     * @return the generated bean
     */
    protected CommandLineRunner beanCounter(ApplicationContext ctx) {
        log.trace("Generating a simple bean");
        CommandLineRunner bean = args -> log.debug("The bean counter sees {} available beans",
                ctx.getBeanDefinitionCount());
        return bean;
    }

    @Bean
    @Profile("prod")
    protected CommandLineRunner welcomer(ApplicationContext ctx) {
        log.trace("Generating a very simple bean");
        return args -> log.warn("Just as an example");
    }
}
