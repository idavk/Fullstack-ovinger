package no.ntnu.IDATT2105.oving_5_backend.controller;

import no.ntnu.IDATT2105.oving_5_backend.models.Calculator.Calculation;
import no.ntnu.IDATT2105.oving_5_backend.repo.CalculationsRepo;
import no.ntnu.IDATT2105.oving_5_backend.repo.UserRepo;
import no.ntnu.IDATT2105.oving_5_backend.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private CalculatorService calculationService;

    @Autowired
    CalculationsRepo calculationRepository;

    @Autowired
    UserRepo userRepository;

        Logger logger = LoggerFactory.getLogger(Controller.class);

        @PostMapping("/user/calculate")
        public Calculation PostCalculationWithUser(@RequestBody Calculation object, Authentication authentication) {

            logger.info("Calculation recieved: " + object.getCalculation());
            calculationService.calculate(object);
            if(object.getAnswer() == null){
                logger.info("The calculation led to an error");
                return object;
            }
            logger.info("Answer calculated: " + object.getAnswer());

            if(authentication.isAuthenticated()){
                object.setIdUser(userRepository.findByUsername(authentication.getName()).getIdUser());
                calculationRepository.save(object);
            }

            return object;
        }
        @PostMapping  ("/calculate")
        public Calculation PostCalculation(@RequestBody Calculation object) {

            logger.info("Calculation recieved: " + object.getCalculation());
            calculationService.calculate(object);
            if(object.getAnswer() == null){
                logger.info("The calculation led to an error");
                return object;
            }
            logger.info("Answer calculated: " + object.getAnswer());

            return object;
        }

        @GetMapping("/getCalculations")
        public ArrayList<String> getCalculations(Authentication authentication){
            int userId = userRepository.findByUsername(authentication.getName()).getIdUser();
            List<Calculation> calculations = calculationRepository.findAllByidUser(userId);

            ArrayList<String> stringList = new ArrayList<>();
            for(Calculation c : calculations){
                stringList.add(c.getCalculation() + "=" + c.getAnswer());
            }

            return stringList;

        }
}
