package no.ntnu.IDATT2105.oving_5_backend.service;

import no.ntnu.IDATT2105.oving_5_backend.controller.CalculationsController;
import no.ntnu.IDATT2105.oving_5_backend.models.Calculator.CalculatorRequest;
import no.ntnu.IDATT2105.oving_5_backend.models.Calculator.CalculatorResponse;
import no.ntnu.IDATT2105.oving_5_backend.models.User.User;
import no.ntnu.IDATT2105.oving_5_backend.repo.CalculationsRepo;
import no.ntnu.IDATT2105.oving_5_backend.repo.LoginRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    static CalculationsRepo calculationsRepo;
    @Autowired
    static LoginRepo loginRepo;

    CalculatorService(CalculationsRepo calculationsRepo, LoginRepo loginRepo ) {
        this.calculationsRepo = calculationsRepo;
        this.loginRepo = loginRepo;
    }
    private static final Logger LOGGER = LogManager.getLogger(CalculationsController.class);
    String calculation;
    ArrayList<CalculatorResponse> calculations = new ArrayList();
    public List<CalculatorResponse> getCalculations() {
        return this.calculationsRepo.findAll();
    }

    public CalculatorResponse doCalculation(final @RequestBody CalculatorRequest calculatorRequest, Long userId) {
        LOGGER.info("Henter tall fra frontend:");
        float a = Float.parseFloat(calculatorRequest.getFirstNumber());
        float b = Float.parseFloat(calculatorRequest.getSecondNumber());
        String operatorSign = null;
        float result = 0;
        if (calculatorRequest.getOperator() != null) {
            switch (calculatorRequest.getOperator()) {
                case "plus":
                    result = (a + b);
                    operatorSign = "+";
                    break;
                case "minus":
                    result = (a - b);
                    operatorSign = "-";
                    break;
                case "divide":
                    result = a / b;
                    operatorSign = "÷";
                    break;
                case "multiply":
                    result = a * b;
                    operatorSign = "×";
                    break;
            }
            this.calculation = a + " " + operatorSign + " " + b + " = " + result;
            var user = loginRepo.findById(userId);
            if(user.isEmpty()) {
                return null;
            }
            var calcResponse =new CalculatorResponse(this.calculation);
            calculationsRepo.save(calcResponse);
            calculations.add(calcResponse);


            LOGGER.info("Dette er resultatet: " + this.calculation);
            return calcResponse;


        }
        return null;

    }

    /**public ArrayList<CalculatorResponse> returnInJson() {
        calculations.add(new CalculatorResponse(this.calculation));
        return calculations;

    }*/
}
