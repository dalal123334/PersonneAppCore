package org.sid.personneapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("org.sid.personnecore.repository")
@EntityScan("org.sid.personnecore.module")
@ComponentScan(basePackages = {"org.sid.personneapi", "org.sid.personnecore"})
public class PersonneApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonneApiApplication.class, args);
    }


}

