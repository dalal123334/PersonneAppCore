package org.sid.personneapi;

import org.sid.personnecore.module.Personne;
import org.sid.personnecore.repository.PersonneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
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
    @Bean
    CommandLineRunner start(PersonneRepository personneRepository) {
        return args -> {
            Personne p1 = new Personne(1L, "dalal", "akerraz","cas",33,"dalal@gmail.com");

            personneRepository.save(p1);

            System.out.println("Personnes enregistrées avec succès !");
        };
    }

}

