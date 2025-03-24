package org.sid.personneapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "org.sid")
//@EntityScan(basePackages = "org.sid.personnecore.module")
@EnableJpaRepositories(basePackages = "org.sid.personnecore.repository")
public class PersonneApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonneApiApplication.class, args);
    }

}

