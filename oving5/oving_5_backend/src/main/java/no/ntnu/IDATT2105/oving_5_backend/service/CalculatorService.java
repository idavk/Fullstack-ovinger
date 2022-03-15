package no.ntnu.IDATT2105.oving_5_backend.service;

import no.ntnu.IDATT2105.oving_5_backend.controller.CalculatorController;
import no.ntnu.IDATT2105.oving_5_backend.models.CalculatorRequest;
import no.ntnu.IDATT2105.oving_5_backend.models.CalculatorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class CalculatorService {
    private static final Logger LOGGER = LogManager.getLogger(CalculatorController.class);
    String calculation;
    ArrayList<CalculatorResponse> calculations = new ArrayList();

    public CalculatorResponse doCalculation(final @RequestBody CalculatorRequest calculatorRequest) {
        LOGGER.info("Henter tall fra frontend");
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
            LOGGER.info("Henter første tall: " + calculatorRequest.getFirstNumber());
            LOGGER.info("Henter operator: " + calculatorRequest.getOperator());
            LOGGER.info("Henter andre tall: " + calculatorRequest.getSecondNumber());
            LOGGER.info("Utfører utregning...");
            this.calculation = a + " " + operatorSign + " " + b + " = " + result;
            LOGGER.info("Svaret er: " + this.calculation);

        }
        return new CalculatorResponse(this.calculation);

    }

    public ArrayList<CalculatorResponse> returnInJson() {
        calculations.add(new CalculatorResponse(this.calculation));
        return calculations;

    }
}
