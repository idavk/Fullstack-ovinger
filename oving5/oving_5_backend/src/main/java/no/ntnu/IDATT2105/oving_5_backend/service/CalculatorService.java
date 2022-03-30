package no.ntnu.IDATT2105.oving_5_backend.service;

import no.ntnu.IDATT2105.oving_5_backend.models.Calculator.Calculation;
import org.springframework.stereotype.Service;


@Service
public class CalculatorService {

    public void calculate(Calculation cal){

        String[] equation = cal.getCalculation().split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
        if(equation.length != 3){
            return;
        }
        int a = Integer.parseInt(equation[0]);
        int b = Integer.parseInt(equation[2]);
        int answer=0;
        String operator = equation[1];

        switch (operator){
            case "+":
                answer = a + b;
                break;
            case "-":
                answer = a - b;
                break;
            case"*":
                answer = a * b;
                break;
            case"/":
                answer = a / b;
                break;
            default:
        }
        cal.setAnswer(String.valueOf(answer));
    }
}
