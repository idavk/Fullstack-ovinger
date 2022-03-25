package no.ntnu.IDATT2105.oving_5_backend;

import no.ntnu.IDATT2105.oving_5_backend.models.Calculator.CalculatorResponse;
import no.ntnu.IDATT2105.oving_5_backend.models.User.User;
import no.ntnu.IDATT2105.oving_5_backend.repo.CalculationsRepo;
import no.ntnu.IDATT2105.oving_5_backend.repo.LoginRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration()
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CalculationsRepo calculationsRepo, LoginRepo loginRepo) {

        return args -> {
            log.info("Preloading: " + loginRepo.save(new User("hei", "hallo")));
            log.info("Preloading: " + loginRepo.save(new User("user", "pass")));
            User testuser = loginRepo.findByUsernameAndPassword("user", "pass");
            log.info("Preloading: " + calculationsRepo.save(new CalculatorResponse("2+2=4", testuser)));

        };
    }
}
