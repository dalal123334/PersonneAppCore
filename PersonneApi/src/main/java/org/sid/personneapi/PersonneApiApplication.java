package org.sid.personneapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@ComponentScan(basePackages = {"org.sid.personneapi", "org.sid.personnecore"})
@EnableJpaRepositories(basePackages = "org.sid.personnecore.repository")
public class PersonneApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonneApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Controllers loaded by Spring:");
            ctx.getBeansOfType(RestController.class).forEach((name, bean) -> {
                System.out.println(name + " of type " + bean.getClass());
            });
        };
    }


}

