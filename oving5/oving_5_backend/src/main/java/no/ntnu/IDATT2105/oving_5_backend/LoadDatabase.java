package no.ntnu.IDATT2105.oving_5_backend;

import no.ntnu.IDATT2105.oving_5_backend.models.CalculatorResponse;
import no.ntnu.IDATT2105.oving_5_backend.repo.CalculationsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration()
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CalculationsRepo calculationsRepo) {

        return args -> {
            log.info("Preloading " + calculationsRepo.save(new CalculatorResponse("4+4=8")));
            //log.info("Preloading: " + loginRepo.save(new LoginRequest("hei", "hallo")));

        };
    }
}
